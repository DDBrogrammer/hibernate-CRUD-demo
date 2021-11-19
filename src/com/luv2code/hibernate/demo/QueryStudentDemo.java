package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create session factory
		SessionFactory factory=new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Student.class)
				                   .buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try {session.beginTransaction();
			// query students
			List<Student> theStudent=session.createQuery("from Student").list();
			
			// display student
			displayStudents(theStudent);
			theStudent =(List<Student>) session.createQuery("from Student s where s.lastName='do'").list();
			
			//start a transaction
			displayStudents(theStudent);
			 
			theStudent =(List<Student>) 
					session.createQuery("from Student s where s.lastName='do' OR s.firstName='dai'").list();
			displayStudents(theStudent);
			theStudent =(List<Student>) 
					session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();
			// commit transaction
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
	}

	private static void displayStudents(List<Student> theStudent) {
		for (Student s:theStudent) {
			System.out.println(s.toString());
			
		}
	}

}
