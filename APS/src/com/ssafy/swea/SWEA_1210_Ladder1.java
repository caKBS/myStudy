package com.ssafy.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1210_Ladder1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {

			// 테스트 케이스의 번호->버림
			int tIdxNum = sc.nextInt();

			// 입력 받아서 2차원 배열 만들기
			int size = 100;
			int lastIdx = 99;
			int firstIdx = 0;
			int[][] Board = new int[size][size];

			// 출발점 idx들의 배열(0행의 값이 1인 열 넘버를 저장)
			List<Integer> startPoints = new ArrayList<>();
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					int newNum = sc.nextInt();
					Board[row][col] = newNum;

					if (row == 0) {
						if (newNum == 1) {
							startPoints.add(col);
						}
					}
				}
			}

			// 여러 출발점 중 처음부터 시작
			for (int startCol : startPoints) {
				// movingRow,movingCol은 현재 위치
				int movingRow = 0;
				int movingCol = startCol;
				int goDown = 1;
				int goRight = 2;
				int goLeft = 3;
				// 현재 상태의 전진방향을 저장.
				// 첫시행 방향은 down
				int direction = 1;
				do {
					// 교차로 들어가기 직전에 방향을 결정하고
					// 교차로로 들어간다.
					// X A X
					// B C D
					// 가 있고 내가 A에 있고 direction = goDown이라면
					// D를 보고 다음에 우로갈지, B를 보고 다음에 좌로 갈지 판단하여
					// 다음 direction을 바꿔주고 direction조건에 맞는 게 없다면 현재 direction 유지하고
					// 현재 direction으로 한칸 이동하여 1회 이동 마무리. 이 이동을 99회하면 끝.
					switch (direction) {
					case 1: // goDown
						// 현재 상태가 goDown이라면 좌하, 우하의 1 여부 확인
						if (movingCol < lastIdx && Board[movingRow + 1][movingCol + 1] == 1) {
							direction = goRight;
						} else if (movingCol > firstIdx && Board[movingRow + 1][movingCol - 1] == 1) {
							direction = goLeft;
						}
						// 방향전환 조건에 맞지 않으면 현재상태유지
						else {
							direction = goDown;
						}
						movingRow++;
						break;
					case 2: // goRight
						// 현재 상태가 goRight이라면 우하의 1 여부 확인
						if (movingCol < lastIdx && Board[movingRow + 1][movingCol + 1] == 1) {
							direction = goDown;
						}
						// 방향전환 조건에 맞지 않으면 현재상태유지
						else {
							direction = goRight;
						}
						movingCol++;
						break;
					case 3: // goLeft
						// 현재 상태가 goLeft이라면 좌하의 1 여부 확인
						if (movingCol > firstIdx && Board[movingRow + 1][movingCol - 1] == 1) {
							direction = goDown;
						}
						// 방향전환 조건에 맞지 않으면 현재상태유지
						else {
							direction = goLeft;
						}
						movingCol--;
					}
				} while (movingRow < 99);

				// 마지막 행에 도착했을때 그값이 2이면 출발했던 열 넘버 출력
				if (Board[movingRow][movingCol] == 2) {
					System.out.printf("#%d %d\n", tIdx, startCol);
				}

			}
		}
	}
}
//End