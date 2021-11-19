package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create session factory
		SessionFactory factory=new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Student.class)
				                   .buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			int studentId =1;
			// get new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent=session.get(Student.class, studentId);
			//start a transaction
			
			myStudent.setFirstName("dai new");	
			session.getTransaction().commit();
			
			//new code
			session =factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("update all email");
			session.createQuery("update Student set email='foo@gmail.com' WHERE id=1").executeUpdate();
			session.getTransaction().commit();
			}finally {
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
