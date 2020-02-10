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
import com.hats.model.service.IUserService;

//Controlador REST de Usuarios//


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	private final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	
	@Autowired
	public IUserService userService;

	
	//Metodo GET para obtener a todas los usuarios guardadoss en la base de datos//
	@GetMapping (value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUserList(){
		return userService.getAllUsers();		
	}

	//Metodo GET para obtener un solo usuario de la base de datos//
	@GetMapping (value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable ("id") Integer id){
		return userService.getUserById(id);		
	}
	
	//Metodo POST para añadir un usuario//
	@PostMapping(value = "/useradd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User requestBody) {
		return userService.addUser(requestBody);
	}
	
	//Metodo PUT para modificar los datos de un usuario//
	@PutMapping(value = "/user/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@PathVariable("id") String id, @RequestBody User requestBody){
		return userService.updateUser(requestBody);
	}
	
	//Metodo DELETE para borrar un usuario//
	@DeleteMapping(value = "/delete/user/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
	}
}
