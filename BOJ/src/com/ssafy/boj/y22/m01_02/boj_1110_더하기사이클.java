package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1110_더하기사이클 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int digit10 = 0;
		int digit1 = 0;
		int newNum = num;
		int cnt = 1;

		do {
			digit1 = newNum % 10;
			digit10 = newNum / 10;
			newNum = digit1 * 10 + ((digit1 + digit10) % 10);
			if (newNum == num) {
				break;
			}
			else {
				cnt++;
			}
		} while (true);
		
		System.out.println(cnt);

	}

}
// End
