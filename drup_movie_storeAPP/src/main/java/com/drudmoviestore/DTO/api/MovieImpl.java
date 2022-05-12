package com.drudmoviestore.DTO.api;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class MovieImpl {
   
	public static void main(String[] args) {
		MovieUP mv = new MovieUP();
		List<MovieDTO> list = null;
		try {
			list = mv.ListMoviesUP();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		for(MovieDTO m : list) {
			System.out.println(m.getName());
			System.out.println(m.getGender());
			System.out.println(m.getDirector());
			System.out.println(m.getSummary());
		}
	}
}
/* 
 * usersul for single values json
 * 
File jsonFile = new File("./src/main/resources/test.json");

ObjectMapper mapper = new ObjectMapper();
mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

Orgnization root = mapper.readValue(jsonFile, Orgnization.class);
System.out.println(root);
*/
