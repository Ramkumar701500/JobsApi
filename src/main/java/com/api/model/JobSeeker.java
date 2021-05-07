package com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity						//marking class as an Entity 
@Table						//defining class name as Table name
public class JobSeeker 
{
	@Id						//Defining JobSeeker id as primary key
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private int age;
	
	@Column
	private String education;
	
	@Column(length = 500)
	private String address;

	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

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
		return "JobSeeker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", education=" + education + ", address=" + address + "]";
	}
	
}