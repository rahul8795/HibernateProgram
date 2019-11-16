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
		try {
			config = new Configuration();
			config.configure("/com/cts/resources/myconfig.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
//			Employee emp = (Employee) session.get(Employee.class, 111);
//			if(emp == null){
//				System.out.println("Employee does not exited");
//			}else{
//				System.out.println("Employee Details");
//				System.out.println("----------------------");
//				System.out.println("Employee Number   :"+emp.getEno());
//				System.out.println("Employee Name     :"+emp.getEname());
//				System.out.println("Employee Salary   :"+emp.getEsal());
//				System.out.println("Employee Address  :"+emp.getEaddr());
//			}
			System.out.println("Before Calling load()");
			Employee emp = (Employee) session.load(Employee.class, 111);
			System.out.println(emp.getEno());
			System.out.println("After Calling load()");
			System.out.println(emp.getEname());
//			if(emp == null){
//				System.out.println("Employee does not exited");
//			}else{
//				System.out.println("Employee Details");
//				System.out.println("----------------------");
//				System.out.println("Employee Number   :"+emp.getEno());
//				System.out.println("Employee Name     :"+emp.getEname());
//				System.out.println("Employee Salary   :"+emp.getEsal());
//				System.out.println("Employee Address  :"+emp.getEaddr());
//			}
	
			
		} catch (Exception e) {
			//tx.rollback();
			System.out.println();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
