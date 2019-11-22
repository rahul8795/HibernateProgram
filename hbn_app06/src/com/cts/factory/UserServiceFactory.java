package com.cts.factory;

import com.cts.service.UserService;
import com.cts.service.UserServiceImpl;

public class UserServiceFactory {
	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}
	public static UserService getUserService() {
		return userService;
	}
}
