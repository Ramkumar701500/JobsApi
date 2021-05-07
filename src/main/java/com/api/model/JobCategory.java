package com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity						//marking class as an Entity 
@Table						//defining class name as Table name
public class JobCategory
{
	
	@Id						//Defining JobCategory id as primary key
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String category;
	
	@Column(length = 500)
	private String description;

	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCategory() 
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	@Override
	public String toString() 
	{
		return "JobCategory [Id=" + id + ", category=" + category + ", description=" + description + "]";
	}
	
}