package com.aamir.api.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c "),
	@NamedQuery(name = "Comment.findCommentsOnMovie", query = "SELECT c FROM Comment c WHERE c.movie.movieId=:pMovieId"),
	
})
public class Comment {

	@Id
	private String commId;
	private String commText;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="MOVIE_ID")
	private Movie movie;

	public Comment(){
		this.commId = UUID.randomUUID().toString();
	}
	
	public String getCommId() {
		return commId;
	}

	public void setCommId(String commId) {
		this.commId = commId;
	}

	public String getCommText() {
		return commText;
	}

	public void setCommText(String commText) {
		this.commText = commText;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Comment [commId=" + commId + ", commText=" + commText + ", user=" + user + ", movie=" + movie + "]";
	}
	
	
}
