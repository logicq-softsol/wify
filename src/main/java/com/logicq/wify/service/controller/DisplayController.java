package com.logicq.wify.service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.wify.model.Movie;
import com.logicq.wify.service.LanguageService;
import com.logicq.wify.service.MoviesService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/display")
public class DisplayController {

	@Autowired
	MoviesService moviesService;

	@Autowired
	LanguageService languageService;

	@RequestMapping(value = "/movies/{category}", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findMoviesAccordingToCategory(@PathVariable String category) {
		return new ResponseEntity<List<Movie>>(moviesService.findMoviesAccordingToCategory(category), HttpStatus.OK);
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findMovies() {
		return new ResponseEntity<List<Movie>>(moviesService.findMovies(), HttpStatus.OK);
	}

	@RequestMapping(value = "/moviesAccordingToGenres/{genres}", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findMoviesAccordingToGenres(@PathVariable String genres) {
		return new ResponseEntity<List<Movie>>(moviesService.findMoviesAccordingToGneres(genres), HttpStatus.OK);
	}

	@RequestMapping(value = "/moviesAccordingToLanguage/{lang}", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findMoviesAccordingToLanguage(@PathVariable String lang) {
		return new ResponseEntity<List<Movie>>(moviesService.findMoviesAccordingToLanguage(lang), HttpStatus.OK);
	}

	@RequestMapping(value = "/movies", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> updateMovi(@RequestBody Movie movi) {
		moviesService.saveMovie(movi);
		return new ResponseEntity<Movie>(movi, HttpStatus.OK);
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> createMovi(@RequestBody Movie movi) {
		moviesService.saveMovie(movi);
		return new ResponseEntity<Movie>(movi, HttpStatus.OK);
	}

	@RequestMapping(value = "/movies", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> createMovi(@RequestBody List<Movie> movis) {
		moviesService.saveMovies(movis);
		return new ResponseEntity<List<Movie>>(movis, HttpStatus.OK);
	}

	@RequestMapping(value = "/movies/{moviId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> deleteMovi(@PathVariable Long moviId) {
		Movie movi = new Movie();
		movi.setMoviId(moviId);
		moviesService.delete(movi);
		return new ResponseEntity<Movie>(movi, HttpStatus.OK);
	}

	@RequestMapping(value = "/recentMovies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findRecentMovies() {
		List<Movie> recentMovies = moviesService.findMoviesAccordingToCategory("NEW");
		// Map<String, List<Movie>> movies =
		// recentMovies.stream().collect(Collectors.groupingBy(Movie::getLangType));
		return new ResponseEntity<List<Movie>>(recentMovies, HttpStatus.OK);
	}

	@RequestMapping(value = "/popularMovies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> popularMovies() {
		List<Movie> movies = moviesService.sortMoviesByViews();
		List<Movie> filtermovies = movies.stream().filter(mov -> !(mov.getMoviType().equals("NEW"))).collect(Collectors.toList());
		return new ResponseEntity<List<Movie>>(filtermovies, HttpStatus.OK);
	}

	@RequestMapping(value = "/topRatedMovies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> topRatedMovies() {
		List<Movie> movies = moviesService.sortMoviesByRating();
		List<Movie> filtermovies = movies.stream().filter(mov -> !(mov.getMoviType().equals("NEW"))).collect(Collectors.toList());
		return new ResponseEntity<List<Movie>>(filtermovies, HttpStatus.OK);
	}

	@RequestMapping(value = "/upComingMovies", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> upComingMovies() {
		return new ResponseEntity<List<Movie>>(moviesService.findMoviesAccordingToCategory("UPCOMING"), HttpStatus.OK);
	}

}
