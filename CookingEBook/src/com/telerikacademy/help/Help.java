package com.telerikacademy.help;

import java.util.ArrayList;

public class Help {
	
	private ArrayList<FAQ> FAQs;
	private ContactInfo contactInfo;
	
	public Help(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
		FAQs = new ArrayList<>();
	}
	
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	
	public void addFAQ(FAQ faq) {
		FAQs.add(faq);
	}
	
	public void readFAQs() {
		for (FAQ faq : FAQs) {
			System.out.printf("Question: \"%s\":\nAnswer: \"%s\"", faq.getQuestion(), faq.getAnswer());
			System.out.println();
		}
	}
}
