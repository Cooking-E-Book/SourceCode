package com.telerikacademy.exceptions.messages;

public class NoSuchMessageExists extends RuntimeException {
	
	public NoSuchMessageExists(String comment) {
		System.out.printf("No such object exits (\"%s\")!\n Check if object is not deleted!", comment);
	}
}
