package com.aee.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.aee.service.models.news.News;
import com.aee.service.payload.response.NewsResponse;

public class NewsMapperImpl implements NewsMapper{

	@Override
	public NewsResponse fromNewsToNewsResponse(News news) {
		NewsResponse newsResponse = new NewsResponse();
		newsResponse.setTag(news.getTag().getName());
		newsResponse.setThumbnail(news.getThumbnail());
		return newsResponse;
	}

	@Override
	public List<NewsResponse> fromNewsListToNewsResponseList(List<News> content) {
		List<NewsResponse> list = new ArrayList<>();
		for(int i = 0; i < content.size(); i++ ) {
			NewsResponse newsResponse = new NewsResponse();
			newsResponse.setContent(content.get(i).getContent());
			newsResponse.setId(content.get(i).getId());
			newsResponse.setThumbnail(content.get(i).getThumbnail());
			newsResponse.setTitles(content.get(i).getTitles());
			newsResponse.setType(content.get(i).getType());
			newsResponse.setUrl(content.get(i).getUrl());
			list.add(newsResponse);
		}
		return list;
	}

}
