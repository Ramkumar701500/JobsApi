package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.repository.JobSeekerRepository;
import com.api.dto.JobSeekerDtoWithId;
import com.api.dto.JobSeekerDto;
import com.api.dtoconverter.JobSeekerDtoConverter;
import com.api.model.JobSeeker;

//defining the business logic
@Service
public class JobSeekerService
{

	@Autowired
	JobSeekerRepository jobSeekerRepository;
	
	@Autowired
	JobSeekerDtoConverter jobSeekerDtoConverter;
	
	//saving an specific record by using the method save() of CrudRepository
	public void save(JobSeekerDto jobSeekerDto) 
	{
		JobSeeker jobSeeker = jobSeekerDtoConverter.dtoToEntity(jobSeekerDto);
		jobSeekerRepository.save(jobSeeker);
	}
	
	//getting an specific record by using the method findById() of CrudRepository
	public JobSeeker getJobSeekerById(int id) 
	{
		return jobSeekerRepository.findById(id).get();
	}
	
	//deleting an specific record by using the method deleteById() of CrudRepository
	public void delete(int id) 
	{
		jobSeekerRepository.deleteById(id);
	}
		
	//updating a record
	public void update(int jobSeekerId, JobSeekerDtoWithId jobSeekerDto) 
	{
		JobSeeker jobSeeker = jobSeekerDtoConverter.dtoToEntity(jobSeekerDto);
		jobSeeker.setId(jobSeekerId);	
		jobSeekerRepository.save(jobSeeker);
	}
	
	//getting all the job seekers record by using the method findaAll() of CrudRepository
	public List<JobSeekerDtoWithId> getJobSeekerList() 
	{
		List<JobSeeker> jobSeekerList = new ArrayList<>();
		
		jobSeekerRepository.findAll().forEach(jobSeekerList::add);
		
		List<JobSeekerDtoWithId> dtoList = new ArrayList<>();
		dtoList = jobSeekerList.stream().map(x -> jobSeekerDtoConverter.entityToDto(x)).collect(Collectors.toList());
		
		return dtoList;
	}		

}