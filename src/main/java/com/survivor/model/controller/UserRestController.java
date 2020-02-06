package com.survivor.model.controller;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.survivor.model.entity.User;
import com.survivor.model.service.IUploadFileService;
import com.survivor.model.service.IUserService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	private final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	
	@Autowired
	public IUserService userService;

	
	@GetMapping("/users")
	public List<User> list(){
		return userService.findAll();
		
	}
	
	@GetMapping("/users/page/{page}")
	public Page<User> list(@PathVariable Integer page){
		Pageable pag = PageRequest.of(page, 4);
		return userService.findAll(pag);
		
	}
	
	@GetMapping("/users/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
		
		User user = null;
		Map<String, Object> response = new HashMap<>();

		try {
			user = userService.findByID(id);
		} catch (DataAccessException e) {
			response.put("mensaje", e.getMessage().concat(": ").concat("Error acces database"));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(user == null) {
			response.put("mensaje", "User ID: ".concat(id.toString()).concat(" no exist"));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK); 
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> create(@Valid @RequestBody User usr, BindingResult result) {
		User usrNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo: " + err.getField() + " " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			usrNew = userService.save(usr);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error creating new user");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "user created");
		response.put("user", usrNew);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody User usr,BindingResult result,  @PathVariable Integer id) {
		
		User currentUser = userService.findByID(id);
		User userUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo: " + err.getField() + " " + err.getDefaultMessage();
			}).collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(currentUser == null) {
			response.put("mensaje", "Cant Edit: User ID: ".concat(id.toString()).concat(" no exist"));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			
		currentUser.setEmail(usr.getEmail());
		currentUser.setName(usr.getName());
		currentUser.setLastname(usr.getLastname());
		currentUser.setCreatedAt(usr.getCreatedAt());
		
		userUpdated = userService.save(currentUser);
		
		}catch (DataAccessException e) {
			
				response.put("mensaje", "Error updating new user");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("mensaje", "user updated");
		response.put("user", userUpdated);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			/*borramos si esta vinculado un archivo (imagen)*/
			User usr = userService.findByID(id);
			String nombreFotoAnterior = usr.getFoto();
			//borramos el recurso
			uploadService.eliminar(nombreFotoAnterior);
			/*borramos el objeto*/
			userService.delete(id);
			
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error in delete usr");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("ok", "user deleted");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		
	}	
	
	
	@PostMapping("/users/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Integer id) {
		
		Map<String,Object> response = new HashMap<>();
		User usr = userService.findByID(id);
		
		if(archivo != null && archivo.isEmpty() == false) {
			String nombreArchivo = null;
			try {
				
				nombreArchivo = uploadService.copiar(archivo);
				
			} catch (Exception e) {
				e.printStackTrace();
				response.put("mensaje", "error al subir la imagen: "+nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			/*borrado imagen anterior*/
			String nombreFotoAnterior = usr.getFoto();
			uploadService.eliminar(nombreFotoAnterior);
			
			
			/*persist guardado*/
			usr.setFoto(nombreArchivo);
			userService.save(usr);
			
			response.put("user", usr);
			response.put("mensaje", "Has subido correctamente la imagen: "+nombreArchivo);
			
		}
		
		
	
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verImagen(@PathVariable String nombreFoto){
		
		Resource recurso = null;
		try {
			recurso = uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso,headers,HttpStatus.OK);
		
	}
	

	

}
