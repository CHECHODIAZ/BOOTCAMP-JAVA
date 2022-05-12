package com.drudmoviestore.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "/LoggingFilter", urlPatterns = "/filter")
public class LoggingFilter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		System.out.println("LoggingFilter:" + req.getParameterMap().toString());
		
		chain.doFilter(request, response);
	}

}
