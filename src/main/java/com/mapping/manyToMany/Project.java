package com.mapping.manyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int pId;
	@Column(name = "project_name")
	private String projectName;

	@ManyToMany(mappedBy = "projects")
	private List<Emp> employee;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int pId, String projectName, List<Emp> employee) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.employee = employee;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Emp> employee) {
		this.employee = employee;
	}

}
