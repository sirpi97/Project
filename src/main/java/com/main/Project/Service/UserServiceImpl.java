package com.main.Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.edu.SpringBoot.Entity.Employee;
import com.main.Project.Exception.ResourceNotFoundException;
//import com.edu.SpringBoot.Entity.Employee;
//import com.edu.SpringBoot.Entity.Employee;
import com.main.Project.Controller.HotelReservationController;
import com.main.Project.Entity.Reservation;
import com.main.Project.Entity.User;
import com.main.Project.Repository.ReservationRep;
import com.main.Project.Repository.UserRep;

@Service
public class UserServiceImpl  implements UserService {

	 
	private UserRep userrep;
	 
	 
	public UserServiceImpl(UserRep userrep) {
		super();
		this.userrep = userrep;
	}


	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		return userrep.findAll();
	}


	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user = userrep.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new ResourceNotFoundException("User","Id",id);
		}
	}
	


	@Override
	public void deleteUser(int id) {
		userrep.findById(id).orElseThrow(
				()->new ResourceNotFoundException("User","Id",id));
		
		userrep.deleteById(id);//13
		
	}


	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userrep.save(user);
	}


	@Override
	public User updateUser(int id, User user) {
		User use = new User();
		 try {
			 //orElseThrow();
			   use = userrep.findById(id).orElseThrow(
					 ()-> 		 new ResourceNotFoundException("User","Id",id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 String name=user.getFirstName();
		 use.setFirstName(name);
		 use.setAddress(user.getAddress());
		 //use.setCountry(user.getCountry());
		 use.setEmail(user.getEmail());
		 use.setLastName(user.getLastName());
		 //use.setLocation(user.getLocation());
		 use.setPhoneNo(user.getPhoneNo());
		 //use.setState(user.getState());
		 
			
		
		userrep.save(use);
		return use;
		}


	}
	
	



	

	