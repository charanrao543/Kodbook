package com.kodbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kodbook.entity.User;
import com.kodbook.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository repo;
	
	
	public void addUser(@ModelAttribute User user) {
		repo.save(user);
		
	}


	
	public boolean userExists(String username, String email) {
		User user1 = repo.findByUsername(username);
		User user2 = repo.findByEmail(email);
		
		if(user1 != null || user2 != null  ) {
			
			return true;
		}
		return false;
	}



	@Override
	public boolean validateUser(String username, String password) {
			User username1 = repo.findByUsername(username);
			if(username1 == null) {
				return false;
			}
			
			String db_password = repo.findByUsername(username).getPassword();
			if(db_password.equals(password)) {
				return true;
			}
		return false;
	}



	@Override
	public User getUser(String username) {
		
		return repo.findByUsername(username);
	}



	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}

	
	

	
	

	
}
