package com.springmvc.javabeans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.URL;

public class StudentDetails {

	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String userPassword;
	
	@NotEmpty(message = "Mobile number should not be blank")
	@Size(min=10, max=10)
	private String userMobile;
	
	@NotEmpty(message = "Email id should not be blank")
	@Email(message="Enter a valid email id")
	private String userEmail;
	
	private String userAddress;
	
	public String getUserName()
	{
		return this.userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getUserPassword()
	{
		return this.userPassword;
	}
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	
	public String getUserMobile()
	{
		return this.userMobile;
	}
	public void setUserMobile(String userMobile)
	{
		this.userMobile = userMobile;
	}
	
	public String getUserEmail()
	{
		return this.userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	
	public String getUserAddress()
	{
		return this.userAddress;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
	
}
