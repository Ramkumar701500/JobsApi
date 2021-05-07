package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.repository.JobCategoryRepository;
import com.api.dto.JobCategoryDto;
import com.api.dto.JobCategoryDtoWithId;
import com.api.dtoconverter.JobCategoryDtoConverter;
import com.api.model.JobCategory;

//defining the business logic
@Service
public class JobCategoryService
{

	@Autowired
	JobCategoryRepository jobCategoryRepository;
	
	@Autowired
	JobCategoryDtoConverter jobCategoryDtoConverter;
	
	//saving an specific job category record by using the method save() of CrudRepository
	public void save(JobCategoryDto jobCategoryDto) 
	{
		JobCategory jobCategory = jobCategoryDtoConverter.dtoToEntity(jobCategoryDto);
		jobCategoryRepository.save(jobCategory);
	}
	
	//getting an specific job category record by using the method findById() of CrudRepository
	public JobCategory getJobCategoryById(int id) 
	{
		return jobCategoryRepository.findById(id).get();
	}
	
	//deleting an specific job category record by using the method deleteById() of CrudRepository
	public void delete(int id) 
	{
		jobCategoryRepository.deleteById(id);
	}
		
	//updating an specific job category record
	public void update(int jobCategoryId, JobCategoryDtoWithId jobCategoryDto) 
	{
		JobCategory jobCategory = jobCategoryDtoConverter.dtoToEntity(jobCategoryDto);
		jobCategory.setId(jobCategoryId);	
		jobCategoryRepository.save(jobCategory);
	}
	
	//getting all the job categories records by using the method findaAll() of CrudRepository
	public List<JobCategoryDtoWithId> getJobCategoryList() 
	{
		List<JobCategory> jobCategoryList = new ArrayList<>();
		jobCategoryRepository.findAll().forEach(jobCategoryList::add);
		
		List<JobCategoryDtoWithId> dtoList = new ArrayList<>();
		dtoList = jobCategoryList.stream().map(x -> jobCategoryDtoConverter.entityToDto(x)).collect(Collectors.toList());
		
		return dtoList;
	}		

}