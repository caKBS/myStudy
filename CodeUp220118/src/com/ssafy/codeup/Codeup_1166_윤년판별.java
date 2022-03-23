package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1166_윤년판별 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();

		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			System.out.printf("yes");
		} else {
			System.out.printf("no");
		}

	}

}
// End