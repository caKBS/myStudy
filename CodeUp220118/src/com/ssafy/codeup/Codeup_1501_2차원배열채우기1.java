package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1501_2차원배열채우기1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int[][] game = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.printf("%d ", (i * num) + (j + 1));
			}
			System.out.println();
		}

	}
}
// End