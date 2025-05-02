package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {



	@Autowired
	UserRepository repository;


	@Override
	public String saveUser(User user) {
		User user2 = repository.save(user);
		if (user2 != null) {
			return "successfully saved";

		} else {
			return "Not saved";
		}
	}

	@Override
	public User updateUser(User user) {
		User user2=repository.save(user);
		return user2;
	}

	@Override
	public String removeUser(int userId) {

        repository.deleteById(userId);
		return "deleted successfully";
		
	}

	@Override
	public User getUser(int userId) throws UserNotFound {
       
		Optional<User> optional= repository.findById(userId);
		if(optional.isPresent()) {
		return optional.get();
		}
		else
			throw new UserNotFound("Not found");
	}

	@Override
	public List<User> getAllUser() {
        return repository.findAll();
	}

}
