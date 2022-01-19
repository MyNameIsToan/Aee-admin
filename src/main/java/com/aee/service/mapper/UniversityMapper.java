package com.aee.service.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.aee.service.models.university.Field;
import com.aee.service.models.university.University;
import com.aee.service.payload.response.FieldResponse;
import com.aee.service.payload.response.UniversityResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UniversityMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "zone",target = "zone")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "phoneNumber",target = "phoneNumber")
    @Mapping(source = "website",target = "website")
    @Mapping(source = "description",target = "description")
    @Mapping(source = "tag.name",target = "tag")
    @Mapping(source = "image",target = "image")
    @BeanMapping(ignoreByDefault = true)
    UniversityResponse fromUniversityToUniversityResponse(University university);

    @Mapping(source = "university.name", target = "universityName")
    @Mapping(source = "university.image",target = "universityImg")
    FieldResponse fromFieldToFieldResponse(Field field);

    @IterableMapping(elementTargetType = FieldResponse.class)
    List<FieldResponse> fromFieldListToFieldListResponse(List<Field> fields);

    @IterableMapping(elementTargetType = FieldResponse.class)
    Set<FieldResponse> fromFieldListToFieldListResponse(Set<Field> fields);

    @IterableMapping(elementTargetType = UniversityResponse.class)
    List<UniversityResponse> fromUniversityListToUniversityListResponse(List<University> universities);
}
