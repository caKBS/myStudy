package com.ssafy.fit.view;

import java.util.Scanner;

import com.ssafy.fit.model.User;
import com.ssafy.fit.model.dao.IUserDao;
import com.ssafy.fit.model.dao.UserDao;

public class UserUI {
	private static Scanner sc = new Scanner(System.in);
	private static UserUI instance = new UserUI();

	public static UserUI getInstance() {
		return instance;
	}

	private UserUI() {
	}


	public void service() {
		while (true) {
			System.out.println("--------------------");
			System.out.println("2. 회원가입");
			System.out.println("1. 회원목록");
			System.out.println("0. 이전으로");
			System.out.println("--------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				UserDao.getInstance().loadData();
				break;
			case 2:
				System.out.println("회원가입을 진행합니다.");
                System.out.println("");
                System.out.println("ID:" );
                String id = sc.next();

                System.out.println("Password:" );
                String password = sc.next();

                System.out.println("이름:" );
                String name = sc.next();

                System.out.println("email:" );
                String email = sc.next();

                System.out.println("나이:" );
                int age = sc.nextInt();

                User u = new User();
                u.setId(id);
                u.setPassword(password);
                u.setName(name);
                u.setEmail(email);
                u.setAge(age);

                UserDao.getInstance().add(u);
                UserDao.getInstance().saveData();
                
				break;
			
			case 0:
				return;
			default:
				System.out.println("입력이 잘못되었습니다.");
			}
		}
	}

}
