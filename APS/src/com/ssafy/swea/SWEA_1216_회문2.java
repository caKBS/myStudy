package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1216_회문2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {
			int size = 100;
			int lastIdx = size - 1;
			int firstIdx = 0;

			int caseNum = sc.nextInt();
			char[][] board = new char[size][size];

			for (int row = firstIdx; row <= lastIdx; row++) {
				String newChar = sc.next();
				board[row] = newChar.toCharArray();
			}

			// 하나짜리도 회문이므로 최소 회문은 1로 둔다.
			int maxPalin = 1;
			// 가로 탐색
			for (int row = firstIdx; row <= lastIdx; row++) {
				for (int col = firstIdx + 1; col <= lastIdx - 1; col++) {
					// palin길이가 홀인 경우
					if (board[row][col + 1] == board[row][col - 1]) {
						int distance = 2;
						boolean flag = true;
						// [col]을 기준으로 대칭이면 어디까지 대칭인가를 확인
						while (flag) {
							if (col + distance > lastIdx || col - distance < firstIdx) {
								flag = false;
								// 어디까지 대칭인가를 통해 palin길이 확인
								if (maxPalin < 2 * distance - 1) {
									maxPalin = 2 * distance - 1;
								}
							} else {
								if (board[row][col + distance] != board[row][col - distance]) {
									flag = false;
									if (maxPalin < 2 * distance - 1) {
										maxPalin = 2 * distance - 1;
									}
								} else {
									distance++;
								}
							}
						}
					}
					// palin길이가 짝인 경우
					if (board[row][col] == board[row][col + 1]) {
						int distance = 1;
						boolean flag = true;
						// [col]과[col+1] 사이를 대칭축으로 어디까지 대칭인가를 확인
						while (flag) {
							if (col + 1 + distance > lastIdx || col - distance < firstIdx) {
								flag = false;
								if (maxPalin < 2 * distance) {
									maxPalin = 2 * distance;
								}
							} else {
								if (board[row][col + 1 + distance] != board[row][col - distance]) {
									flag = false;
									// 어디까지 대칭인가를 통해 palin길이 확인
									if (maxPalin < 2 * distance) {
										maxPalin = 2 * distance;
									}
								} else {
									distance++;
								}
							}
						}
					}

				}

			}
			// 세로 탐색
			for (int row = firstIdx + 1; row <= lastIdx - 1; row++) {
				for (int col = firstIdx; col <= lastIdx; col++) {
					// palin길이가 홀인 경우
					if (board[row + 1][col] == board[row - 1][col]) {
						int distance = 2;
						boolean flag = true;

						while (flag) {
							if (row + distance > lastIdx || row - distance < firstIdx) {
								flag = false;
								if (maxPalin < 2 * distance - 1) {
									maxPalin = 2 * distance - 1;
								}
							} else {
								if (board[row + distance][col] != board[row - distance][col]) {
									flag = false;
									if (maxPalin < 2 * distance - 1) {
										maxPalin = 2 * distance - 1;
									}
								} else {
									distance++;
								}
							}
						}
					}
					// palin길이가 짝인 경우
					if (board[row][col] == board[row + 1][col]) {
						int distance = 1;
						boolean flag = true;
						while (flag) {
							if (row + 1 + distance > lastIdx || row - distance < firstIdx) {
								flag = false;
								if (maxPalin < 2 * distance) {
									maxPalin = 2 * distance;
								}
							} else {
								if (board[row + 1 + distance][col] != board[row - distance][col]) {
									flag = false;
									if (maxPalin < 2 * distance) {
										maxPalin = 2 * distance;
									}
								} else {
									distance++;
								}
							}
						}
					}

				}
			}
			System.out.printf("#%d %d\n", tIdx, maxPalin);
		}
	}
}
//End