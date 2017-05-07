package com.aamir.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aamir.api.entity.Comment;
import com.aamir.api.exceptions.CommentNotFoundException;
import com.aamir.api.repository.CommentRepo;

@Repository
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo repository;

	@Override
	public List<Comment> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Comment> findAllCommentsonMovie(String movieId) {
		return repository.findAllCommentsonMovie(movieId);
	}

	@Override
	public Comment findOne(String commentId) {
		Comment existing = repository.findOne(commentId);
		if (existing == null) {
			throw new CommentNotFoundException("Comment with given id " + commentId + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Comment create(Comment comment) {
		return repository.create(comment);
	}

	@Override
	@Transactional
	public Comment update(String commentId, Comment comment) {
		Comment existing = repository.findOne(commentId);
		if (existing == null) {
			throw new CommentNotFoundException("Comment with given id " + commentId + " not found");
		}
		return repository.update(comment);
	}

	@Override
	@Transactional
	public void delete(String commentId) {
		Comment existing = repository.findOne(commentId);
		if (existing == null) {
			throw new CommentNotFoundException("Comment with given id " + commentId + " not found");
		}
		repository.delete(existing);
	}

}
