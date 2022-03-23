package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_13705_파동파동 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();

			int[][] Board = new int[N + 1][N + 1];
			Board[R][C] = M;

			int max1 = Math.max(R - 1, N - R);
			int max2 = Math.max(C - 1, N - C);
			int realMax = Math.max(max1, max2);

			// distance : 시작점으로부터의 직선 거리
			for (int distance = 1; distance <= realMax; distance++) {
				// 상하한값 처리
				int newVal;
				if (M + distance * D <= 255 && M + distance * D >= 0) {
					newVal = M + distance * D;
				} else if (M + distance * D > 255) {
					newVal = 255;
				} else {
					newVal = 0;
				}
				// 기준점 좌우열 처리
				for (int newR = R - distance; newR <= R + distance; newR++) {
					if (newR <= N && newR >= 1) {
						if (C + distance <= N && C + distance >= 1) {
							Board[newR][C + distance] = newVal;
						}
						if (C - distance <= N && C - distance >= 1) {
							Board[newR][C - distance] = newVal;
						}
					}
				}
				// 기준점 상하행 처리
				for (int newC = C - distance; newC <= C + distance; newC++) {
					if (newC <= N && newC >= 1) {
						if (R + distance <= N && R + distance >= 1) {
							Board[R + distance][newC] = newVal;
						}
						if (R - distance <= N && R - distance >= 1) {
							Board[R - distance][newC] = newVal;
						}
					}
				}
			}

			// 요구조건대로 출력
			System.out.printf("#%d ", tIdx);
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= N; j++) {
					sum += Board[i][j];
				}
				System.out.printf("%d ", sum);
			}
			System.out.println();
		}
	}
}
//End