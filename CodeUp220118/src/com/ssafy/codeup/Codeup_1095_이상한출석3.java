package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1095_이상한출석3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		

		// 첫 최소는 첫 입력, 기존 최소보다 입력이 작으면 최소 교체
		int min= sc.nextInt();
		for (int i = 1; i < num; i++) {
			int newNum= sc.nextInt();
			if(newNum<min) {
				min = newNum;
			}
		}
		
		// 출력
		System.out.printf("%d ", min);
		
		

	}
}
// End