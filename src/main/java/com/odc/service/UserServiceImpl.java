package com.odc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.exception.PasswordMismatchException;
import com.odc.exception.UserNotFoundException;
import com.odc.model.User;
import com.odc.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	public IUserRepository userRepo;

	@Override
	public User userSignin(String userId, String password) throws UserNotFoundException,PasswordMismatchException {
		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("You have entered wrong User Id"));
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			} 
			else {
				throw new PasswordMismatchException("You have entered wrong password");
			}
		}
		return user;
	}
			/*
			 * } else { throw new UserNotFoundException("You have entered wrond User Id");
			 */
	

	@Override
	public User changePassword(String userId, User user) {
		Optional<User> changePassword = userRepo.findById(user.getUserId());
		if (changePassword != null) {
			return userRepo.save(user);
		} else {
			throw new UserNotFoundException("Password Not Updated. User Not Found");
		}
	}

	@Override
	public User userSignout(String userId, String password) {
		User user = userRepo.findById(userId).get();
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				throw new PasswordMismatchException("You have entered wrong password");
			}
		} else {
			throw new UserNotFoundException("You have entered wrond User Id");

		}
	}

	@Override
	public User userRegister(User user) {
		User user1 = null;
		Optional<User> opUser = userRepo.findById(user.getUserId());
		if (opUser.isEmpty()) {
			user1 = userRepo.save(user);
			return user1;
		} else {
			throw new UserNotFoundException("UserId already Exists .");
		}

	}
}