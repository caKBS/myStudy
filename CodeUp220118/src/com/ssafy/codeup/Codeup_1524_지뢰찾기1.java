package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1524_지뢰찾기1 {

	public static void main(String[] args) {

		int mine = 1;

		// 행렬 입력 받기
		Scanner sc = new Scanner(System.in);

		int[][] game = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				game[i][j] = sc.nextInt();
				;
			}
		}

		// 좌표 받기
		int indexY = sc.nextInt() - 1;
		int indexX = sc.nextInt() - 1;

		// Delta, 주의. 아래와 오른쪽이 양의 방향이다
		int[] dy = { 1, 1, 1, 0, -1, -1, -1, 0 };
		int[] dx = { 1, 0, -1, -1, -1, 0, 1, 1 };
		int mineCount = 0;

		// 지뢰 찾으면 count++
		for (int i = 0; i < 8; i++) {
			// Boundary처리
			if ((indexY + dy[i]) > 8 || (indexY + dy[i]) < 0 || (indexX + dx[i]) > 8 || (indexX + dx[i]) < 0) {
				continue;
			}
			// count
			if (game[indexY + dy[i]][indexX + dx[i]] == mine) {
				mineCount++;
			}
		}

		// 출력
		if (game[indexY][indexX] == mine) {
			System.out.print(-1);
		} else {
			System.out.print(mineCount);
		}

	}
}
// End