package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			int studentId =3;
			// get new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			/*
			 * Student myStudent=session.get(Student.class, studentId); //start a
			 * transaction // delete student session.delete(myStudent);
			 */
			
			
			// delete student id=2
			System.out.println("Delete student where id =2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			}finally {
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
