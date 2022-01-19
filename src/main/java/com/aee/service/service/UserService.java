package com.aee.service.service;

import java.util.List;

import com.aee.service.models.User;

public interface UserService {
	void RegisterWithoutGoogle(User users);
	List<User> FindAll();
}
