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

import com.hats.model.entity.Artista;
import com.hats.model.entity.User;
import com.hats.model.entity.UserArtista;
import com.hats.model.service.IArtistaService;
import com.hats.model.service.IUserArtistaService;
import com.hats.model.service.IUserService;

//Controlador REST de Artistas//


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ArtistaRestController {
	
	private final Logger log = LoggerFactory.getLogger(ArtistaRestController.class);
	
	
	@Autowired
	public IArtistaService artistaService;
	
	
	//Metodo GET para obtener a todos los artistas guardados en la base de datos//
	@GetMapping (value = "/artistas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Artista> getArtistasList(){
		return artistaService.getAllArtistas();		
	}
	
	//Metodo GET para obtener un solo artista en la base de datos//
	@GetMapping (value = "/artista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Artista getArtistaById(@PathVariable ("id") Integer id){
		return artistaService.getArtistaById(id);		
	}
	
	//Metodo POST para añadir artistas//
	@PostMapping(value = "/artistaadd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Artista addArtista(@RequestBody Artista requestBody) {
		return artistaService.addArtista(requestBody);
	}
	
	//Metodo PUT para modificar los datos de un artista//
	@PutMapping(value = "/artista/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Artista updateArtista(@PathVariable("id") String id, @RequestBody Artista requestBody){
		return artistaService.updateArtista(requestBody);
	}
	
	//Metodo DELETE para borrar un artista//
	@DeleteMapping(value = "/delete/artista/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteArtista(@PathVariable("id") Integer id) {
		artistaService.deleteArtistaById(id);
	}
}
