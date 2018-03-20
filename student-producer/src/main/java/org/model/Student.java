package org.model;

public class Student {
	private String studId;
	private String name;
	private String college;
	

	public Student() {
	}

	public String getName() {
		return name;
	}

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}