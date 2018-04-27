package com.telerikacademy.messages;

import com.telerikacademy.interfaces.Likable;
import com.telerikacademy.interfaces.Ratable;

import java.sql.Timestamp;
import java.util.List;

public class Comment extends Message implements Likable, Ratable {

	private String comment;
	private List<Reply> replies;

	public Comment(String author, Timestamp timestamp, String comment) {
		super(author, timestamp);
		this.comment = comment;
		likes = 0;
		dislikes = 0;
	}

	private void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void addReply(Reply reply) {
		replies.add(reply);
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
	public void dislike(String user) {
		String log = String.format("%s disliked %s", user, comment);
		System.out.println(log);
		dislikes++;
	}

	@Override
	public double getRating(Message comment) {

		double rating = 0;

		if (likes == 0 && dislikes == 0) {
			return rating;
		}

		double score = likes / (likes + dislikes);
		if (score <= 0.1) {
			rating = 0.5;
		}
		else if (likes <= 0.2) {
			rating = 1;
		}
		else if (likes <= 0.3) {
			rating = 1.5;
		}
		else if (likes <= 0.4) {
			rating = 2;
		}
		else if (likes <= 0.5) {
			rating = 2.5;
		}
		else if (likes <= 0.6) {
			rating = 3;
		}
		else if (likes <= 0.7) {
			rating = 3.5;
		}
		else if (likes <= 0.8) {
			rating = 4;
		}
		else if (likes <= 0.9) {
			rating = 4.5;
		}
		else {
			rating = 5;
		}
		return rating;
	}
}
