package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1380_주사위합 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 1; i < n; i++) {
			if ((i > 6) || (n - i > 6)) {
				continue;
			}
			System.out.printf("%d %d \n", i, n - i);
		}

	}
}
// End