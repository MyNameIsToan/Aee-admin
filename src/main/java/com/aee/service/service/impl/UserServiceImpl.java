package com.aee.service.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aee.service.models.ERole;
import com.aee.service.models.Role;
import com.aee.service.models.User;
import com.aee.service.repository.role.RoleRepository;
import com.aee.service.repository.user.UserRepository;
import com.aee.service.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void RegisterWithoutGoogle(User users) {
		boolean checkUser = userRepository.existsByEmail(users.getEmail());
		if (checkUser == false){
			User user = new User();
			user.setUsername(users.getUsername());
			user.setEmail(users.getEmail());
			user.setPassword(encoder.encode(users.getPassword()));
			Set<Role> roles = new HashSet<>();
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			user.setRoles(roles);
			userRepository.save(user);
		}
	}

	@Override
	public List<User> FindAll() {
		return userRepository.findAll();
	}
}
