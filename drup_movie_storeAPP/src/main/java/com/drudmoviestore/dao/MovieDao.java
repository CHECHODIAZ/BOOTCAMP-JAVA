package com.drudmoviestore.dao;

import java.util.List;
import java.util.Map;

import com.drudmoviestore.entity.Movie;


public interface MovieDao<T> {
	
	public T getOne(Long id) throws Throwable;
	
	public T getByWord(String word) throws Throwable;

	public void delete(Long id) throws Throwable;

	public T save(Movie entity) throws Throwable;

	public void update(Movie entity, Long id) throws Throwable;

	public Map<Long, List<Object>> findAll() throws Throwable;
	
	public Map<Long, List<Object>> findBySQL(String whereSQL) throws Throwable;

}
