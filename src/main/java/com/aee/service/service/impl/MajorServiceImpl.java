package com.aee.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aee.service.models.university.Field;
import com.aee.service.repository.university.FieldRepository;
import com.aee.service.service.MajorService;

@Service
public class MajorServiceImpl implements MajorService {
	
	@Autowired
	private FieldRepository fieldRepository;

	@Override
	public void Update(Long id, Field field) {
		Field NewField = fieldRepository.getOne(id);
		if(NewField != null) {
			NewField.setCredits(field.getCredits());
			NewField.setDescription(field.getDescription());
			NewField.setName(field.getName());
			NewField.setPrice(field.getPrice());
			NewField.setScore(field.getScore());
			NewField.setType(field.getType());
			NewField.setUniversity(field.getUniversity());
			NewField.setYear(field.getYear());
			fieldRepository.save(NewField);
		}
		
	}

	@Override
	public void Remove(Long id) {
		Field field = fieldRepository.getOne(id);
		if(field != null) {
			fieldRepository.delete(field);
		}
	}

	@Override
	public void Create(Field field) {
		Field NewField = new Field();
		NewField.setCredits(field.getCredits());
		NewField.setDescription(field.getDescription());
		NewField.setName(field.getName());
		NewField.setPrice(field.getPrice());
		NewField.setScore(field.getScore());
		NewField.setType(field.getType());
		NewField.setUniversity(field.getUniversity());
		NewField.setYear(field.getYear());
		fieldRepository.save(NewField);
	}
	

}
