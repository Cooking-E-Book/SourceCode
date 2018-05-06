package com.telerikacademy.messages;

import com.telerikacademy.Global;
import com.telerikacademy.exceptions.messages.NoSuchMessageExists;
import com.telerikacademy.exceptions.user.UserAccessDeniedException;
import com.telerikacademy.interfaces.*;
import com.telerikacademy.interfaces.Readable;
import com.telerikacademy.users.Admin;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;
import java.util.ArrayList;
import java.util.List;

public class Comment extends Message implements Likable, Dislikable, Editable, Deletable, Readable {
	
	private String comment;
	private List<Comment> replies;
	private int likes;
	private int dislikes;
	private boolean isDeleted;
	
	public Comment(int recipeId, String comment) {
		super(recipeId);
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
	
	@Override
	public void like() throws NoSuchMessageExists, UserAccessDeniedException {
		User user = Global.currentUser;
		if (isDeleted) {
			throw new NoSuchMessageExists(comment);
		}
		else if (user instanceof Admin || user instanceof Author) {
			String log = String.format("%s liked: \"%s\"", user.getUsername(), comment);
			System.out.println(log);
			likes++;
		}
		else {
			throw new UserAccessDeniedException(user.getUsername());
		}
	}
	
	@Override
	public void dislike() throws NoSuchMessageExists, UserAccessDeniedException{
		User user = Global.currentUser;
		if (isDeleted) {
			throw new NoSuchMessageExists(comment);
		}
		else if (user instanceof Admin || user instanceof Author) {
			String log = String.format("%s disliked: \"%s\"", user.getUsername(), comment);
			System.out.println(log);
			dislikes++;
		}
		else {
			throw new UserAccessDeniedException(user.getUsername());
		}
	}
	
	// modify to be deleted only by admin and/ or author
	@Override
	public void delete() {
		User user = Global.currentUser;
		if (!isDeleted) {
			if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
				String log = String.format("%s deleted \"%s\"", user.getUsername(), comment);
				System.out.println(log);
				isDeleted = true;
				replies.remove(this);
			}
			else {
				throw new UserAccessDeniedException(user.getUsername());
			}
		}
		else {
			throw new NoSuchMessageExists(comment);
		}
	}
	
	@Override
	public void edit(String comment) {
		User user = Global.currentUser;
		String prevComment = this.comment;
		if (!isDeleted) {
			if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
				this.comment = comment;
				String log = String.format("%s edited \"%s\"\n into \"%s\"!", user.getUsername(), prevComment, comment);
				System.out.println(log);
			}
			else {
				throw new UserAccessDeniedException(user.getUsername());
			}
		}
		else {
			throw new NoSuchMessageExists(comment);
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
