package com.telerikacademy.messages;

import com.telerikacademy.interfaces.Likable;
import com.telerikacademy.interfaces.Ratable;

import java.sql.Timestamp;

public class Comment extends Message implements Likable, Ratable {
	
	private String comment;
	
	public Comment(String author, Timestamp timestamp, String comment) {
		super(author, timestamp);
		this.comment = comment;
		this.likes = likes;
	}
	
	private void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}
	
	@Override
	public void postMessage() {
		System.out.println(this);
	}
	
	@Override
	public void like(String user) {
		String log = String.format("%s liked %s", user, comment);
		System.out.println(log);
		likes++;
	}
	
	@Override
	public double getRating(Message comment) {
		
		double rating = 0;
		if (likes == 0) {
			rating = 0;
		}
		if (likes > 0) {
			rating = 1;
		}
		if (likes > 5) {
			rating = 1.5;
		}
		if (likes > 20) {
			rating = 2;
		}
		if (likes > 25) {
			rating = 2.5;
		}
		if (likes > 30) {
			rating = 3;
		}
		if (likes > 35) {
			rating = 3.5;
		}
		if (likes > 40) {
			rating = 4;
		}
		if (likes > 45) {
			rating = 4.5;
		}
		if (likes > 45 && likes <= 50) {
			rating = 4.5;
		}
		else {
			rating = 5;
		}
		return rating;
	}
}
