package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			
			//use the session object to save Java object
			System.out.println("Create new student object...");
			Student tempStudent= new Student("daffy", "duck", "duck.@gmail.com");
			//create a student object
			
			//start a transaction
			session.beginTransaction();
			
			//save the student obj
			System.out.println("Saving the student...");
			session.save(tempStudent);
			// commit transaction
			System.out.println("saving student");
			session.getTransaction().commit();
			//NEW CODE
			
			// find out the student id
			System.out.println("id: "+ tempStudent.getId());
			
			//get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("id: "+ tempStudent.getId());
			
			Student getStudent=session.get(Student.class, tempStudent.getId());
				System.out.println("Stundet: "+getStudent.toString());
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
