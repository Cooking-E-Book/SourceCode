package com.telerikacademy.messages;

import com.telerikacademy.Global;
import com.telerikacademy.interfaces.*;
import com.telerikacademy.users.Admin;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;

public class Summary extends Message implements Likable, Dislikable, Editable, Deletable, Ratable {
	
	private String summary;
	private int likes;
	private int dislikes;
	private boolean isDeleted;
	
	public Summary(int recipeId, String summary) {
		super(recipeId);
		this.summary = summary;
		likes = 0;
		dislikes = 0;
		isDeleted = false;
	}
	
	@Override
	public void like() {
		User user = Global.currentUser;
		if (isDeleted) {
			String log = String.format("\"%s\" cannot be liked because the summary is already deleted!", summary);
			System.out.println(log);
		}
		else if (user instanceof Admin || user instanceof Author) {
			String log = String.format("%s liked: \"%s\"", user.getUsername(), summary);
			System.out.println(log);
			likes++;
		}
		else {
			String log = String.format("%s is a visitor. In order to like, please first sign up or log into your profile!", user.getUsername());
			System.out.println(log);
		}
	}
	
	@Override
	public void dislike() {
		User user = Global.currentUser;
		if (isDeleted) {
			String log = String.format("\"%s\" cannot be disliked because the summary is already deleted!", summary);
			System.out.println(log);
		}
		else if (user instanceof Admin || user instanceof Author) {
			String log = String.format("%s disliked: \"%s\"", user.getUsername(), summary);
			System.out.println(log);
			dislikes++;
		}
		else {
			String log = String.format("%s is a visitor. In order to dislike, please first sign up or log into your profile!", user.getUsername());
			System.out.println(log);
		}
	}
	
	// modify to be deleted only by admin and/ or author
	@Override
	public void delete() {
		User user = Global.currentUser;
		if (!isDeleted) {
			if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
				String log = String.format("%s deleted \"%s\"", user.getUsername(), summary);
				System.out.println(log);
				isDeleted = true;
			}
			else {
				String log = String.format("%s does not have the rights to delete this summary!", user.getUsername());
				System.out.println(log);
			}
		}
		else {
			System.out.printf("Comment \"%s\": already deleted!", summary);
			System.out.println();
		}
	}
	
	@Override
	public void edit(String summary) {
		User user = Global.currentUser;
		String prevSummary = this.summary;
		if (!isDeleted) {
			if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
				this.summary = summary;
				String log = String.format("%s edited \"%s\"\n into \"%s\"!", user.getUsername(), prevSummary, summary);
				System.out.println(log);
			}
			else {
				String log = String.format("%s does not have the rights to edit this summary!", user.getUsername());
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
