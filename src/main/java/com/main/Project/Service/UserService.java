package com.main.Project.Service;

import java.util.List;
import java.util.Optional;

import com.main.Project.Entity.User;

public interface UserService {

	User saveUser(User user);

	
	

	User getUserById(int id);

	User updateUser(int id, User user);

	void deleteUser(int id);




	List<User> listAllUser();




	//Optional<User> getUserByFirstName(String firstName);


}
