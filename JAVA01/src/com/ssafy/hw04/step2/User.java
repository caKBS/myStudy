package com.ssafy.hw04.step2;

public class User {
	String id;
	String password;
	String name;
	String email;
	int age;

	public User() {
		id = "kbs";
		password = "ssafy";
		name = "KimBS";
		email = "kbs_ssafy@naver.com";
		age = 26;
	}

	public User(String id, String password, String name, String email, int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}

}
