package com.aamir.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aamir.api.entity.User;
import com.aamir.api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String userId) {
		return service.findOne(userId);

	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return service.create(user);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public User update(@PathVariable("id") String userId, @RequestBody User user) {
		return service.update(userId, user);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String userId) {
		service.delete(userId);
	}

}
