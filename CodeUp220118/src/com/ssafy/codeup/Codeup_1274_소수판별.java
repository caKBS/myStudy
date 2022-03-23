package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1274_소수판별 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int prime = 1;

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				prime = 0;
			}
		}

		if (prime == 1) {
			System.out.printf("prime");
		} else {
			System.out.printf("not prime");
		}

	}

}
// End 