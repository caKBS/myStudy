package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1209_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {

			// 테스트 케이스의 번호->버림
			int tIdxNum = sc.nextInt();

			// 입력 받아서 2차원 배열 만들기
			int size = 100;
			int[][] Board = new int[size][size];
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					int newNum = sc.nextInt();
					Board[row][col] = newNum;
				}
			}

			// 2중 for문으로 2차원배열 전체 한번 돌기
			int maxSum = Integer.MIN_VALUE;
			for (int row = 0; row < size; row++) {
				// 행기준합
				int rowSum = 0;
				// 열기준합
				int colSum = 0;
				// 남동방향기준합
				int seSum = 0;
				// 남서방향기준합
				int swSum = 0;
				for (int col = 0; col < size; col++) {
					// 행기준합
					rowSum += Board[row][col];
					// 열기준합
					colSum += Board[col][row];
					// 남동방향기준합
					if (row == col) {
						seSum += Board[row][col];
					}
					// 남서방향기준합
					if ((row + col) == (size - 1)) {
						swSum += Board[row][col];
					}

				}

				// 기존 max보다 크면 업데이트
				if (rowSum > maxSum) {
					maxSum = rowSum;
				}
				if (colSum > maxSum) {
					maxSum = colSum;
				}
				if (seSum > maxSum) {
					maxSum = seSum;
				}
				if (swSum > maxSum) {
					maxSum = swSum;
				}
			}
			System.out.printf("#%d %d\n", tIdx, maxSum);
		}
	}
}
//End