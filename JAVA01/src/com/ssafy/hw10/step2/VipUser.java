package com.ssafy.hw10.step2;

import java.io.Serializable;

public class VipUser extends User implements Serializable{
	private String grade;
	private int point;
	public VipUser() {
		super();
	}
	public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "User [id=" + super.getId() + ", password=" + super.getPassword() + ", name=" + super.getName() + ", email=" + super.getEmail()+ 
				", age=" + super.getAge() + ", grade=" + grade + ", point= " + point  ;
	}
	
	
}