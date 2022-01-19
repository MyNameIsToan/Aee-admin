package com.aee.service.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.aee.service.models.university.Field;
import com.aee.service.models.university.University;
import com.aee.service.payload.response.FieldResponse;
import com.aee.service.payload.response.UniversityResponse;

public class UniversityMapperImpl implements UniversityMapper {

	@Override
	public UniversityResponse fromUniversityToUniversityResponse(University university) {
		UniversityResponse response = new UniversityResponse();
		response.setAddress(university.getAddress());
		response.setDescription(university.getDescription());
		response.setEmail(university.getEmail());
		response.setId(university.getId());
		response.setImage(university.getImage());
		response.setName(university.getName());
		response.setPhoneNumber(university.getPhoneNumber());
		response.setTag(university.getTag().getName());
		response.setWebsite(university.getWebsite());
		response.setZone(university.getZone());
		return response;
	}

	@Override
	public FieldResponse fromFieldToFieldResponse(Field field) {
		FieldResponse fieldResponse = new FieldResponse();
		fieldResponse.setUniversityName(field.getUniversity().getName());
		fieldResponse.setUniversityImg(field.getUniversity().getImage());
		return fieldResponse;
	}

	@Override
	public List<FieldResponse> fromFieldListToFieldListResponse(List<Field> fields) {
		List<FieldResponse> list = new ArrayList<>();
		for (int i = 0; i < fields.size(); i++) {
			FieldResponse fieldResponse = new FieldResponse();
			fieldResponse.setCredits(fields.get(i).getCredits());
			fieldResponse.setDescription(fields.get(i).getDescription());
			fieldResponse.setId(fields.get(i).getId());
			fieldResponse.setName(fields.get(i).getName());
			fieldResponse.setPrice(fields.get(i).getPrice());
			fieldResponse.setScore(fields.get(i).getScore());
			fieldResponse.setTag(fields.get(i).getTag());
			fieldResponse.setType(fields.get(i).getType());
			fieldResponse.setYear(fields.get(i).getYear());
			fieldResponse.setUniversityImg(fields.get(i).getUniversity().getImage());
			fieldResponse.setUniversityName(fields.get(i).getUniversity().getName());
			list.add(fieldResponse);
		}
		return list;
	}

	@Override
	public Set<FieldResponse> fromFieldListToFieldListResponse(Set<Field> fields) {
		Set<FieldResponse> SetOfFields = new HashSet<>();
		for(Field s : fields) {
			FieldResponse response = new FieldResponse();
			response.setCredits(s.getCredits());
			response.setDescription(s.getDescription());
			response.setId(s.getId());
			response.setName(s.getName());
			response.setPrice(s.getPrice());
			response.setScore(s.getScore());
			response.setTag(s.getTag());
			response.setType(s.getType());
			response.setUniversityImg(s.getUniversity().getImage());
			response.setUniversityName(s.getUniversity().getName());
			response.setYear(s.getYear());
			SetOfFields.add(response);
		}
		return SetOfFields;
	}

	@Override
	public List<UniversityResponse> fromUniversityListToUniversityListResponse(List<University> universities) {
		List<UniversityResponse> list = new ArrayList<>();
		for (int i = 0; i < universities.size(); i++) {
			UniversityResponse response = new UniversityResponse();
			response.setAddress(universities.get(i).getAddress());
			response.setDescription(universities.get(i).getDescription());
			response.setEmail(universities.get(i).getEmail());
			response.setId(universities.get(i).getId());
			response.setImage(universities.get(i).getImage());
			response.setName(universities.get(i).getName());
			response.setPhoneNumber(universities.get(i).getPhoneNumber());
			response.setWebsite(universities.get(i).getWebsite());
			response.setZone(universities.get(i).getZone());
			list.add(response);
		}
		return list;
	}

}
