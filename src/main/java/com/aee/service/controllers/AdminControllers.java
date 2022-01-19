package com.aee.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aee.service.models.User;
import com.aee.service.models.news.News;
import com.aee.service.models.university.Field;
import com.aee.service.models.university.University;
import com.aee.service.service.MajorService;
import com.aee.service.service.NewsService;
import com.aee.service.service.PostService;
import com.aee.service.service.RepliesService;
import com.aee.service.service.UniversitiesService;
import com.aee.service.service.UserService;

@RestController
@RequestMapping("/api/admin-access")
public class AdminControllers {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MajorService majorService;
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	RepliesService repliesService;
	
	@Autowired
	UniversitiesService universitiesService;
	
	@GetMapping(value="/user-list")
	public List<User> GetAll() {
		return userService.FindAll();
	}
	
	@PostMapping(value="/add-news")
	public void AddNew(@RequestBody News news) {
		newsService.CreateNews(news);
	}
	
	@PostMapping(value="/add-universities")
	public void AddUni(@RequestBody University uni) {
		universitiesService.Create(uni);
	}
	
	@PostMapping(value="/add-majors")
	public void AddField(@RequestBody Field field) {
		majorService.Create(field);
	}
	
	@DeleteMapping(value="/delete-news/{id}")
	public void DeleteNews(@PathVariable Long id) {
		newsService.DeleteNews(id);
	}
	
	@DeleteMapping(value="/delete-majors/{id}")
	public void DeleteMajor(@PathVariable Long id) {
		try {
			majorService.Remove(id);
		}catch (Exception e) {
			return;
		}
	}
	
	@DeleteMapping(value="/delete-universites/{id}")
	public void DeleteUni(@PathVariable Long id) {
		try {
			universitiesService.Remove(id);
		}catch (Exception e) {
			return;
		}

		
	}
	
	@DeleteMapping(value="/delete-posts/{id}")
	public void DeletePost(@PathVariable Long id) {
		postService.Remove(id);
	}
	@DeleteMapping(value="/delete-replies/{id}")
	public void DeleteReplies(@PathVariable Long id) {
		repliesService.Remove(id);
	}
	
	@PostMapping(value="/update-universities/{id}")
	public void UpdateUni(@PathVariable Long id, University uni) {
		universitiesService.Update(id, uni);
	}
	
	@PostMapping(value="/update-majors/{id}")
	public void UpdateMajor(@PathVariable Long id, Field field) {
		majorService.Update(id, field);
	}
	
	
}
