package com.aee.service.repository.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aee.service.models.university.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
	
}
