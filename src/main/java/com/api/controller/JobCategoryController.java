package com.api.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.JobCategoryDto;
import com.api.dto.JobCategoryDto;
import com.api.dto.JobCategoryDtoWithId;
import com.api.model.JobCategory;
import com.api.service.JobCategoryService;


@RestController
public class JobCategoryController
{
		
	//Auto Wiring the JobCategoryService class
	@Autowired
	JobCategoryService jobCategoryService;
	
	
	//creating post mapping that post the job category detail
	@PostMapping("/save-jobcategory")
	private ResponseEntity<?> saveJobCategory(@Valid @RequestBody JobCategoryDto jobCategoryDto) 
	{
		jobCategoryService.save(jobCategoryDto);
		
		System.out.println(jobCategoryDto);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//creating a get mapping that retrieves the detail of an specific job category
	@GetMapping("/show-jobcategory/{id}")
	private ResponseEntity<JobCategoryDtoWithId> getJobCategory(@PathVariable("id") int jobCategoryId) 
	{	
		JobCategoryDtoWithId foundJobCategory = null;
		
		for(JobCategoryDtoWithId jc : jobCategoryService.getJobCategoryList()) 
		{ 
			if(jc.getId() == jobCategoryId) 
			{ 
				foundJobCategory = jc;
				break;
			}
		}
		
		if(foundJobCategory != null)
		{
			System.out.println(foundJobCategory);
			
			return ResponseEntity.ok(foundJobCategory);		// return 200, with json body
	    }
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		// return 404, with null body	
	}
	
	
	//creating a get mapping that retrieves the detail of all the job categories
	@GetMapping("/show-jobcategories")
	private ResponseEntity<List<JobCategoryDtoWithId>> getAllJobCategory() 
	{	
		
		if(jobCategoryService.getJobCategoryList().size() != 0)
		{
			System.out.println(jobCategoryService.getJobCategoryList());
			
			return ResponseEntity.ok(jobCategoryService.getJobCategoryList());
		}
		
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // return 402, with null body
		}		
	}
	
	
	//creating a delete mapping that deletes an specified job category
	@DeleteMapping("/delete-jobcategory/{id}")
	private ResponseEntity<?> deleteJobCategory(@PathVariable("id") int jobCategoryId) 
	{
		JobCategoryDtoWithId foundJobCategory = null;
		
		for(JobCategoryDtoWithId jc : jobCategoryService.getJobCategoryList()) 
		{ 
			if(jc.getId() == jobCategoryId) 
			{ 
				foundJobCategory = jc;
				break;
			}
		}
		
		if(foundJobCategory == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		jobCategoryService.delete(foundJobCategory.getId());
		
		System.out.println("JobCategory With ID "+jobCategoryId+" Is Deleted"); 
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating put mapping that updates the job category detail
	@PutMapping("/update-jobcategory/{id}")
	private ResponseEntity<?> updateJobCategory(@Valid @PathVariable("id") int jobCategoryId, @RequestBody JobCategoryDtoWithId jobCategoryNew) 
	{	
		JobCategoryDtoWithId foundJobCategory = null;
		
		for(JobCategoryDtoWithId jc : jobCategoryService.getJobCategoryList()) 
		{ 
			if(jc.getId() == jobCategoryId) 
			{ 
				foundJobCategory = jc;
				break;
			}
		}
		
		if(foundJobCategory == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		jobCategoryService.update(jobCategoryId, jobCategoryNew);
		
		System.out.println("JobCategory With ID "+jobCategoryId+" Is Updated");
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating get mapping that shows the welcome page of job category
	@GetMapping("/category")
	public String welcomePage() 
	{
		return "Hello and Welcome to the Job Category Rest Api application";
	}

}
