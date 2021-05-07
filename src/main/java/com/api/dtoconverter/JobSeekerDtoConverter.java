package com.api.dtoconverter;

import org.springframework.stereotype.Component;

import com.api.dto.JobSeekerDto;
import com.api.dto.JobSeekerDtoWithId;
import com.api.model.JobSeeker;

@Component
public class JobSeekerDtoConverter 
{
	// Converting the JobSeeker DTO to Entity
	public JobSeeker dtoToEntity(JobSeekerDto jobSeekerDto) 
	{
		JobSeeker jobSeeker = new JobSeeker();
		
		jobSeeker.setFirstName(jobSeekerDto.getFirstName());
		jobSeeker.setLastName(jobSeekerDto.getLastName());
		jobSeeker.setAge(jobSeekerDto.getAge());
		jobSeeker.setEducation(jobSeekerDto.getEducation());
		jobSeeker.setAddress(jobSeekerDto.getAddress());
		
		return jobSeeker;
	}
	
	
	// Converting the JobSeeker DTO with Id to Entity for updating
	public JobSeeker dtoToEntity(JobSeekerDtoWithId jobSeekerDtoWithId) 
	{
		JobSeeker jobSeeker = new JobSeeker();
		
		jobSeeker.setId(jobSeekerDtoWithId.getId());
		jobSeeker.setFirstName(jobSeekerDtoWithId.getFirstName());
		jobSeeker.setLastName(jobSeekerDtoWithId.getLastName());
		jobSeeker.setAge(jobSeekerDtoWithId.getAge());
		jobSeeker.setEducation(jobSeekerDtoWithId.getEducation());
		jobSeeker.setAddress(jobSeekerDtoWithId.getAddress());
		
		return jobSeeker;
	}
	
	
	// Converting the Entity to JobSeeker DTO
	public JobSeekerDtoWithId entityToDto(JobSeeker jobSeeker) 
	{
		JobSeekerDtoWithId jobSeekerDtoWithId  = new JobSeekerDtoWithId();
		
		jobSeekerDtoWithId.setId(jobSeeker.getId());
		jobSeekerDtoWithId.setFirstName(jobSeeker.getFirstName());
		jobSeekerDtoWithId.setLastName(jobSeeker.getLastName());
		jobSeekerDtoWithId.setAge(jobSeeker.getAge());
		jobSeekerDtoWithId.setEducation(jobSeeker.getEducation());
		jobSeekerDtoWithId.setAddress(jobSeeker.getAddress());
		
		return jobSeekerDtoWithId;
	}
}
