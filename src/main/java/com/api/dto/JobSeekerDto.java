package com.api.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JobSeekerDto 
{
	@NotNull
	@Size(min = 1, max = 30, message="First Name must have 1 to 30 characters !!!")
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 30, message="Last Name must have 1 to 30 characters !!!")
	private String lastName;
	
	@Min(18)
	private int age;
	
	@NotBlank(message = "Education Can't Be Empty")
	private String education;
	
	@NotBlank(message = "Address Can't Be Blank !!!")
	private String address;

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public String getEducation() 
	{
		return education;
	}

	public void setEducation(String education) 
	{
		this.education = education;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	@Override
	public String toString() 
	{
		return "JobSeekerDto [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", education="
				+ education + ", address=" + address + "]";
	}
	
}
