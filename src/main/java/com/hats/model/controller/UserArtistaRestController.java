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

import com.hats.model.entity.User;
import com.hats.model.entity.UserArtista;
import com.hats.model.service.IUserArtistaService;
import com.hats.model.service.IUserService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserArtistaRestController {
	
	private final Logger log = LoggerFactory.getLogger(UserArtistaRestController.class);
	
	
	@Autowired
	public IUserArtistaService userArtistaService;

	@GetMapping (value = "/usersartistas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserArtista> getUserArtistaList(){
		return userArtistaService.getAllUserArtistas();		
	}

	@GetMapping (value = "/userartista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserArtista getUserArtistaById(@PathVariable ("id") Integer id){
		return userArtistaService.getUserArtistaById(id);		
	}
	
	@PostMapping(value = "/userartistaadd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserArtista addUserArtista(@RequestBody UserArtista requestBody) {
		return userArtistaService.addUserArtista(requestBody);
	}
	
	@PutMapping(value = "/userartista/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserArtista updateUserArtista(@PathVariable("id") String id, @RequestBody UserArtista requestBody){
		return userArtistaService.updateUserArtista(requestBody);
	}
	
	@DeleteMapping(value = "/delete/userartista/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUserArtista(@PathVariable("id") Integer id) {
		userArtistaService.deleteUserArtistaById(id);
	}
}
