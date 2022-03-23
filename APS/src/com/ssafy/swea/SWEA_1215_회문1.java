package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1215_회문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {

			int requiredLen = sc.nextInt();
			int halfRequ = requiredLen / 2;
			int size = 8;
			int lastIdx = size - 1;
			int firstIdx = 0;
			int palinCnt = 0;
			boolean odd;

			if (requiredLen % 2 == 1) {
				odd = true;
			} else {
				odd = false;
			}

			char[][] abcBoard = new char[size][size];
			for (int row = 0; row <= lastIdx; row++) {
				String newString = sc.next();
				for (int col = 0; col <= lastIdx; col++) {
					abcBoard[row][col] = newString.charAt(col);
				}
			}

			// 가로축으로 스캔
			for (int row = 0; row <= lastIdx; row++) {
				for (int col = halfRequ; col <= lastIdx - halfRequ + (1-(requiredLen%2)); col++) {
					if (odd) {
						boolean rowPalin=true;
						for (int dx = 1; dx <= halfRequ; dx++) {
							if (abcBoard[row][col + dx] != abcBoard[row][col - dx]) {
								rowPalin= false;
							}
						}
						if (rowPalin) {
							palinCnt++;
						}

					}else {
						boolean rowPalin=true;
						for (int dx = 1; dx <= halfRequ; dx++) {
							if (abcBoard[row][col + dx-1] != abcBoard[row][col - dx]) {
								rowPalin= false;
							}
						}
						if (rowPalin) {
							palinCnt++;
						}
					}
				}
			}
			
			//세로축으로 스캔
			for (int row = halfRequ; row <= lastIdx - halfRequ + (1-(requiredLen%2)); row++) {
				for (int col = 0; col <= lastIdx; col++) {
					if (odd) {
					    boolean colPalin=true;
						for (int dy = 1; dy <= halfRequ; dy++) {
							if (abcBoard[row+dy][col] != abcBoard[row-dy][col]) {
								colPalin= false;
							}
						}
						if (colPalin) {
							palinCnt++;
						}
					}else {
					    boolean colPalin=true;
						for (int dy = 1; dy <= halfRequ; dy++) {
							if (abcBoard[row+dy-1][col] != abcBoard[row-dy][col]) {
								colPalin= false;
							}
						}
						if (colPalin) {
							palinCnt++;
						}
					}

				}
			}
			System.out.printf("#%d %d\n", tIdx, palinCnt);
		}
	}
}
//End