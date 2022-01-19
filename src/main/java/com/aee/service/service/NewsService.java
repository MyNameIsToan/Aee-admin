package com.aee.service.service;

import com.aee.service.models.news.News;

public interface NewsService {
	void CreateNews(News news);
	void DeleteNews(Long id);
}
