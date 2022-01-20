package com.mapping.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating Question object //
		Question q1 = new Question();
		q1.setQuestionId(10);
		q1.setQuestion("What is Java?");
		Answer a1 = new Answer();
		a1.setAnswerId(101);
		a1.setAnswer("Java is most popular programming langauge");
		q1.setAnswer(a1);

		// object another question answer
		Question q2 = new Question();
		q2.setQuestionId(11);
		q2.setQuestion("Which IDE we mostly use to Java application development?");
		Answer a2 = new Answer();
		a2.setAnswerId(102);
		a2.setAnswer("we use mostly Eclipse IDE to java developement");
		q2.setAnswer(a2);

		Session s = factory.openSession();

		Transaction txn = s.beginTransaction();

		s.save(q1);
		s.save(q2);
		s.save(a1);
		s.save(a2);

		txn.commit();
		s.close();
		factory.close();

	}

}
