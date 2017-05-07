package com.aamir.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aamir.api.entity.Movie;
import com.aamir.api.exceptions.BadRequestException;
import com.aamir.api.exceptions.MovieNotFoundException;
import com.aamir.api.repository.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String movieId) {

		Movie existing = repository.findOne(movieId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with given id " + movieId + " does not exist");
		}

		return existing;
	}

	@Override
	public List<Movie> findByTopRated(String type) {
		return repository.findByTopRated(type);
	}

	@Override
	public List<Movie> findByTYG(String TYG, String searchtext) {
		return repository.findByTYG(TYG, searchtext);
	}

	@Override
	public List<Movie> findByTitle(String searchtext) {
		return repository.findByTitle(searchtext);
	}

	@Override
	public List<Movie> sortByImdb(String TYG, String searchtext) {
		return repository.sortByImdb(TYG, searchtext);
	}

	@Override
	public Movie findByImdbId(String imdbId) {
		List<Movie> movielist = repository.findByImdbId(imdbId);
		if (movielist != null && movielist.size() == 1) {
			return movielist.get(0);
		}
		return null;

	}

	@Override
	@Transactional
	public Movie create(Movie mov) {
		List<Movie> movie = repository.findByTitle(mov.getTitle());
		if (movie != null && movie.size() == 1) {
			throw new BadRequestException("Movie with given title: " + mov.getTitle() + " already exists");
		}
		return repository.create(mov);

	}

	@Override
	@Transactional
	public Movie update(String movieId, Movie mov) {
		Movie existing = repository.findOne(movieId);
		if (existing != null) {
			throw new MovieNotFoundException("Movie with given id " + movieId + " does not exist");
		}
		return repository.update(mov);
	}

	@Override
	@Transactional
	public void delete(String movieId) {
		Movie existing = repository.findOne(movieId);
		if (existing == null) {
			throw new MovieNotFoundException("User with given id " + movieId + " does not exist");
		}
		repository.delete(existing);
	}

}
