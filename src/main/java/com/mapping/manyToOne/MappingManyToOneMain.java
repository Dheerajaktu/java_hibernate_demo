package com.mapping.manyToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.oneToOne.Question;

public class MappingManyToOneMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// for question 1
		QuestionDemo q1 = new QuestionDemo();
		q1.setQuestion_id(201);
		q1.setQuestion("What is Java?");

		// for answer 1
		AnswerDemo a1 = new AnswerDemo();
		a1.setId(2201);
		a1.setAnswer("Java is programming langauge");
		a1.setQuestion(q1);

		// for answer 2
		AnswerDemo a2 = new AnswerDemo();
		a2.setId(2202);
		a2.setAnswer("Java is a very secure programming langauge");
		a2.setQuestion(q1);

		// for answer 3
		AnswerDemo a3 = new AnswerDemo();
		a3.setId(2203);
		a3.setAnswer("Java run in billions of devices like mobile phones, tablet, computer, web, and many more");
		a3.setQuestion(q1);

		// adding all questions in a list//
		List<AnswerDemo> list = new ArrayList<AnswerDemo>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);

		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		s.save(q1);
		s.save(a1);
		s.save(a2);
		s.save(a3);
		txn.commit();
		s.close();
		factory.close();

	}

}
