package com.tut;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("project started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory);

		// creating Student object//
		Student student = new Student();
		student.setId(102);
		student.setName("Champu Lala");
		student.setCity("Noida");
		System.out.println(student);

		// creating object of Address class
		Address address = new Address();
		address.setStreet("Stree 1");
		address.setCity("Delhi");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(123.456);
//		try {
//			FileInputStream fis = new FileInputStream("src/main/java/myImg.jpg");
//			byte[] data = new byte[fis.available()];
//			fis.read(data);
//			address.setImage(data);
//			fis.close();
//			System.out.println("Images saved into DB...");
//		} catch (Exception e) {
//			System.out.println("File not found got error---" + e);
//		}	

		Session session = factory.openSession();
		session.beginTransaction();
		session.save(student);
		session.save(address);
		session.getTransaction().commit();
		session.close();
	}
}
