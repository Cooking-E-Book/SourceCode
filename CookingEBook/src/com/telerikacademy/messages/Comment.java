package com.telerikacademy.messages;

import com.telerikacademy.Globals;
import com.telerikacademy.interfaces.*;
import com.telerikacademy.interfaces.Readable;
import com.telerikacademy.users.Admin;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;
import com.telerikacademy.users.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Comment extends Message implements Likable, Dislikable, Editable, Deletable, Readable {
	
	private String comment;
	private List<Comment> replies;
	private int likes;
	private int dislikes;
	private boolean isDeleted;
	
	public Comment(String comment) {
		super();
		this.comment = comment;
		likes = 0;
		dislikes = 0;
		replies = new ArrayList<>();
		isDeleted = false;
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
	
	public void addReply(Comment reply) {
		replies.add(reply);
	}
	
	/*public boolean isDeletedCheck() {
		return isDeleted;
	}*/
	
	@Override
	public void like() {
		User user = Globals.currentUser;
		if (isDeleted) {
			String log = String.format("\"%s\" cannot be liked because the message is already deleted!", comment);
			System.out.println(log);
		}
		else if (user instanceof Admin || user instanceof Author) {
			String log = String.format("%s liked: \"%s\"", user.getUsername(), comment);
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
		User user = Globals.currentUser;
		if (isDeleted) {
			String log = String.format("\"%s\" cannot be disliked because the message is already deleted!", comment);
			System.out.println(log);
		}
		else if (user instanceof Admin || user instanceof Author) {
			String log = String.format("%s disliked: \"%s\"", user.getUsername(), comment);
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
		User user = Globals.currentUser;
		if (!isDeleted) {
			if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
				String log = String.format("%s deleted \"%s\"", user.getUsername(), comment);
				System.out.println(log);
				isDeleted = true;
				replies.remove(this);
			}
			else {
				String log = String.format("%s does not have the rights to delete this message!", user.getUsername());
				System.out.println(log);
			}
		}
		else {
			System.out.printf("Comment \"%s\": already deleted!", comment);
			System.out.println();
		}
	}
	
	@Override
	public void edit(String comment) {
		User user = Globals.currentUser;
		String prevComment = this.comment;
		if (!isDeleted) {
			if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
				this.comment = comment;
				String log = String.format("%s edited \"%s\"\n into \"%s\"!", user.getUsername(), prevComment, comment);
				System.out.println(log);
			}
			else {
				String log = String.format("%s does not have the rights to edit this comment!", user.getUsername());
				System.out.println(log);
			}
		}
		else {
			String log = String.format("Comment \"%s\": already deleted!", this.comment);
			System.out.println(log);
		}
	}
	
	// print all non-deleted replies
	@Override
	public void readReplies() {
		for (Comment reply : replies) {
			if (!reply.isDeleted) {
				System.out.printf("%s: %s wrote: \"%s\"", reply.getTimestamp(), reply.getAuthor().getUsername(), reply.getComment());
				System.out.println();
			}
		}
	}
}
