package com.logicq.wify.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.Movie;

@Transactional
public interface MoviesRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByGenreType(String genreType);

	List<Movie> findByLangType(String languageType);

	List<Movie> findAllByOrderByRatingDesc();
	List<Movie> findAllByOrderByViwersDesc();
	List<Movie> findByMoviType(String moviType);
	

}
