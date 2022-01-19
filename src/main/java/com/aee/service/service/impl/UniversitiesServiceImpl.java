package com.aee.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aee.service.models.university.University;
import com.aee.service.repository.university.FieldRepository;
import com.aee.service.repository.university.UniversityRepository;
import com.aee.service.service.UniversitiesService;

@Service
public class UniversitiesServiceImpl implements  UniversitiesService{

	@Autowired
	private UniversityRepository repository;
	
	@Autowired
	private FieldRepository fieldRepository;
	
	@Override
	public void Create(University uni) {
		University university = new University();
		university.setAddress(uni.getAddress());
		university.setDescription(uni.getDescription());
		university.setEmail(uni.getEmail());
		university.setImage(uni.getImage());
		university.setName(uni.getName());
		university.setPhoneNumber(uni.getPhoneNumber());
		university.setWebsite(uni.getWebsite());
		university.setZone(uni.getZone());
		repository.save(university);
	}

	@Override
	public void Update(Long id, University uni) {
		University university = repository.getOne(id);
		if(university != null) {
			university.setAddress(uni.getAddress());
			university.setDescription(uni.getDescription());
			university.setEmail(uni.getEmail());
			university.setImage(uni.getImage());
			university.setName(uni.getName());
			university.setPhoneNumber(uni.getPhoneNumber());
			university.setWebsite(uni.getWebsite());
			university.setZone(uni.getZone());
			repository.save(university);
		}
	}

	@Override
	public void Remove(Long id) {
		University uni = repository.getOne(id);
		if(uni!=null) {
			repository.delete(uni);
		}
	}

}
