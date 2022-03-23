package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1512_숫자등고선 {

	public static void main(String[] args) {

		// 입력받기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int stRow = sc.nextInt();
		int stCol = sc.nextInt();

		// 등고선 판 깔기
		int[][] mt = new int[num + 1][num + 1];

		// 시작위치로부터의 거리를 바탕으로 각 위치의 값을 계산
		for (int r = 1; r < num + 1; r++) {
			for (int c = 1; c < num + 1; c++) {
				mt[r][c] = (Math.abs(r - stRow) + Math.abs(c - stCol) + 1);
			}
		}

		// 출력
		for (int r = 1; r < num + 1; r++) {
			for (int c = 1; c < num + 1; c++) {
				System.out.print(mt[r][c] + " ");
			}
			System.out.println();
		}

	}
}
// End