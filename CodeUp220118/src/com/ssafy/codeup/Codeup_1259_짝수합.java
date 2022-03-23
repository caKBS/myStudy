package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1259_짝수합 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int buf = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				buf = buf + i;

			}
		}
		System.out.printf("%d ", buf);

	}

}
// End 