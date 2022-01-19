package com.aee.service.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.aee.service.models.news.News;
import com.aee.service.payload.response.NewsResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NewsMapper {

    @Mapping(source = "tag.name",target = "tag")
    @Mapping(source = "thumbnail",target = "thumbnail")
    NewsResponse fromNewsToNewsResponse(News news);

    @IterableMapping(elementTargetType = NewsResponse.class)
    List<NewsResponse> fromNewsListToNewsResponseList(List<News> content);
}
