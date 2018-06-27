package com.logicq.wify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.Genre;
import com.logicq.wify.model.Movie;
import com.logicq.wify.repo.MoviesRepository;

@Service
@Transactional
public class MoviesService {

	@Autowired
	MoviesRepository moviesRepository;

	@Transactional
	public void saveMovie(Movie movi) {
		moviesRepository.save(movi);

	}

	@Transactional
	public void saveMovies(List<Movie> movis) {
		moviesRepository.save(movis);

	}

	@Transactional(readOnly = true)
	public List<Movie> findMovies() {
		return moviesRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Movie> findMoviesAccordingToGneres(String genreType) {
		return moviesRepository.findByGenreType(genreType);
	}

	@Transactional(readOnly = true)
	public List<Movie> findMoviesAccordingToLanguage(String languageType) {
		return moviesRepository.findByLangType(languageType);
	}

	@Transactional(readOnly = true)
	public List<Movie> findMoviesAccordingToCategory(String moviType) {
		return moviesRepository.findByMoviType(moviType);
	}

	@Transactional(readOnly = true)
	public List<Movie> sortMoviesByRating() {
		return moviesRepository.findAllByOrderByRatingDesc();
	}

	@Transactional(readOnly = true)
	public List<Movie> sortMoviesByViews() {
		return moviesRepository.findAllByOrderByViwersDesc();
	}

	@Transactional
	public void delete(Movie movi) {
		moviesRepository.delete(movi);
	}

}
