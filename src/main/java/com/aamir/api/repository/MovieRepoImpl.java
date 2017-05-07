package com.aamir.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.aamir.api.entity.Movie;

@Repository
public class MovieRepoImpl implements MovieRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public List<Movie> findByTopRated(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTopRated", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();

	}

	@Override
	public List<Movie> findByTYG(String TYG, String searchtext) {
		TypedQuery<Movie> query;
		if (TYG.equals("type")) {
			query = em.createNamedQuery("Movie.findByType", Movie.class);
		} else if (TYG.equals("year")) {
			query = em.createNamedQuery("Movie.findByYear", Movie.class);
		} else if (TYG.equals("genre")) {
			query = em.createNamedQuery("Movie.findByGenre", Movie.class);
		} else {
			return findAll();
		}
		query.setParameter("pSearchText", searchtext);
		return query.getResultList();
	}

	// checkagain
	@Override
	public List<Movie> findByTitle(String searchtext) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pSearchText", searchtext);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortByImdb(String TYG, String searchtext) {
		TypedQuery<Movie> query;
		if (TYG.equals("type")) {
			query = em.createNamedQuery("Movie.sortByImdbRating", Movie.class);
		} else if (TYG.equals("year")) {
			query = em.createNamedQuery("Movie.sortByImdbVotes", Movie.class);
		} else if (TYG.equals("Genre")) {
			query = em.createNamedQuery("Movie.sortByImdbYear", Movie.class);
		} else {
			return findAll();
		}
		query.setParameter("pSearchText", searchtext);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByImdbId(String imdbId) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByImdbId", Movie.class);
		query.setParameter("pImdbId", imdbId);
		return query.getResultList();
	}

	@Override
	public Movie create(Movie mov) {
		em.persist(mov);
		return mov;
	}

	@Override
	public Movie update(Movie mov) {
		return em.merge(mov);
	}

	@Override
	public void delete(Movie mov) {
		em.remove(mov);

	}

}
