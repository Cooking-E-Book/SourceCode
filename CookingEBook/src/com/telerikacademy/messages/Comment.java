package com.telerikacademy.messages;

import com.telerikacademy.interfaces.*;
import com.telerikacademy.interfaces.Readable;

import java.util.ArrayList;
import java.util.List;

public class Comment extends Message implements Likable, Dislikable, Editable, Deletable, Readable {

	private String comment;
	private List<Comment> replies;
	private int likes;
	private int dislikes;
	private boolean isDeleted;

	public Comment(String author, String comment) {
		super(author);
		super.getTimestamp();
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
	public void like(String user) {
		String log = String.format("%s liked: \"%s\"", user, comment);
		System.out.println(log);
		likes++;
	}
	
	@Override
	public void dislike(String user) {
		String log = String.format("%s disliked: \"%s\"", user, comment);
		System.out.println(log);
		dislikes++;
	}
	
	// modify to be deleted only by admin and/ or author
	@Override
	public void delete(String user) {
		if (!isDeleted) {
			if (user.equals(this.getAuthor())/* || user == admin*/) {
				String log = String.format("%s deleted \"%s\"", user, comment);
				System.out.println(log);
				isDeleted = true;
				replies.remove(this);
			}
			else {
				String log = String.format("%s does not have the rights to delete this message!", user);
				System.out.println(log);
			}
		}
		else {
			System.out.printf("Comment \"%s\": already deleted!", comment);
			System.out.println();
		}
	}
	
	@Override
	public void edit(String user, String comment) {
		String prevComment = this.comment;
		if (!isDeleted) {
			if (user.equals(this.getAuthor()) /*|| user == admin*/) {
				this.comment = comment;
				String log = String.format("%s edited \"%s\"\n into \"%s\"!", user, prevComment, comment);
				System.out.println(log);
			}
			else {
				String log = String.format("%s does not have the rights to edit this comment!", user);
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
			if (reply.isDeleted == false) {
				System.out.printf("%s: %s wrote: \"%s\"", reply.getTimestamp(), reply.getAuthor(), reply.getComment());
				System.out.println();
			}
		}
	}
}
