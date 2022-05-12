package com.drudmoviestore.entity;

public class User {
   Long id;
   String name;
   String usr;
   String pass;
   String country;
   String ocupation;
   

public User(String name, String usr, String pass, String country, String ocupation) {
	this.name = name;
	this.usr = usr;
	this.pass = pass;
	this.country = country;
	this.ocupation = ocupation;
}	
public User(String usr, String pass) {
	this.usr = usr;
	this.pass = pass;
}
public User() {
	
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
public String getUser() {
	return usr;
}
public void setUser(String usr) {
	this.usr = usr;
}
public String getPassword() {
	return pass;
}
public void setPassword(String pass) {
	this.pass = pass;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getOcupation() {
	return ocupation;
}
public void setOcupation(String ocupation) {
	this.ocupation = ocupation;
}
   
   
}
