package com.telerikacademy.help;

// make this class reachable only for admin(s) & add some form of input verification
public class ContactInfo {
	private String emailAddress;
	private String phoneNumber;
	private String contactName;
	
	public ContactInfo(String contactName, String phoneNumber, String emailAddress) {
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
}
