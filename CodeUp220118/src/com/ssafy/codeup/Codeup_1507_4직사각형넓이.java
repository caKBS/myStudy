package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1507_4직사각형넓이 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] board = new int[101][101];
		int count = 0;

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt() + 1;
			int y1 = sc.nextInt() + 1;
			int x2 = sc.nextInt() + 1;
			int y2 = sc.nextInt() + 1;

			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++) {
					board[r][c] = 1;
				}
			}
		}

		for (int r = 1; r < 101; r++) {
			for (int c = 1; c < 101; c++) {
				if (board[r][c] == 1) {
					count++;
				}
			}
		}

		System.out.println(count);

	}
}
// End