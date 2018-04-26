package com.telerikacademy.messages;

import com.telerikacademy.interfaces.Likable;

import java.sql.Timestamp;

public class Reply extends Message implements Likable {
	
	private String reply;
	private String commentReplied; //currentComment
	
	
	public Reply(String author, Timestamp timestamp, String reply, String commentReplied) {
		super(author, timestamp);
		likes = 0;
		this.reply = reply;
		this.commentReplied = commentReplied; // should be somehow linked to the currently selected comment
	}
	
	private void setReply(String reply) {
		this.reply = reply;
	}
	
	public String getReply() {
		return reply;
	}
	
	public String getCommentReplied() {
		return commentReplied;
	}
	
	@Override
	public void postMessage() {
		System.out.println(this);
	}
	
	@Override
	public void like(String user) {
		String log = String.format("%s liked %s", user, reply);
		System.out.println(log);
	}
}
