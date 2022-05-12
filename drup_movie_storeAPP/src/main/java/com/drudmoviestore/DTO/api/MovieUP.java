package com.drudmoviestore.DTO.api;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class MovieUP {
    
	public List<MovieDTO> ListMoviesUP() throws JsonMappingException, JsonProcessingException{
		
		Response response = null;
		WebTarget webTarget;
		Client client = ClientBuilder.newClient();
		List<MovieDTO> list = null;
		String responseJson = null;
		ObjectMapper objectMapper = new ObjectMapper();		
		
		
	        
		    webTarget = client.target("http://localhost:9090/pelicula/listar");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			response = invocationBuilder.get();
			
			System.out.println("Status "+ response.getStatus());
			
			if(response.getStatus() != 200) {
				throw new RuntimeException("failed: HTTP error code: "+ response.getStatus());
			}
			
			responseJson = response.readEntity(String.class);
			list = objectMapper.readValue(responseJson, new TypeReference<List<MovieDTO>>() {
				
			});
		
			if(response != null) {
				response.close();
			}
			if(client != null) {
				client.close();
			}
		
		
		return list;
	}
}
