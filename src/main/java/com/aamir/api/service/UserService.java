package com.aamir.api.service;

import java.util.List;

import com.aamir.api.entity.User;

public interface UserService {
	
	public List<User> findAll();

	public User findOne(String userId);

	public User create(User user);

	public User update(String userId, User user);

	public void delete(String userId);
}
