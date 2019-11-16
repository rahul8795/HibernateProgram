package com.cts.test;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cts.pojo.Employee;
public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println(new Date(System.currentTimeMillis()));
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEno(999);
		emp.setEname("HHH");
		emp.setEsal(60000);
		emp.setEaddr("Ban");
		Integer eno1 = (Integer)session.save(emp);
		//int eno = eno1.intValue();
		session.persist(emp);
		tx.commit();
		System.out.println("Employee Inserted Successfully");
		System.out.println(new Date(System.currentTimeMillis()));
//		if(eno == 444){
//			System.out.println("Employee Inserted Succesfully");
//		}else{
//			System.out.println("Employee Insertion Failure");
//		}
		session.close();
		sessionFactory.close();
	}

}
