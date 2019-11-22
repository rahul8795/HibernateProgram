package com.cts.service;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.cts.pojo.User;
import com.cts.util.HibernateUtil;

public class UserServiceImpl implements UserService {

	@Override
	public String checkLogin(String uname, String upwd) {
		String status = "";
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			User user = (User) session.get(User.class, uname);
			if(user == null){
				status = "failure";
			}else{
				if(user.getUpwd().equals(upwd)){
					status = "success";
				}else{
					status = "failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
