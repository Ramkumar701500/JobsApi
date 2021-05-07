package com.api.dtoconverter;


import org.springframework.stereotype.Component;

import com.api.dto.JobCategoryDto;
import com.api.dto.JobCategoryDtoWithId;
import com.api.model.JobCategory;

@Component
public class JobCategoryDtoConverter 
{

	// Converting the JobCategory DTO to Entity
	public JobCategory dtoToEntity(JobCategoryDto jobCategoryDto) 
	{
		JobCategory jobCategory = new JobCategory();
		
		jobCategory.setCategory(jobCategoryDto.getCategory());
		jobCategory.setDescription(jobCategoryDto.getDescription());
		
		return jobCategory;
	}
	
	
	// Converting the JobCategory DTO with Id to Entity for updating
	public JobCategory dtoToEntity(JobCategoryDtoWithId jobCategoryDtoWithId) 
	{
		JobCategory jobCategory = new JobCategory();
		
		jobCategory.setId(jobCategory.getId());
		jobCategory.setCategory(jobCategoryDtoWithId.getCategory());
		jobCategory.setDescription(jobCategoryDtoWithId.getDescription());
		
		return jobCategory;
	}
	
	
	// Converting the Entity to JobCategory DTO
	public JobCategoryDtoWithId entityToDto(JobCategory jobCategory) 
	{
		JobCategoryDtoWithId jobCategoryDtoWithId  = new JobCategoryDtoWithId();
		
		jobCategoryDtoWithId.setId(jobCategory.getId());
		jobCategoryDtoWithId.setCategory(jobCategory.getCategory());
		jobCategoryDtoWithId.setDescription(jobCategory.getDescription());
		
		return jobCategoryDtoWithId;
	}
		
	
}
