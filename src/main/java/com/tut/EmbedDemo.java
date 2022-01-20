package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Student student1 = new Student();
		student1.setName("Hello Dheeraj");
		student1.setId(102);
		student1.setCity("Newyork");
		Certificate cert = new Certificate();
		cert.setCourse("Java Development");
		cert.setDuration("3 month");
		student1.setCertificate(cert);

		Student student2 = new Student();
		student1.setName("Hello Princy Goel");
		student1.setId(104);
		student1.setCity("New Delhi");
		Certificate cert2 = new Certificate();
		cert2.setCourse("Software Testing and Automation Development");
		cert2.setDuration("6 month");
		student2.setCertificate(cert2);

		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();

		// saving objects
		s.save(student1);
		s.save(student2);

		txn.commit();
		s.close();

		session.close();
		factory.close();

	}

}
