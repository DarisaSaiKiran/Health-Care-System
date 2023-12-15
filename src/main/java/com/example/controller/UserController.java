package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.exception.InvalidCredentialsException;
import com.example.exception.UserNotFoundException;
import com.example.model.Users;
import com.example.service.UserService;

@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService user;

	@PostMapping("/users")
	public Users registerUser( @RequestBody Users users) {
		return user.saveUser(users);
	}

	@GetMapping("/users")
	public List<Users> getUsers() {
		return user.getAll();

	}
	
	
	@PostMapping(value="/login")
	public ResponseEntity<String>loginUser(@RequestParam Integer userId,@RequestParam String password)throws InvalidCredentialsException{
		
		return new ResponseEntity<>(user.login(userId,password),HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		return user.removeUser(id);
	}
	@GetMapping(value = "/users/{id}")
	public String getUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
		if (user.getUserById(id).isEmpty())
			throw new UserNotFoundException();
//		System.out.println("Fetched Successfully");
		return user.getUserById(id);
	}
	
	@PutMapping("/users/{id}")
	public Users updateUser(@RequestBody Users users ,@PathVariable int id) {
		users.setId(id);
		return user.updateUser(users);
	}
	
}
