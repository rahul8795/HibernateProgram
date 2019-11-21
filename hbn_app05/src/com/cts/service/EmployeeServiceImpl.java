package com.cts.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.cts.pojo.Employee;
import com.cts.util.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {
	Employee emp;
  
	public Employee search(int eno) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			emp = (Employee) session.get(Employee.class,eno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
