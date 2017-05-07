package com.aamir.api.repository;

import java.util.List;

import com.aamir.api.entity.Movie;

public interface MovieRepo {
	
	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public List<Movie> findByTopRated(String type);

	public List<Movie> findByTYG(String TYG, String searchtext);

	public List<Movie> findByTitle(String searchtext);

	public List<Movie> sortByImdb(String TYG, String searchtext);

	public List<Movie> findByImdbId(String imdbId);

	public Movie create(Movie mov);

	public Movie update(Movie mov);

	public void delete(Movie mov);
}
