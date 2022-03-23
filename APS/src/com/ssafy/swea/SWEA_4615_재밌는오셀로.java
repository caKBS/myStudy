package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_4615_재밌는오셀로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			// 초기 판 세팅
			int[][] Board = new int[N + 5][N + 5];
			Board[N / 2][N / 2] = 2;
			Board[N / 2 + 1][N / 2 + 1] = 2;
			Board[N / 2][N / 2 + 1] = 1;
			Board[N / 2 + 1][N / 2] = 1;

			int inRow;
			int inCol;
			// 검은색(1), 흰색(2)
			int inColor;
			int empty = 0;
			int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
			int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };
			int imPos = 0;

			// M번의 입력받기
			for (int in = 1; in <= M; in++) {
				// 아직 입력 놓지 말고 놓을 수 있는지 확인하고 놓기
				inRow = sc.nextInt();
				inCol = sc.nextInt();
				inColor = sc.nextInt();
				// 1->2, 2->1
				int reverseColor = ((inColor - 1) ^ 1) + 1;
				int reverseCnt = 0;

				// 일단 놓을곳주변에 나와 다른 돌이 어디 있는지 확인해서
				// 나아갈 방향 정하기
				for (int delta = 0; delta <= 7; delta++) {
					// 내주변 반대편 돌을 탐색
					if (reverseColor == Board[inRow + dr[delta]][inCol + dc[delta]]) {
						int direction = delta;
						int tmpR = inRow;
						int tmpC = inCol;
						boolean success = false;
						int cnt = 0;

						// 나와 같은 놈 만날때 까지 나아가기
						// 길 끝에 내 아군이 있는 지 확인
						while (true) {
							tmpR = tmpR + dr[direction];
							tmpC = tmpC + dc[direction];
							if (Board[tmpR][tmpC] == inColor) {
								success = true;
								break;
							} else if (Board[tmpR][tmpC] == empty) {
								break;
							}
							cnt++;
						}
						// 가는 길에 있는 반대놈은 리버스해서 내편으로 만들기
						if (success) {
							for (int i = 1; i <= cnt; i++) {
								tmpR = tmpR - dr[direction];
								tmpC = tmpC - dc[direction];
								Board[tmpR][tmpC] = ((Board[tmpR][tmpC] - 1) ^ 1) + 1;
								reverseCnt++;
							}
						}
					}
				}
				// 놓을 수 있으면 놓기
				if (reverseCnt > 0) {
					Board[inRow][inCol] = inColor;
					imPos = 0;
				}
				// 놓을 수 없으면 불가능 횟수 +1, 상대방에게 플레이 넘기기
				// 불가능 횟수가 연속 2번이면 게임 끝
				else {
					imPos++;
					continue;
				}
				if(imPos>=2) {
					break;
				}
			}
			// 출력
			int blackNum = 0;
			int whiteNum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (Board[i][j] == 1) {
						blackNum++;
					} else if (Board[i][j] == 2) {
						whiteNum++;
					}
				}
			}
			System.out.printf("#%d %d %d\n", tIdx, blackNum, whiteNum);
		}
	}
}
//End