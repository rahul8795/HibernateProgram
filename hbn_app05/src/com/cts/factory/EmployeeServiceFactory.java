package com.cts.factory;

import com.cts.service.EmployeeService;
import com.cts.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeService empService;
	static{
		empService = new EmployeeServiceImpl();
	}
	public static EmployeeService getEmployeeService() {
		return empService;
	}
}
