package com.training.Springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.Springboot.entity.User;
import com.training.Springboot.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}
	

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public void updateUser(int id,User user) {
		// TODO Auto-generated method stub
		Optional<User> oldUser = repository.findById(id);
					
		if (oldUser.isPresent()) {
			User userobj = oldUser.get();
			userobj.setFirstName(user.getFirstName());
			userobj.setLastName(user.getLastName());
			userobj.setAge(user.getAge());
			userobj.setGender(user.getGender());
			repository.save(userobj);

		} else {
				System.out.println("No data found");
		}					
		}

	@Override
	public User getUserByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return repository.findByFirstName(firstName);
	}

	@Override
	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			  repository.deleteById(id);
		}
		return null;
	

	}	
	}

