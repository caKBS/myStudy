package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1873_상호의배틀피드 {

	static class tank {
		private static int H;
		private static int W;

		public tank() {
		}

		public tank(int H, int W) {
			this.H = H;
			this.W = W;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			boolean tankDetect = false;
			char[][] field = new char[H][W];
			// 맵 입력 받기
			for (int hIdx = 0; hIdx < H; hIdx++) {
				field[hIdx] = sc.next().toCharArray();
				// 전차 위치 찾기
				if (tankDetect == false) {
					for (int wIdx = 0; wIdx < W; wIdx++) {
						if (field[hIdx][wIdx] == '^' || field[hIdx][wIdx] == 'v' || field[hIdx][wIdx] == '<'
								|| field[hIdx][wIdx] == '>') {
							tank.H = hIdx;
							tank.W = wIdx;
							// 전차 발견하면 끝내고 더 이상 이 for문 진입 못하게 하기
							tankDetect = true;
							break;
						}
					}
				}
			}
			int orderNum = sc.nextInt();
			char[] orderArr = sc.next().toCharArray();
			// 명령을 하나하나 확인
			for (int oIdx = 0; oIdx < orderNum; oIdx++) {
				switch (orderArr[oIdx]) {
				// boundary의 한칸 안에 있고 한칸차이의 칸이 평지이면 이동.
				case 'U':
					field[tank.H][tank.W] = '^';
					if (tank.H >= 1 && field[tank.H - 1][tank.W] == '.') {
						field[tank.H][tank.W] = '.';
						tank.H -= 1;
						field[tank.H][tank.W] = '^';
					}
					break;
				case 'D':
					field[tank.H][tank.W] = 'v';
					if (tank.H <= H - 2 && field[tank.H + 1][tank.W] == '.') {
						field[tank.H][tank.W] = '.';
						tank.H += 1;
						field[tank.H][tank.W] = 'v';
					}
					break;
				case 'L':
					field[tank.H][tank.W] = '<';
					if (tank.W >= 1 && field[tank.H][tank.W - 1] == '.') {
						field[tank.H][tank.W] = '.';
						tank.W -= 1;
						field[tank.H][tank.W] = '<';
					}
					break;
				case 'R':
					field[tank.H][tank.W] = '>';
					if (tank.W <= W - 2 && field[tank.H][tank.W + 1] == '.') {
						field[tank.H][tank.W] = '.';
						tank.W += 1;
						field[tank.H][tank.W] = '>';
					}
					break;
				case 'S':
					// 위
					if (field[tank.H][tank.W] == '^') {
						// 현재 위치 위에서 부터 끝까지 추진
						for (int up = tank.H - 1; up >= 0; up--) {
							// 바운더리
							if (tank.H == 0) {
								break;
							}
							// 벽돌이면 평지바꾸고 소멸
							if (field[up][tank.W] == '*') {
								field[up][tank.W] = '.';
								break;
								// 강철문이면 바로 소멸
							} else if (field[up][tank.W] == '#') {
								break;
							}
						}
					}
					// 아래
					else if (field[tank.H][tank.W] == 'v') {
						// 현재 위치 아래에서 부터 끝까지 추진
						for (int dw = tank.H + 1; dw <= H - 1; dw++) {
							// 바운더리
							if (tank.H == H - 1) {
								break;
							}
							// 벽돌이면 평지바꾸고 소멸
							if (field[dw][tank.W] == '*') {
								field[dw][tank.W] = '.';
								break;
								// 강철문이면 바로 소멸
							} else if (field[dw][tank.W] == '#') {
								break;
							}
						}
					}
					// 좌
					else if (field[tank.H][tank.W] == '<') {
						// 현재 위치 좌에서 부터 끝까지 추진
						for (int le = tank.W - 1; le >= 0; le--) {
							// 바운더리
							if (tank.W == 0) {
								break;
							}
							// 벽돌이면 평지바꾸고 소멸
							if (field[tank.H][le] == '*') {
								field[tank.H][le] = '.';
								break;
								// 강철문이면 바로 소멸
							} else if (field[tank.H][le] == '#') {
								break;
							}
						}
					}
					// 우
					else if (field[tank.H][tank.W] == '>') {
						// 현재 위치 우에서 부터 끝까지 추진
						for (int ri = tank.W + 1; ri <= W - 1; ri++) {
							// 바운더리
							if (tank.W == W - 1) {
								break;
							}
							// 벽돌이면 평지바꾸고 소멸
							if (field[tank.H][ri] == '*') {
								field[tank.H][ri] = '.';
								break;
								// 강철문이면 바로 소멸
							} else if (field[tank.H][ri] == '#') {
								break;
							}
						}
					}
				}
			}
			System.out.printf("#%d ", tIdx);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
	}
}
//End