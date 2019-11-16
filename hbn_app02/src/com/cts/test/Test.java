package com.cts.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cts.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try{
			config = new Configuration();
			config.configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			tx.begin();
			Employee emp = new Employee();
			emp.setEno(124);
			emp.setEname("XXX");
			emp.setEsal(40000);
			emp.setEaddr("Chennai");
			//session.update(emp);
			session.saveOrUpdate(emp);
			tx.commit();
			System.out.println("Employee Inserted/Updated Succesfully");
			
		}catch(Exception e){
			//tx.rollback();
			System.out.println("Employee Insertion/Updation Failure");
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}

}
