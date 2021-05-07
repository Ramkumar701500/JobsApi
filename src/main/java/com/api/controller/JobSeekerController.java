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

import com.api.dto.JobSeekerDto;
import com.api.dto.JobSeekerDtoWithId;
import com.api.model.JobSeeker;
import com.api.service.JobSeekerService;


@RestController
public class JobSeekerController
{
	
	//Auto Wiring the JobSeekerService class
	@Autowired
	JobSeekerService jobSeekerService;
	
	
	//creating post mapping that post the job seeker detail
	@PostMapping("/save-jobseeker")
	private ResponseEntity<?> saveJobSeeker(@Valid @RequestBody JobSeekerDto jobSeekerDto) 
	{
		jobSeekerService.save(jobSeekerDto);
		
		System.out.println(jobSeekerDto);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//creating a get mapping that retrieves the detail of an specific job seeker
	@GetMapping("/show-jobseeker/{id}")
	private ResponseEntity<JobSeekerDtoWithId> getJobSeeker(@PathVariable("id") int jobSeekerId) 
	{	
		JobSeekerDtoWithId foundJobSeeker = null;
		
		for(JobSeekerDtoWithId js : jobSeekerService.getJobSeekerList()) 
		{ 
			if(js.getId() == jobSeekerId) 
			{ 
				foundJobSeeker = js;
				break;
			}
		}
		
		if(foundJobSeeker != null)
		{
			System.out.println(foundJobSeeker);
			
			return ResponseEntity.ok(foundJobSeeker);		// return 200, with json body
	    }
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		// return 404, with null body	
	}
	
	
	//creating a get mapping that retrieves the detail of all the job seekers
	@GetMapping("/show-jobseekers")
	private ResponseEntity<List<JobSeekerDtoWithId>> getAllJobSeeker() 
	{	
		if(jobSeekerService.getJobSeekerList().size() != 0)
		{
			System.out.println(jobSeekerService.getJobSeekerList());
			
			return ResponseEntity.ok(jobSeekerService.getJobSeekerList());
		}
		
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // return 402, with null body
		}		
	}
	
	
	//creating a delete mapping that deletes an specified job seeker
	@DeleteMapping("/delete-jobseeker/{id}")
	private ResponseEntity<?> deleteJobSeeker(@PathVariable("id") int jobSeekerId) 
	{
		JobSeekerDtoWithId foundJobSeeker = null;
		
		for(JobSeekerDtoWithId js : jobSeekerService.getJobSeekerList()) 
		{ 
			if(js.getId() == jobSeekerId) 
			{ 
				foundJobSeeker = js;
				break;
			}
		}
		
		if(foundJobSeeker == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		jobSeekerService.delete(foundJobSeeker.getId());
		
		System.out.println("JobSeeker With ID "+jobSeekerId+" Is Deleted"); 
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating put mapping that updates the job seeker detail
	@PutMapping("/update-jobseeker/{id}")
	private ResponseEntity<?> updateJobSeeker(@Valid @PathVariable("id") int jobSeekerId, @RequestBody JobSeekerDtoWithId jobSeekerNew) 
	{	
		JobSeekerDtoWithId foundJobSeeker = null;
		
		for(JobSeekerDtoWithId js : jobSeekerService.getJobSeekerList()) 
		{ 
			if(js.getId() == jobSeekerId) 
			{ 
				foundJobSeeker = js;
				break;
			}
		}
		
		if(foundJobSeeker == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		jobSeekerService.update(jobSeekerId, jobSeekerNew);
		
		System.out.println("JobCategory With ID "+jobSeekerId+" Is Updated");
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating get mapping that shows the welcome page of job seeker
	@GetMapping("/")
	public String welcomePage() 
	{
		return "Hello and Welcome to the Job Seeker Rest Api application";
	}

}
