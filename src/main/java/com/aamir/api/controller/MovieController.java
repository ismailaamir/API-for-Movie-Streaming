package com.aamir.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aamir.api.entity.*;
import com.aamir.api.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET, value = "movies")
	public List<Movie> findAll() {
		return service.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, value = "movies/{id}")
	public Movie findOne(@PathVariable("id") String movieId) {
		return service.findOne(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "movies/find/toprated/{type}")
	public List<Movie> findByTopRated(@PathVariable("type") String type) {

		return service.findByTopRated(type);
	}

	@RequestMapping(method = RequestMethod.GET, value = "movies/find/filter/{TYG}/{searchtext}")
	public List<Movie> findByTYG(@PathVariable("TYG") String TYG, @PathVariable("searchtext") String searchtext) {

		return service.findByTYG(TYG, searchtext);
	}

	@RequestMapping(method = RequestMethod.GET, value = "movies/find/{searchtext}")
	public List<Movie> findByTitle(@PathVariable("searchtext") String searchtext) {
		return (List<Movie>) service.findByTitle(searchtext);
	}

	@RequestMapping(method = RequestMethod.GET, value = "movies/sort/{TYG}/{searchtext}")
	public List<Movie> sortByImdb(@PathVariable("TYG") String TYG, @PathVariable("searchtext") String searchtext) {
		return service.sortByImdb(TYG, searchtext);
	}

	@RequestMapping(method = RequestMethod.GET, value = "movies/find/imdb/{imdbId}")
	public Movie findByImdbId(@PathVariable("imdbId") String imdbId) {
		return service.findByImdbId(imdbId);

	}

	@RequestMapping(method = RequestMethod.POST, value = "admin")
	public Movie create(@RequestBody Movie mov) {
		return service.create(mov);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "admin/{id}")
	public Movie update(@PathVariable("id") String movieId, @RequestBody Movie mov) {
		return service.update(movieId, mov);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "admin/{id}")
	public void delete(@PathVariable("id") String movieId) {
		service.delete(movieId);
	}

}
