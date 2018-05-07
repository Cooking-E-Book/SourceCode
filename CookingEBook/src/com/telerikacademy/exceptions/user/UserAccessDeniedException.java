package com.telerikacademy.exceptions.user;

public class UserAccessDeniedException extends RuntimeException{
	
	public UserAccessDeniedException(String username) {
		System.out.printf("Access denied! User (%s) has no rights to perform the requested action!", username);
	}
}
