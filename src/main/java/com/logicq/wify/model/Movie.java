package com.logicq.wify.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MOVIES")
public class Movie {

	@Id
	@Column(name = "MOVI_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long moviId;

	@Column(name = "MOVI_NAME")
	private String moviname;
	
	@Column(name = "MOVI_DESC", length = 100000)
	private String movidesc;
	
	@Column(name = "MOVI_SOURCE")
	private String movisource;
	
	@Column(name = "LANGUAGE")
	private String langType;
	
	@Column(name = "MOVI_TYPE")
	private String moviType;
	
	@Column(name = "GENER")
	private String genreType;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "RELASE_DATE")
	private Date relaseDate;
	
	@Column(name = "POSTER_URL")
	private String poster_url;
	
	@Column(name = "IMDB_RATING")
	private Double rating;
	
	@Column(name = "RUN_TIME")
	private String runTime;
	
	@Column(name = "VIWERS")
	private Integer viwers;
	
	@Column(name = "DIRECTOR")
	private String directors;
	
	@Column(name = "STARTS")
	private String stars;

	public Long getMoviId() {
		return moviId;
	}

	public void setMoviId(Long moviId) {
		this.moviId = moviId;
	}

	public String getMoviname() {
		return moviname;
	}

	public void setMoviname(String moviname) {
		this.moviname = moviname;
	}

	public String getMovidesc() {
		return movidesc;
	}

	public void setMovidesc(String movidesc) {
		this.movidesc = movidesc;
	}

	public String getMovisource() {
		return movisource;
	}

	public void setMovisource(String movisource) {
		this.movisource = movisource;
	}

	public String getLangType() {
		return langType;
	}

	public void setLangType(String langType) {
		this.langType = langType;
	}

	public String getMoviType() {
		return moviType;
	}

	public void setMoviType(String moviType) {
		this.moviType = moviType;
	}

	public String getGenreType() {
		return genreType;
	}

	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}

	public Date getRelaseDate() {
		return relaseDate;
	}

	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}

	public String getPoster_url() {
		return poster_url;
	}

	public void setPoster_url(String poster_url) {
		this.poster_url = poster_url;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public Integer getViwers() {
		return viwers;
	}

	public void setViwers(Integer viwers) {
		this.viwers = viwers;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	
}
