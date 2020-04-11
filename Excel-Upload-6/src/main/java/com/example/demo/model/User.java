package com.example.demo.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class User {
	
	
	private Date id;
	
	private String firstName;
	
	private String lastName;
	
	private String emails;
	
	private int phoneNumber;
	
	private String fileType;
	
	
	private MultipartFile file;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Date id, String firstName, String lastName, String emails, int phoneNumber, String fileType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emails = emails;
		this.phoneNumber = phoneNumber;
		this.fileType = fileType;
	}
	
	
	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public Date getId() {
		return id;
	}

	public void setId(Date id) {
		this.id = id;
	}

	/*public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}
*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	
	/*public Double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
*/
	
	
	public String getFileType() {
		return fileType;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emails=" + emails
				+ ", phoneNumber=" + phoneNumber + ", fileType=" + fileType + ", file=" + file + "]";
	}
	
	
	
	
	
}
