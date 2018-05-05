package com.telerikacademy.help;

import java.util.ArrayList;

public class Help {
	
	
	private ArrayList<FAQ> FAQ;
	private ContactInfo contactInfo;
	
	public Help(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
		FAQ = new ArrayList<>();
	}
	
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	
	// set some form of FAQ verification using try catch & exception handler
	public void addFAQ(FAQ faq) {
		FAQ.add(faq);
	}
}
