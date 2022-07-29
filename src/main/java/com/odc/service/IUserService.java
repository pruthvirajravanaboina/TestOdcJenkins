package com.odc.service;

import com.odc.model.User;

public interface IUserService {
	public User userSignin(String UserId, String password);

	public User userSignout(String userId, String password);

	public User changePassword(String userId, User user);


	public User userRegister(User user);
}