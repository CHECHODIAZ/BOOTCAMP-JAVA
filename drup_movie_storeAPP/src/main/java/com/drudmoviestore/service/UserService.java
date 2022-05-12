package com.drudmoviestore.service;


import com.drudmoviestore.dao.UserDao;
import com.drudmoviestore.entity.User;
import com.drudmoviestore.movie.dao.Impl.UserDaoImpl;

public class UserService {
    
	UserDao service = new UserDaoImpl();
	
	public Object createUser(User entity) throws Throwable {
		
		return service.save(entity);        
	}

	public Object getUserByUserNameAndPassword(String us, String pass) throws Throwable {
		
		return service.getUserByUserNameAndPassword(us, pass);
	}
}
