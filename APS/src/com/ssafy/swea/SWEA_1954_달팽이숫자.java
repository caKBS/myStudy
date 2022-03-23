package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();
		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {
			int Num = sc.nextInt();
			int[][] Board = new int[Num + 1][Num + 1];
			// 직선 구간의 길이
			int straightFull = Num - 1;
			// 앞으로 남은 직선 구간
			int straight = straightFull;
			// 직선 구간 완료를 몇번했는지
			int strDone = 0;
			// 현재 방향상태
			int direction = 1;
			int goRight = 1;
			int goDown = 2;
			int goLeft = 3;
			int goUp = 4;
			// 행렬
			int row = 1;
			int col = 1;
			for (int nIdx = 1; nIdx <= Num * Num; nIdx++) {
				Board[row][col] = nIdx;
				switch (direction) {
				case 1: // goRight
					// 현재상태에 따른 운동방향으로 이동하며
					// 남은 직선 구간 감소
					col++;
					straight--;
					// 직선 구간 완료
					if (straight == 0) {
						// 방향 전환
						direction = goDown;
						// 공식에 따라 충전할 직선 구간 길이 결정
						straightFull = strFix(++strDone, straightFull);
						// 직선 구간 충전
						straight = straightFull;
					}
					break;
				case 2: // goDown
					row++;
					straight--;
					if (straight == 0) {
						direction = goLeft;
						straightFull = strFix(++strDone, straightFull);
						straight = straightFull;
					}
					break;
				case 3: // goLeft
					col--;
					straight--;
					if (straight == 0) {
						direction = goUp;
						straightFull = strFix(++strDone, straightFull);
						straight = straightFull;
					}
					break;
				case 4: // goUp
					row--;
					straight--;
					if (straight == 0) {
						direction = goRight;
						straightFull = strFix(++strDone, straightFull);
						straight = straightFull;
					}
				}
			}
			// 출력
			System.out.printf("#%d\n",tIdx);
			for (int i = 1; i <= Num; i++) {
				for (int j = 1; j <= Num; j++) {
					System.out.print(Board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	// 직선구간길이 : 첫 3회의 직선은 (N-1)의 길이를 갖고
	// 그 이후는 2회씩 길이가 1씩 줄어드는 양상을 가짐
	// ex) N==5이면 길이4:3회, 길이3:2회, 길이2:2회, 길이1:2회
	public static int strFix(int strDone, int straightFull) {
		if (strDone >= 3 && (strDone - 3) % 2 == 0) {
			return straightFull - 1;
		} else {
			return straightFull;
		}
	}
}
//End

//티스토리 메모사항ㅁㅁㅁㅁㅁㅁㅁ
// 직선거리 감소를 "수평->수직일때만 -1"로 생각할 수 있다.