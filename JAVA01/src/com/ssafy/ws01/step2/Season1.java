package com.ssafy.ws01.step2;

import java.util.Scanner;

public class Season1 {
	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			Scanner sc = new Scanner(System.in);
			int month = sc.nextInt();
			if (month >= 3 && month <= 5) {
				System.out.printf("%d월은 봄입니다. \n", month);
			} else if (month >= 6 && month <= 8) {
				System.out.printf("%d월은 여름입니다. \n", month);
			} else if (month >= 9 && month <= 11) {
				System.out.printf("%d월은 가을입니다. \n", month);
			} else {
				System.out.printf("%d월은 겨울입니다. \n", month);
			}
		}

	}
}
