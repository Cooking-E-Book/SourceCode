package com.telerikacademy.messages;

import com.telerikacademy.interfaces.Likable;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Reply extends Comment {
	
	private String reply;
	private String commentReplied;
	private List<Reply> replies;
	//private Timestamp timestamp;
	private int likes;
	private int dislikes;
	
	public Reply(String author, Timestamp timestamp, String reply) {
		super(author, timestamp, reply);
		//timestamp = new Timestamp(System.currentTimeMillis());
		likes = 0;
		dislikes = 0;
		commentReplied = getComment(); // ???should be somehow linked to the currently selected comment
		replies = new ArrayList<>();
	}
	
	/*private void setReply(String reply) {
		this.reply = reply;
	}
	
	public String getReply() {
		return reply;
	}*/
	
	public int getLikes() {
		return likes;
	}
	
	public int getDislikes() {
		return dislikes;
	}
	
	public String getCommentReplied() {
		return commentReplied;
	}
	
	/*public void like(String user) {
		String log = String.format("%s liked %s", user, reply);
		System.out.println(log);
	}
	
	public void dislike(String user) {
		String log = String.format("%s disliked %s", user, reply);
		System.out.println(log);
	}
	
	public void delete(String user) {
		String log = String.format("%s deleted %s", user, reply);
	}*/
}
