package com.telerikacademy.messages;

import com.sun.tools.corba.se.idl.constExpr.Times;
import com.telerikacademy.interfaces.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Comment extends Message implements Likable, Dislikable, Editable, Deletable {

	private String comment;
	private List<Reply> replies;
	//private Timestamp timestamp;
	private int likes;
	private int dislikes;
	private boolean isDeleted;

	public Comment(String author, Timestamp timestamp, String comment) {
		super(author, timestamp);
		//timestamp = new Timestamp(System.currentTimeMillis());
		this.comment = comment;
		likes = 0;
		dislikes = 0;
		replies = new ArrayList<>();
		isDeleted = false;
	}

	private void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public int getDislikes() {
		return dislikes;
	}
	
	public void addReply(Reply reply) {
		replies.add(reply);
	}
	
	public boolean isDeletedCheck() {
		return isDeleted;
	}

	@Override
	public void postMessage() {
		System.out.println(this);
	}
	
	public void like(String user) {
		String log = String.format("%s liked %s", user, comment);
		System.out.println(log);
		likes++;
	}
	
	public void dislike(String user) {
		String log = String.format("%s disliked %s", user, comment);
		System.out.println(log);
		dislikes++;
	}
	
	// modify to be deleted only by admin and/ or author
	public void delete(String user) {
		if (!isDeleted) {
			String log = String.format("%s deleted %s", user, comment);
			System.out.println(log);
		}
		else {
			System.out.printf("Comment \"%s\": already deleted!", comment);
		}
	}
}
