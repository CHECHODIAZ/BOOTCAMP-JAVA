package com.drudmoviestore.dao;

import com.drudmoviestore.entity.User;

public interface UserDao<T> {
    
	public T save(User entity) throws Throwable;
	public T getUserByUserNameAndPassword(String us, String pass) throws Throwable;
}
