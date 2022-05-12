package com.drudmoviestore.service;

import java.util.List;
import java.util.Map;

import com.drudmoviestore.DTO.api.MovieDTO;
import com.drudmoviestore.DTO.api.MovieUP;
import com.drudmoviestore.dao.MovieDao;
import com.drudmoviestore.entity.Movie;
import com.drudmoviestore.movie.dao.Impl.MovieDaoImpl;

public class MovieService {
    MovieDao service = new MovieDaoImpl();
    MovieUP apiRestDown = new MovieUP();
	
    public Object findById(Long id) throws Throwable {
		return service.getOne(id);
	}
    public Object findByWord(String words) throws Throwable {
    	return service.getByWord(words);
    }
    public Object create(Movie Entity) throws Throwable {
    	return service.save(Entity);
    }
    public void update(Movie entity, Long id) throws Throwable {
    	service.update(entity, id);
    }
    public Map<Long,List<Object>> FindList() throws Throwable{
    	return service.findAll();
    }
    public void delete(Long id) throws Throwable {
    	service.delete(id);
    }
    public List<MovieDTO> findList() throws Throwable{
    	return apiRestDown.ListMoviesUP();
    }
}
