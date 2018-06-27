package com.logicq.wify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.wify.model.Language;
import com.logicq.wify.model.Movie;
import com.logicq.wify.repo.LanguageRepository;
import com.logicq.wify.repo.MoviesRepository;

@Service
@Transactional
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;

	@Transactional
	public void saveLanguage(Language lang) {
		languageRepository.save(lang);

	}
	
	@Transactional
	public void saveLanguages(List<Language> langs) {
		languageRepository.save(langs);
	}

	@Transactional(readOnly = true)
	public List<Language> findLanguages() {
		return languageRepository.findAll();
	}

	@Transactional
	public void delete(Language lang) {
		languageRepository.delete(lang);
	}

}
