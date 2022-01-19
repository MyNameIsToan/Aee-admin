package com.aee.service.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aee.service.models.news.News;
import com.aee.service.models.university.Tag;
import com.aee.service.repository.news.NewsRepository;
import com.aee.service.repository.university.TagRepository;
import com.aee.service.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private TagRepository tagRepository;

	@Override
	public void CreateNews(News news) {
		News AddNews = new News();
		AddNews.setTitles(news.getTitles());
		AddNews.setUrl(news.getUrl());
		AddNews.setThumbnail(news.getThumbnail());
		Tag tag = tagRepository.getOne(2L);
		AddNews.setTag(tag);
		AddNews.setType(news.getType());
		AddNews.setCreatedBy("admin");
		AddNews.setModifiedBy("admin");
		Date currentSqlDate = new Date(System.currentTimeMillis());
		AddNews.setCreatedDate(currentSqlDate);
		AddNews.setModifiedDate(currentSqlDate);
		newsRepository.save(AddNews);
	}

	@Override
	public void DeleteNews(Long id) {
		News news = newsRepository.getOne(id);
		if(news != null) {
			newsRepository.delete(news);
		}
	}

}
