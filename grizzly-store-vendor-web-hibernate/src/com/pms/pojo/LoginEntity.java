package com.pms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_user")
public class LoginEntity {

	@Id
	@Column(name="login_username")
	private String username;
	
	@Column(name="login_password")
	private String password;
	
	@Column(name="login_role")
	private String role;
	
	@Column(name="login_status")
	private String status;
	
	@Column(name="login_rating")
	private String rating;
	
	@Column(name="login_contact")
	private String contact;
	
	@Column(name="login_address")
	private String address;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LoginEntity()
	{
		
	}
}
