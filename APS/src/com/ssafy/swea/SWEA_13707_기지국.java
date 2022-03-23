package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_13707_기지국 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int n = sc.nextInt();
			// boundary조건 안쓰기 위해 padding 제공
			char[][] land = new char[n + 10][n + 10];
			// 해당 위치의 집이 관심있는(커버되지않는) 집인가
			boolean[][] nointerest = new boolean[n + 10][n + 10];

			for (int row = 3; row < n + 3; row++) {
				String newStr = sc.next();
				char[] charArr = newStr.toCharArray();
				for (int col = 3; col < n + 3; col++) {
					land[row][col] = charArr[col - 3];
					char target = charArr[col - 3];
					// (target - 'A' + 1) : A,B,C에 대하여 각각 1,2,3이 들어가게끔
					if (target >= 'A' && target <= 'C') {
						// 기준점에서 동행에 대해 전파 커버
						for (int newCol = col - (target - 'A' + 1); newCol <= col + (target - 'A' + 1); newCol++) {
							nointerest[row][newCol] = true;
						}
						// 기준점에서 동렬에 대해 전파 커버
						for (int newRow = row - (target - 'A' + 1); newRow <= row + (target - 'A' + 1); newRow++) {
							nointerest[newRow][col] = true;
						}
					}
				}
			}
			int cnt = 0;
			for (int row = 3; row < n + 3; row++) {
				for (int col = 3; col < n + 3; col++) {
					// 집이고 관심있으면(전파 커버가 안되면) 카운트
					if (land[row][col] == 'H' && nointerest[row][col] == false) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", tIdx, cnt);
		}
	}
}
//End