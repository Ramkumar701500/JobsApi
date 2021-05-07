package com.api.dto;

import javax.validation.constraints.NotBlank;

public class JobCategoryDto
{
	
	@NotBlank(message = "Category Can't Be Empty")
	private String category;
	
	@NotBlank(message = "Job Description Can't Be Blank !!!")
	private String description;

	
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
		return "JobCategoryDto [category=" + category + ", description=" + description + "]";
	}
	
}
