package com.aamir.api.controller;

import com.aamir.api.entity.*;
import com.aamir.api.service.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "comments")
public class CommentController {

	@Autowired
	private CommentService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Comment> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "movie/{id}")
	public List<Comment> findAllCommentsonMovie(@PathVariable("id") String movieId) {

		return service.findAllCommentsonMovie(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Comment findOne(@PathVariable("id") String commentId) {

		return service.findOne(commentId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Comment create(@RequestBody Comment comment) {

		return service.create(comment);
	}

	@RequestMapping(method = RequestMethod.PUT, value = { "id" })
	public Comment update(@PathVariable("id") String commentId, @RequestBody Comment comment) {

		return service.update(commentId, comment);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = { "id" })
	public void delete(@PathVariable("id") String commentId) {

		service.delete(commentId);
	}

}
