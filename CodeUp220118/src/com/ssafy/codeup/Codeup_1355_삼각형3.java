package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1355_삼각형3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n-i; j++) {
				System.out.printf(" ");
			}
			for (int j = n-i; j < n; j++) {
				System.out.printf("*");
			}
			System.out.printf("\n");
		}

	}
}
// End