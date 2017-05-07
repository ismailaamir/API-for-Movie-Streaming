package com.aamir.api.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
	@NamedQuery(name = "Movie.findByTopRated", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pSearchText "),
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title =:pSearchText"),
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pSearchText"),
	@NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre=:pSearchText"),
	@NamedQuery(name = "Movie.findByImdbId", query = "SELECT m FROM Movie m where m.imdbId=:pImdbId"),
	@NamedQuery(name = "Movie.sortByImdbRating", query = "Select m from Movie m WHERE m.type=:pSearchText ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.sortByImdbVotes", query = "Select m from Movie m WHERE m.genre=:pSearchText ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.sortByImdbYear", query = "Select m from Movie m WHERE m.year=:pSearchText ORDER BY m.year DESC")
})
public class Movie {
	@Id
	@Column(name="MOVIE_ID")
	private String movieId;
	@Column(unique = true)
	private String title;
	private String year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;;
	private String country;
	private String awards;
	private String poster;
	private String metascore;
	private String imdbRating;
	private String imdbVotes;
	@Column(unique = true)
	private String imdbId;
	private String type;
	@OneToMany(mappedBy="movie", cascade = CascadeType.ALL)
	private List<Comment> comment; 
	
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public Movie() {
		this.movieId = UUID.randomUUID().toString();
	}
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + ", type=" + type + ", comment="
				+ comment + "]";
	}


}
