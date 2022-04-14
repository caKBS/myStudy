package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class SWEA_5650_핀볼게임 {
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static char[] state = { 'R', 'U', 'L', 'D' };

	public static class coor {
		public int row;
		public int col;

		public coor(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "coor [row=" + row + ", col=" + col + "]";
		}

	}

	public static class dir {
		// state를 String이 아닌 char로 하면 단순 "=="로 비교 가능.
		public char state;
		public int dr;
		public int dc;

		public dir(char state, int dr, int dc) {
			this.state = state;
			this.dr = dr;
			this.dc = dc;
		}

		@Override
		public String toString() {
			return "dir [state=" + state + ", dr=" + dr + ", dc=" + dc + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			int N = Integer.parseInt(br.readLine());

			// 크기1짜리 패딩
			int[][] board = new int[N + 2][N + 2];
			// 입력받기
			for (int row = 0; row < N + 2; row++) {
				for (int col = 0; col < N + 2; col++) {
					if (row == N + 1 || row == 0 || col == N + 1 || col == 0) {
						board[row][col] = -9;
					}
				}
			}

			// 입력받기
			List<coor>[] wHole = new LinkedList[11];
			for (int i = 6; i <= 10; i++) {
				wHole[i] = new LinkedList<>();
			}
			for (int row = 1; row < N + 1; row++) {
				String[] sInfo = br.readLine().split(" ");
				for (int col = 0; col < N; col++) {
					board[row][col + 1] = Integer.parseInt(sInfo[col]);
					// 웜홀이면
					if (board[row][col + 1] >= 6 && board[row][col + 1] <= 10) {
						wHole[board[row][col + 1]].add(new coor(row, col + 1));
					}
				}
			}

			// 출발위치
			int maxPnt = 0;
			for (int row = 1; row < N + 1; row++) {
				for (int col = 1; col < N + 1; col++) {
					// 빈곳에서 출발
					if (board[row][col] == 0) {
						// 처음 진행방향 우,상,좌,하
						for (int d = 0; d < 4; d++) {
							int[] pnt = new int[1];
							dir curDir = new dir(state[d], dr[d], dc[d]);
							coor curr = new coor(row, col);

							// 게임시작, 종료조건 : 제자리로 왔을때 블랙홀을 만났을때
							game: do {
								// 다음 칸 이동
								curr.row += curDir.dr;
								curr.col += curDir.dc;
								// 현재 칸 정보 파악
								switch (board[curr.row][curr.col]) {
								// 현재 칸이 3사분면향 삼각형
								case 1:
									// 진입방향
									switch (curDir.state) {
									// 우방향으로 진입했으면
									case 'R':
										// 포인트 적립 및 좌로 튕겨져 나가기
										changeDir('L', curDir, pnt);
										break;
									// 좌방향으로 진입했으면
									case 'L':
										// 포인트 적립 및 상으로 튕겨져 나가기
										changeDir('U', curDir, pnt);
										break;
									// 상방향으로 진입했으면
									case 'U':
										// 포인트 적립 및 하로 튕겨져 나가기
										changeDir('D', curDir, pnt);
										break;
									// 하방향으로 진입했으면
									case 'D':
										// 포인트 적립 및 우로 튕겨져 나가기
										changeDir('R', curDir, pnt);
										break;
									}
									break;

								case 2:
									// 진입방향
									switch (curDir.state) {
									// 우방향으로 진입했으면
									case 'R':
										// 포인트 적립 및 좌로 튕겨져 나가기
										changeDir('L', curDir, pnt);
										break;
									// 좌방향으로 진입했으면
									case 'L':
										// 포인트 적립 및 하으로 튕겨져 나가기
										changeDir('D', curDir, pnt);
										break;
									// 상방향으로 진입했으면
									case 'U':
										// 포인트 적립 및 우로 튕겨져 나가기
										changeDir('R', curDir, pnt);
										break;
									// 하방향으로 진입했으면
									case 'D':
										// 포인트 적립 및 상으로 튕겨져 나가기
										changeDir('U', curDir, pnt);
										break;
									}
									break;

								case 3:
									// 진입방향
									switch (curDir.state) {
									// 우방향으로 진입했으면
									case 'R':
										// 포인트 적립 및 하로 튕겨져 나가기
										changeDir('D', curDir, pnt);
										break;
									// 좌방향으로 진입했으면
									case 'L':
										// 포인트 적립 및 우로 튕겨져 나가기
										changeDir('R', curDir, pnt);
										break;
									// 상방향으로 진입했으면
									case 'U':
										// 포인트 적립 및 좌로 튕겨져 나가기
										changeDir('L', curDir, pnt);
										break;
									// 하방향으로 진입했으면
									case 'D':
										// 포인트 적립 및 상으로 튕겨져 나가기
										changeDir('U', curDir, pnt);
										break;
									}
									break;

								case 4:
									// 진입방향
									switch (curDir.state) {
									// 우방향으로 진입했으면
									case 'R':
										// 포인트 적립 및 상으로 튕겨져 나가기
										changeDir('U', curDir, pnt);
										break;
									// 좌방향으로 진입했으면
									case 'L':
										// 포인트 적립 및 우로 튕겨져 나가기
										changeDir('R', curDir, pnt);
										break;
									// 상방향으로 진입했으면
									case 'U':
										// 포인트 적립 및 하로 튕겨져 나가기
										changeDir('D', curDir, pnt);
										break;
									// 하방향으로 진입했으면
									case 'D':
										// 포인트 적립 및 좌로 튕겨져 나가기
										changeDir('L', curDir, pnt);
										break;
									}
									break;

								case 5:
									// 진입방향
									switch (curDir.state) {
									// 우방향으로 진입했으면
									case 'R':
										// 포인트 적립 및 좌로 튕겨져 나가기
										changeDir('L', curDir, pnt);
										break;
									// 좌방향으로 진입했으면
									case 'L':
										// 포인트 적립 및 우로 튕겨져 나가기
										changeDir('R', curDir, pnt);
										break;
									// 상방향으로 진입했으면
									case 'U':
										// 포인트 적립 및 하로 튕겨져 나가기
										changeDir('D', curDir, pnt);
										break;
									// 하방향으로 진입했으면
									case 'D':
										// 포인트 적립 및 상으로 튕겨져 나가기
										changeDir('U', curDir, pnt);
										break;
									}
									break;
								// 블랙홀
								case -1:
									break game;

								// 패딩
								case -9:
									// 진입방향
									switch (curDir.state) {
									// 우방향으로 진입했으면
									case 'R':
										// 포인트 적립 및 좌로 튕겨져 나가기
										changeDir('L', curDir, pnt);
										break;
									// 좌방향으로 진입했으면
									case 'L':
										// 포인트 적립 및 우로 튕겨져 나가기
										changeDir('R', curDir, pnt);
										break;
									// 상방향으로 진입했으면
									case 'U':
										// 포인트 적립 및 하로 튕겨져 나가기
										changeDir('D', curDir, pnt);
										break;
									// 하방향으로 진입했으면
									case 'D':
										// 포인트 적립 및 상으로 튕겨져 나가기
										changeDir('U', curDir, pnt);
										break;
									}
									break;

								// 웜홀
								case 6:
								case 7:
								case 8:
								case 9:
								case 10:
									List<coor> candi = wHole[board[curr.row][curr.col]];
									int curR = curr.row;
									int curC = curr.col;
									for (int i = 0; i < 2; i++) {
										int candiR = candi.get(i).row;
										int candiC = candi.get(i).col;
										if (candiR != curR || candiC != curC) {
											curr.row = candi.get(i).row;
											curr.col = candi.get(i).col;
										}
										// direction은 유지
									}
									break;
								}
							} while (!(row == curr.row && col == curr.col));
							maxPnt = Math.max(maxPnt, pnt[0]);
						}
					}
				}
			}

			// 출력
			bw.write("#" + tc + " " + maxPnt + "\n");
			bw.flush();
		}

	}

	public static void changeDir(char dir, dir curDir, int[] pnt) {
		switch (dir) {
		case 'R':
			// 포인트 적립 및 좌로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'R';
			curDir.dr = 0;
			curDir.dc = 1;
			return;
		case 'U':
			// 포인트 적립 및 상으로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'U';
			curDir.dr = -1;
			curDir.dc = 0;
			return;
		case 'L':
			// 포인트 적립 및 좌로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'L';
			curDir.dr = 0;
			curDir.dc = -1;
			return;
		case 'D':
			// 포인트 적립 및 좌로 튕겨져 나가기
			pnt[0]++;
			curDir.state = 'D';
			curDir.dr = 1;
			curDir.dc = 0;
			return;
		}
	}
}
//End