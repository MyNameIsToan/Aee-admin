package com.aee.service.service;

import com.aee.service.models.university.Field;

public interface MajorService {
	void Create(Field field);
	void Update(Long id, Field field);
	void Remove(Long id);
}
