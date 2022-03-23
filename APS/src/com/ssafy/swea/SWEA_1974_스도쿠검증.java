package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {

	// 탈출조건이 엉성해서 이곳저곳 다수의 에러 디버깅으로 시간 많이 소요
	// 타인의 코드에서 탈출조건이나 다른 코드 스타일 찾아서 분석하고 공부하자
	// ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	// ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			boolean exit = false;
			boolean[] fullTF = { false, true, true, true, true, true, true, true, true, true };

			int[][] board = new int[9][9];

			// 입력 받으면서 행검사
			for (int row = 0; row < 9; row++) {
				// 숫자를 인덱스로 해서 그 숫자가 있는지 확인하는 배열.
				// fullTF는 모든 숫자가 차있는 상태를 나타냄.
				boolean[] TF = new boolean[9 + 1];
				for (int col = 0; col < 9; col++) {
					int newNum = sc.nextInt();
					board[row][col] = newNum;
					TF[newNum] = true;
				}
				if (exit==false && !isSame(TF, fullTF)) {
					System.out.printf("#%d %d\n", tIdx, 0);
					exit = true;
					// 여기는 입력을 받으면서 확인하니까
					// 조건에 만족하지 않더라도 끝까지 돌아야함.
					// 그래서 break를 걸어주지 않고 "exit==false"라는 조건을 추가함.
				}
			}
			// 위에서 불합격을 받으면 탈출해서 다음 케이스 진행.
			if (exit) {
				continue;
			}

			// 열검사
			for (int row = 0; row < 9; row++) {
				boolean[] TF = new boolean[9 + 1];
				for (int col = 0; col < 9; col++) {
					TF[board[col][row]] = true;
				}
				if (!isSame(TF, fullTF)) {
					System.out.printf("#%d %d\n", tIdx, 0);
					exit = true;
					break;
				}
			}
			if (exit) {
				continue;
			}

			// 3X3 사각형 검사
			for (int spR = 0; spR <= 6; spR = spR + 3) {
				for (int spC = 0; spC <= 6; spC = spC + 3) {
					boolean[] TF = new boolean[9 + 1];
					for (int row = 0; row <= 2; row++) {
						for (int col = 0; col <= 2; col++) {
							TF[board[spR + row][spC + col]] = true;
						}
					}
					if (!isSame(TF, fullTF)) {
						System.out.printf("#%d %d\n", tIdx, 0);
						exit = true;
						break;
					}
				}
				if (exit) {
					break;
				}
			}
			if (exit) {
				continue;
			}
			System.out.printf("#%d %d\n", tIdx, 1);
		}
	}

	// 1~9 숫자가 모두 존재하냐
	public static boolean isSame(boolean[] TF, boolean[] fullTF) {
		for (int i = 1; i <= 9; i++) {
			if (TF[i] != fullTF[i]) {
				return false;
			}
		}
		return true;
	}
}
//End