package com.logicq.wify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.Genre;
import com.logicq.wify.repo.GenresRepository;

@Service
@Transactional
public class GenresService {

	@Autowired
	GenresRepository genresRepository;

	@Transactional
	public void saveGenre(Genre genre) {
		genresRepository.save(genre);

	}

	@Transactional
	public void saveGenres(List<Genre> genre) {
		genresRepository.save(genre);

	}

	@Transactional(readOnly = true)
	public List<Genre> findGenres() {
		return genresRepository.findAll();
	}

	@Transactional
	public void delete(Genre genre) {
		genresRepository.delete(genre);
	}

}
