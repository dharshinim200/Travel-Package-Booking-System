package com.example.demo.service;

import java.util.List;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;

public interface UserService {
  
	public abstract String saveUser(User user);

	public abstract User updateUser(User user);

	public abstract String removeUser(int userId);

	public abstract User getUser(int userId) throws UserNotFound;

	public abstract List<User> getAllUser();
	
}
