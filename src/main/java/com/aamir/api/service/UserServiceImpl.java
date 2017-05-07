package com.aamir.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aamir.api.entity.User;
import com.aamir.api.exceptions.BadRequestException;
import com.aamir.api.exceptions.UserNotFoundException;
import com.aamir.api.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findOne(String userId) {
		User user = repository.findOne(userId);
		if (user == null) {
			throw new UserNotFoundException("User with given id "+ userId +" does not exist");
		}
		return user;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing!=null) {
			throw new BadRequestException("User with Email: "+user.getEmail()+" already exists");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String userId, User user) {
		User existing = repository.findOne(userId);
		if (existing == null) {
			throw new UserNotFoundException("User with given id "+ userId +" does not exist");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String userId) {
		User existing = repository.findOne(userId);
		if (existing == null) {
			throw new UserNotFoundException("User with given id "+ userId +" does not exist");
		}
		repository.delete(existing);
	}

}
