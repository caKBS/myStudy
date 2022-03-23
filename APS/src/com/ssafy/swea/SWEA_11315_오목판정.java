package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_11315_오목판정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int N = sc.nextInt();
			char[] tmp = new char[N + 5];
			char[][] board = new char[N + 5][N + 5];
			// 입력받기, 여유공간을 두기
			for (int nIdx = 1; nIdx <= N; nIdx++) {
				tmp = sc.next().toCharArray();
				for (int tmpIdx = 0; tmpIdx < N; tmpIdx++) {
					board[nIdx][tmpIdx + 1] = tmp[tmpIdx];
				}
			}

			boolean success = false;
			int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
			int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };
			// 모든 원소에 대해 확인.
			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= N; col++) {
					// 확인한 원소가 o이면
					if (board[row][col] == 'o') {
						// 주변에 o가 있는 곳을 확인하고
						for (int delta = 0; delta <= 7; delta++) {
							int tmpRow = row + dr[delta];
							int tmpCol = col + dc[delta];
							// 있으면 해당 방향으로 직진한다
							int cnt = 1;
							if (board[tmpRow][tmpCol] == 'o') {
								while (board[tmpRow][tmpCol] == 'o') {
									cnt++;
									tmpRow += dr[delta];
									tmpCol += dc[delta];
								}
							}
							// 오목 이상이면 성공이라 알린다.
							if (cnt >= 5) {
								success = true;
								break;
							}
						}
					}
				}
				// 성공일땐 모든 for문을 바로 빠져나오게끔
				if (success) {
					break;
				}
			}

			if (success) {
				System.out.printf("#%d %s\n", tIdx, "YES");
			} else {
				System.out.printf("#%d %s\n", tIdx, "NO");
			}
		}
	}
}
//End