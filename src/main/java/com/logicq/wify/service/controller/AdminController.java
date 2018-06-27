package com.logicq.wify.service.controller;

import java.util.List;

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

import com.logicq.wify.model.FacilityDetails;
import com.logicq.wify.model.FacilityRequest;
import com.logicq.wify.model.Genre;
import com.logicq.wify.model.Language;
import com.logicq.wify.repo.FacilityDetailsRepository;
import com.logicq.wify.repo.FacilityRequestRepository;
import com.logicq.wify.service.GenresService;
import com.logicq.wify.service.LanguageService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/admin/setup")
public class AdminController {

	@Autowired
	LanguageService languageService;

	@Autowired
	GenresService genresService;

	@Autowired
	FacilityDetailsRepository facilityDetailsRepository;

	@Autowired
	FacilityRequestRepository facilityRequestRepository;

	@RequestMapping(value = "/facility", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacilityDetails> createFaility(@RequestBody FacilityDetails facilityDetails) {
		facilityDetailsRepository.save(facilityDetails);
		return new ResponseEntity<FacilityDetails>(facilityDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/facility", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacilityDetails> updateFaility(@RequestBody FacilityDetails facilityDetails) {
		facilityDetailsRepository.save(facilityDetails);
		return new ResponseEntity<FacilityDetails>(facilityDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/facility", method = RequestMethod.GET)
	public ResponseEntity<List<FacilityDetails>> findAllFaility() {
		return new ResponseEntity<List<FacilityDetails>>(facilityDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/requestFacility", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacilityRequest> createFailityRequest(@RequestBody FacilityRequest facilityRequest) {
		facilityRequestRepository.save(facilityRequest);
		return new ResponseEntity<FacilityRequest>(facilityRequest, HttpStatus.OK);
	}

	@RequestMapping(value = "/requestFacility", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacilityRequest> updateFailityRequest(@RequestBody FacilityRequest facilityRequest) {
		facilityRequestRepository.save(facilityRequest);
		return new ResponseEntity<FacilityRequest>(facilityRequest, HttpStatus.OK);
	}

	@RequestMapping(value = "/requestFacility", method = RequestMethod.GET)
	public ResponseEntity<List<FacilityRequest>> findFailityRequest() {
		return new ResponseEntity<List<FacilityRequest>>(facilityRequestRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/requestFacilityForStatus/{status}", method = RequestMethod.GET)
	public ResponseEntity<List<FacilityRequest>> findFailityRequestAccordingToStatus(@PathVariable String status) {
		return new ResponseEntity<List<FacilityRequest>>(facilityRequestRepository.findByStatus(status), HttpStatus.OK);
	}

	@RequestMapping(value = "/language", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Language> addLanguage(@RequestBody Language lang) {
		languageService.saveLanguage(lang);
		return new ResponseEntity<Language>(lang, HttpStatus.OK);
	}

	@RequestMapping(value = "/languages", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Language>> addLanguages(@RequestBody List<Language> langs) {
		languageService.saveLanguages(langs);
		return new ResponseEntity<List<Language>>(langs, HttpStatus.OK);
	}

	@RequestMapping(value = "/genre", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genre> addGenre(@RequestBody Genre genre) {
		genresService.saveGenre(genre);
		return new ResponseEntity<Genre>(genre, HttpStatus.OK);
	}

	@RequestMapping(value = "/genres", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Genre>> addGenres(@RequestBody List<Genre> genres) {
		genresService.saveGenres(genres);
		return new ResponseEntity<List<Genre>>(genres, HttpStatus.OK);
	}

	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public ResponseEntity<List<Language>> findlanguages() {
		return new ResponseEntity<List<Language>>(languageService.findLanguages(), HttpStatus.OK);
	}

	@RequestMapping(value = "/genres", method = RequestMethod.GET)
	public ResponseEntity<List<Genre>> findGenres() {
		return new ResponseEntity<List<Genre>>(genresService.findGenres(), HttpStatus.OK);
	}

	@RequestMapping(value = "/language", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Language> updateLanguage(@RequestBody Language lang) {
		languageService.saveLanguage(lang);
		return new ResponseEntity<Language>(lang, HttpStatus.OK);
	}

	@RequestMapping(value = "/genres", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genre> updateGenres(@RequestBody Genre genr) {
		genresService.saveGenre(genr);
		return new ResponseEntity<Genre>(genr, HttpStatus.OK);
	}

	@RequestMapping(value = "/genres/{genrId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genre> deleteGenres(@PathVariable Long genrId) {
		Genre gen = new Genre();
		gen.setGenerId(genrId);
		genresService.delete(gen);
		return new ResponseEntity<Genre>(gen, HttpStatus.OK);
	}

	@RequestMapping(value = "/language/{langId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Language> deleteLanguage(@PathVariable Long langId) {
		Language lang = new Language();
		lang.setLangId(langId);
		languageService.delete(lang);
		return new ResponseEntity<Language>(lang, HttpStatus.OK);
	}
}
