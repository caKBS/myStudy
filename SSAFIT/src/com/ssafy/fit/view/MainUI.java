package com.ssafy.fit.view;

import java.util.Scanner;

public class MainUI {
	private static Scanner sc = new Scanner(System.in);
	private static MainUI instance = new MainUI();
	public static MainUI getInstance() {
		return instance;
	}
	private MainUI() {}
	
	public void service() {
		System.out.println("--------------------");
		System.out.println("자바로 구현하는 SSAFIT");
		System.out.println("--------------------");
		while (true) {
			System.out.println("--------------------");
			System.out.println("2. 회원가입 혹은 목록");
			System.out.println("1. 영상정보");
			System.out.println("0. 종료");
			System.out.println("--------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int sel = sc.nextInt();
			switch (sel) {
			case 2: 
				UserUI.getInstance().service();
				break;
			case 1: 
				VideoUI.getInstance().service();
				break;
			case 0: exit();
			default:
				System.out.println("입력이 잘못되었습니다.");
			}
		}
	}
	
	private void exit() {
		System.out.println("--------------------");
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
	}
}