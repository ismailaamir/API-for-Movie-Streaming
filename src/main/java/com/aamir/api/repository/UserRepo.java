package com.aamir.api.repository;

import java.util.List;

import com.aamir.api.entity.User;

public interface UserRepo {

	public List<User> findAll();

	public User findOne(String userId);
	
	public User findByEmail(String email);

	public User create(User user);

	public User update(User user);

	public void delete(User user);
}
