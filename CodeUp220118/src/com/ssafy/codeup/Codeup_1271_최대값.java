package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1271_최대값 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int max = sc.nextInt();
		for (int i = 0; i < n - 1; i++) {
			int freshman = sc.nextInt();
			if (max < freshman) {
				max = freshman;
			}
		}

		System.out.printf("%d", max);
	}

}
// End
