package com.aee.service.mapper;

import com.aee.service.form.CreateAccountForm;
import com.aee.service.models.User;
import com.aee.service.payload.response.LoginResponse;
import com.aee.service.payload.response.UserResponse;
import com.aee.service.security.services.UserDetailsImpl;

public class AuthMapperImpl implements AuthMapper {

	@Override
	public User fromCreateFormToAccount(CreateAccountForm createCustomerForm) {
		User user = new User();
		user.setEmail(createCustomerForm.getEmail());
		user.setUid(createCustomerForm.getFirebaseUserId());
		return user;
	}

	@Override
	public LoginResponse fromUserToLoginResponse(UserDetailsImpl user) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setFullName(user.getUsername());
		loginResponse.setAvatarPath(user.getAvatarPath());
		return loginResponse;
	}

	@Override
	public User fromUserDetailToUser(UserDetailsImpl user) {
		User users = new User();
		users.setAvatarPath(user.getAvatarPath());
		users.setEmail(user.getEmail());
		users.setUsername(user.getUsername());
		return users;
	}

	@Override
	public UserResponse fromUserToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setAvatarPath(user.getAvatarPath());
		userResponse.setEmail(user.getEmail());
		userResponse.setUsername(user.getUsername());
		return userResponse;
	}

	@Override
	public LoginResponse fromUserToLoginResponse(User user) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setFullName(user.getUsername());
		loginResponse.setAvatarPath(user.getAvatarPath());
		return loginResponse;
	}

}
