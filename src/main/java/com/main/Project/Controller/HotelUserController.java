package com.main.Project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Project.Entity.Reservation;
import com.main.Project.Entity.User;
import com.main.Project.Repository.ReservationRep;
import com.main.Project.Service.ReservationService;
import com.main.Project.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class HotelUserController
{
	private UserService userService;
	
	public HotelUserController(UserService userService)
	{
		super();
		this.userService=userService;
	}
	


		@GetMapping
		public  List<User> listAllUser() {
			
			return userService.listAllUser();
			
		}
		
		
		@GetMapping("{id}")
		public  User getUserById(@PathVariable("id") int id) {
			
			return userService.getUserById(id) ;
			
		}
		@PostMapping
		public ResponseEntity<User> saveUser(@RequestBody User user){
			return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
			
		}
		
		@DeleteMapping("{id}")

		public String deleteUser(@PathVariable("id") int id){
			userService.deleteUser(id);
			return ("User record deleted ");
			
		}
		@PutMapping("{id}")
		public ResponseEntity<User> updateUser(@PathVariable("id")int id , @RequestBody User user) {
			return new ResponseEntity<User>(userService.updateUser( id, user), HttpStatus.OK);
			
		}

	
}
