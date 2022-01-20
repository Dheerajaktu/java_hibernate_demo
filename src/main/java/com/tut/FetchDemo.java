package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// using get in hibernate we can also use load here to fetch data from DB //

		// using hibernate get below
		Student studentData = (Student) session.get(Student.class, 102);
		System.out.println("Student Data from Database===" + studentData);

		// using hibernate load below
		Address addressData = (Address) session.load(Address.class, 1);
		System.out.println("Address data from DB===" + addressData);

		session.close();
		factory.close();

	}

}
