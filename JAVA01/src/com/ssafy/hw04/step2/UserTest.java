package com.ssafy.hw04.step2;

public class UserTest {

	public static void main(String[] args) {
		User human = new User();

		System.out.println(human.id);
		System.out.println(human.password);
		System.out.println(human.name);
		System.out.println(human.email);
		System.out.println(human.age);
		
		System.out.println("---------------------------");

		User human2 = new User("jyp", "ssafy777", "JYP", "jyp@naver.com", 33);

		System.out.println(human2.id);
		System.out.println(human2.password);
		System.out.println(human2.name);
		System.out.println(human2.email);
		System.out.println(human2.age);

	}

}
