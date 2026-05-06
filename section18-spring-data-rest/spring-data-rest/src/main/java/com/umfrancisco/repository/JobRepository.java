package com.umfrancisco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.model.JobPost;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {
	
}
