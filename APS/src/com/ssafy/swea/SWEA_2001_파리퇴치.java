package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int maxSum = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] board = new int[N + 1][N + 1];

			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= N; col++) {
					board[row][col] = sc.nextInt();
				}
			}

			// 파리채 크기에 따라 가능한 파리채 시작점이 달라진다.
			int maxStartPoint = N - M + 1;
			for (int spR = 1; spR <= maxStartPoint; spR++) {
				for (int spL = 1; spL <= maxStartPoint; spL++) {
					int sum = 0;
					// 시작점으로 부터 파리채 크기만큼의 공간을 확인
					for (int row = spR; row < spR + M; row++) {
						for (int col = spL; col < spL + M; col++) {
							sum += board[row][col];
						}
					}
					if (maxSum < sum) {
						maxSum = sum;
					}
				}
			}
			System.out.printf("#%d %d\n", tIdx, maxSum);
		}
	}
}
//End