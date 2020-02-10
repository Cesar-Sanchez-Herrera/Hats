package com.hats.model.controller;

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
import org.springframework.http.MediaType;
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

import com.hats.model.entity.Publicaciones;
import com.hats.model.entity.User;
import com.hats.model.service.IPublicacionesService;
import com.hats.model.service.IUserService;

//Controlador REST de Publicaciones//


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PublicacionesRestController {
	
	private final Logger log = LoggerFactory.getLogger(PublicacionesRestController.class);
	
	
	@Autowired
	public IPublicacionesService publicacionesService;

	
	//Metodo GET para obtener a todas las publicaciones guardadas en la base de datos//
	@GetMapping (value = "/publicaciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Publicaciones> getPublicacionesList(){
		return publicacionesService.getAllPublicaciones();		
	}

	//Metodo GET para obtener una sola publicacion de la base de datos//
	@GetMapping (value = "/publicacion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Publicaciones getPublicacionById(@PathVariable ("id") Integer id){
		return publicacionesService.getPublicacionById(id);		
	}
	
	//Metodo POST para añadir una publicacion//
	@PostMapping(value = "/publicacionadd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Publicaciones addPublicacion(@RequestBody Publicaciones requestBody) {
		return publicacionesService.addPublicacion(requestBody);
	}
	
	//Metodo PUT para modificar los datos de una publicacion//
	@PutMapping(value = "/publicacion/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Publicaciones updatePublicacion(@PathVariable("id") String id, @RequestBody Publicaciones requestBody){
		return publicacionesService.updatePublicacion(requestBody);
	}
	
	//Metodo DELETE para borrar una publicacion//
	@DeleteMapping(value = "/delete/publicacion/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletePublicacion(@PathVariable("id") Integer id) {
		publicacionesService.deletePublicacionById(id);
	}
}
