package com.main.Project.Security;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.Project.Entity.User;
import com.main.Project.Repository.UserRep;
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
    UserRep userrep;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Integer id = null;
		Optional<User> user = userrep.findById(id);
		user.orElseThrow(()-> new UsernameNotFoundException("Not found "+ email));
		
		return user.map(MyUserDetails::new).get();
		//return new MyUserDetails(user);
	}

}

