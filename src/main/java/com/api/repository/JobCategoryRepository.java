package com.api.repository;

import com.api.model.JobCategory;
import org.springframework.data.repository.CrudRepository;

public interface JobCategoryRepository extends CrudRepository<JobCategory, Integer>
{

}