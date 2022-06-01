package com.main.Project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.Project.Entity.User;
import com.main.Project.Entity.User;

@Repository
public interface UserRep extends JpaRepository<User, Integer> {

	//Optional<User> findByEmail(String email);

	//Optional<User> findByFirstName(String string);
	

	User save(User user);

	//Optional<User> findByEmail(String email);

	
}