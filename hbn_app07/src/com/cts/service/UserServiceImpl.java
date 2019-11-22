package com.cts.service;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.cts.pojo.User;
import com.cts.util.HibernateUtil;

public class UserServiceImpl implements UserService {
	String status = "";
	@Override
	public String register(String uname, String upwd, String uemail, String umobile) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessinFactory();
			Session session = sessionFactory.openSession();
			User user = (User) session.get(User.class, uname);
			if(user == null) {
				Transaction tx = session.beginTransaction();
				user = new User();
				user.setUname(uname);
				user.setUpwd(upwd);
				user.setUemail(uemail);
				user.setUmobile(umobile);
				String pk_Val = (String) session.save(user);
				tx.commit();
				//System.out.println(pk_Val);
				if(pk_Val.equals(uname)) {
					status = "success";
				}else{
					status = "failure";
				}
			}else{
				status = "exited";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
