package com.telerikacademy.help;

public class Question {
	private String question;
	
	public Question(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}

	@Override
	public String toString() {
		return question.toString();
	}
}
