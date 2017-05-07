package com.aamir.api.service;

import java.util.List;

import com.aamir.api.entity.Comment;

public interface CommentService {
	public List<Comment> findAll();

	public List<Comment> findAllCommentsonMovie(String movieId);

	public Comment findOne(String commentId);

	public Comment create(Comment comment);

	public Comment update(String commentId, Comment comment);

	public void delete(String commentId);

}
