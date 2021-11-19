package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			
			//create 3 student object
			Student tempStudent1= new Student("do", "dai", "demo2.@gmail.com");
			Student tempStudent2= new Student("do", "dai", "demo2.@gmail.com");
			Student tempStudent3= new Student("asd", "joe", "demo3.@gmail.com");
			//start a transaction
			session.beginTransaction();
			
			//save the student obj
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction
			System.out.println("saving student");
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
	}

}
