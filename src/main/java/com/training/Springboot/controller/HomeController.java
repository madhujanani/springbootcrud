package com.training.Springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.Springboot.entity.User;
import com.training.Springboot.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	UserService service;
	
	@GetMapping("/greet")
	//@ResponseBody
	public String greet() {
		return"Hi there..Spring Boot Demo !!";//ln =14 @responsebody to get this string in browser previosly what ever we give in return becomes  jsp files.add this resbody to see o/p in browser
		//@RestController=@responsebody+Controller-->earlier it was controller  ln9,changed restcontroller to remove controller and response body...
	}
	@GetMapping("/users")
	public ResponseEntity< List<User> >users(){  // as we need to give the httpstatus to client,, we should not use thes user class object directly,,so we are using ResponseEntity to also send the httpstatus.
		/*List<User> userList = new ArrayList<>();
		userList.add(new User("Anu","shar",23,'F'));
		userList.add(new User("Banu","var",25,'F'));
		userList.add(new User("caleb","nox",26,'M'));
		userList.add(new User("david","bro",27,'M'));
		userList.add(new User("emiley","ethan",25,'F'));*/
		List <User>userList = service.getUsers();
		return  new ResponseEntity<>(userList,HttpStatus.OK);
		}
	
	@PostMapping("/user")//to create a new row of record
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = service.addUser(user);
		return  new ResponseEntity<>(newUser,HttpStatus.CREATED);//if we dont wantresponse back then avoid newUser
	}
	@GetMapping("/user/{id}")//get the row by unique id
	public ResponseEntity<User>getUserById(@PathVariable("id")int id){
		return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")// to update any date in table
	public ResponseEntity updateUser(@PathVariable("id")int id,@RequestBody User user) {
		service.updateUser(id,user);
		return new ResponseEntity(HttpStatus.OK);	
	}
	@GetMapping("/user/byName/{firstName}")//get the data by  firstname
	public ResponseEntity<User> getUserByName(@PathVariable("firstName") String firstName){
		 return new ResponseEntity<>(service.getUserByFirstName(firstName),HttpStatus.OK);		
		 }
	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteUserById(@PathVariable("id")int id) {
		service.deleteUserById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);	
	}
	
	}
	


