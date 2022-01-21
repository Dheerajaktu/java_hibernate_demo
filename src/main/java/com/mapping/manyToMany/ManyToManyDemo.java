package com.mapping.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Emp emp1 = new Emp();
		emp1.setEid(10);
		emp1.setName("Dheeraj Sharma");
		Project p1 = new Project();
		p1.setpId(101);
		p1.setProjectName("efarming app");

		Emp emp2 = new Emp();
		emp2.setEid(11);
		emp2.setName("Princy Goel");
		Project p2 = new Project();
		p2.setpId(102);
		p2.setProjectName("Travelling project");

		Emp emp3 = new Emp();
		emp3.setEid(13);
		emp3.setName("Pawan Gangwar");
		Project p3 = new Project();
		p3.setpId(103);
		p3.setProjectName("Google pay project");

		List<Emp> empList = new ArrayList<Emp>();
		List<Project> proList = new ArrayList<Project>();

		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		proList.add(p1);
		proList.add(p2);
		proList.add(p3);

		emp1.setProjects(proList);
		p1.setEmployee(empList);
		
		emp2.setProjects(proList);
		p2.setEmployee(empList);
		
		emp3.setProjects(proList);
		p3.setEmployee(empList);
		
		

		Session s = factory.openSession();
		Transaction txn = s.beginTransaction();
		s.save(emp1);
		s.save(p1);
		s.save(emp2);
		s.save(p2);
		s.save(emp3);
		s.save(p3);

		txn.commit();

		s.close();

		factory.close();
	}

}
