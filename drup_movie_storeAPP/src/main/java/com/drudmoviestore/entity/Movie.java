package com.drudmoviestore.entity;

public class Movie {
	
	
	private Long id;
	private String name;
	private String gender;
	private String director;
	private String summary;
	
	
	
	public Movie(String name, String gender, String director, String summary) {
		super();
		this.name = name;
		this.gender = gender;
		this.director = director;
		this.summary = summary;
	}
	public Movie() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	

}
