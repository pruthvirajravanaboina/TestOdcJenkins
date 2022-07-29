package com.odc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odc.model.User;
import com.odc.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	public IUserService userService;

	@GetMapping(path = "/signin/{userId}/{password}")
	public User userSignin(@PathVariable String userId, @PathVariable String password) {
		User signinSuccess = userService.userSignin(userId, password);
		return signinSuccess;
	}

	@GetMapping(path = "/signout/{userId}/{password}")
	public User userSignout(@PathVariable String userId, @PathVariable String password) {
		User signoutSuccess = userService.userSignout(userId, password);
		return signoutSuccess;
	}

	@PutMapping(path = "/changePassword/{userId}")
	public User changePassword(@PathVariable String userId, @RequestBody User user) {
		User changePasswordSuccess = userService.changePassword(userId, user);
		return changePasswordSuccess;
	}
	@PostMapping(path = "/register")
	public User userRegistert(@RequestBody User user) {
		User registerSuccess = userService.userRegister(user);
		return registerSuccess;
	}

}