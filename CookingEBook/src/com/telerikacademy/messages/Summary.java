package com.telerikacademy.messages;

import com.telerikacademy.interfaces.*;

public class Summary extends Message implements Likable, Dislikable, Editable, Deletable, Ratable {
	
	private String summary;
	private int likes;
	private int dislikes;
	private boolean isDeleted;
	
	public Summary(String author, String summary) {
		super(author);
		super.getTimestamp();
		this.summary = summary;
		likes = 0;
		dislikes = 0;
		isDeleted = false;
	}
	
	@Override
	public void like(String user) {
		String log = String.format("%s liked: \"%s\"", user, summary);
		System.out.println(log);
		likes++;
	}
	
	@Override
	public void dislike(String user) {
		String log = String.format("%s disliked: \"%s\"", user, summary);
		System.out.println(log);
		dislikes++;
	}
	
	// modify to be deleted only by admin and/ or author
	@Override
	public void delete(String user) {
		if (!isDeleted) {
			if (user.equals(this.getAuthor()) /* || user == admin*/) {
				String log = String.format("%s deleted \"%s\"", user, summary);
				System.out.println(log);
				isDeleted = true;
			}
			else {
				String log = String.format("%s does not have the rights to delete this summary!", user);
				System.out.println(log);
			}
		}
		else {
			System.out.printf("Comment \"%s\": already deleted!", summary);
			System.out.println();
		}
	}
	
	@Override
	public void edit(String user, String summary) {
		String prevSummary = this.summary;
		if (!isDeleted) {
			if (user.equals(this.getAuthor()) /*|| user == admin*/) {
				this.summary = summary;
				String log = String.format("%s edited \"%s\"\n into \"%s\"!", user, prevSummary, summary);
				System.out.println(log);
			}
			else {
				String log = String.format("%s does not have the rights to edit this summary!", user);
				System.out.println(log);
			}
		}
		else {
			String log = String.format("Summary \"%s\": already deleted!", this.summary);
			System.out.println(log);
		}
	}
	
	@Override
	public double rate() {
		
		double rating = 0;
		
		if (likes == 0 && dislikes == 0) {
			return rating;
		}
		
		double score = (double) likes / (likes + dislikes);
		if (score <= 0.1) {
			rating = 0.5;
		}
		else if (score <= 0.2) {
			rating = 1;
		}
		else if (score <= 0.3) {
			rating = 1.5;
		}
		else if (score <= 0.4) {
			rating = 2;
		}
		else if (score <= 0.5) {
			rating = 2.5;
		}
		else if (score <= 0.6) {
			rating = 3;
		}
		else if (score <= 0.7) {
			rating = 3.5;
		}
		else if (score <= 0.8) {
			rating = 4;
		}
		else if (score <= 0.9) {
			rating = 4.5;
		}
		else {
			rating = 5;
		}
		return rating;
	}
}
