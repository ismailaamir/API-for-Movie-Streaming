package com.aamir.api.service;

import java.util.List;


import com.aamir.api.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public List<Movie> findByTopRated(String type);

	public List<Movie> findByTYG(String TYG, String searchtext);

	public List<Movie> findByTitle(String searchtext);

	public List<Movie> sortByImdb(String TYG, String searchtext);

	public Movie findByImdbId(String imdbId);

	public Movie create(Movie mov);

	public Movie update(String movieId, Movie mov);

	public void delete(String movieId);

}
