package com.aamir.api.repository;

import java.util.List;

import com.aamir.api.entity.Comment;

public interface CommentRepo {
	
	public List<Comment> findAll();

	public List<Comment> findAllCommentsonMovie(String movieId);

	public Comment findOne(String commentId);

	public Comment create(Comment comment);

	public Comment update(Comment comment);

	public void delete(Comment comment);

}
