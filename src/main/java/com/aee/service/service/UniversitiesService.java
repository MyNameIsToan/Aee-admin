package com.aee.service.service;

import com.aee.service.models.university.University;

public interface UniversitiesService {
	void Create(University uni);
	void Update(Long id, University uni);
	void Remove(Long id);
}
