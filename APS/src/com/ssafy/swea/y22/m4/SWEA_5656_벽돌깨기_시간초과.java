package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SWEA_5656_벽돌깨기_시간초과 {
	public static int[][] board;
	public static int[][] boardBU;
	public static int N;
	public static int W;
	public static int H;
	public static int[] select;
	public static int minLeftOver;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			// 정답 초기화
			minLeftOver=Integer.MAX_VALUE;
			
			String[] NWH = br.readLine().split(" ");
			N = Integer.parseInt(NWH[0]);
			W = Integer.parseInt(NWH[1]);
			H = Integer.parseInt(NWH[2]);

			// 크기1짜리 패딩
			board = new int[H + 2][W + 2];
			// 백업 배열
			boardBU = new int[H + 2][W + 2];
			for (int row = 0; row < H + 2; row++) {
				for (int col = 0; col < W + 2; col++) {
					if (row == H + 1 || row == 0 || col == W + 1 || col == 0) {
						board[row][col] = -1;
						boardBU[row][col] = -1;
					}
				}
			}

			// 입력받기
			for (int row = 1; row < H + 1; row++) {
				String[] bInfo = br.readLine().split(" ");
				for (int col = 0; col < W; col++) {
					board[row][col + 1] = Integer.parseInt(bInfo[col]);
					boardBU[row][col + 1] = board[row][col + 1];
				}
			}

			// 중복 순열 결과 담아둘 배열
			select = new int[N];
			// 중복순열생성 및 drop 처리
			perm(0);

			// 출력
			bw.write("#" + tc + " " + minLeftOver + "\n");
			bw.flush();
		}
	}

	// 중복순열
	public static void perm(int sidx) {
		if (sidx == N) {
			// 중복순열생성완료
			// dropAt이 board에 직접 영향을 주므로.
			// 하나 처리가 끝나면 board를 복구해줘야함.

			// 중복순열배열 하나하나에 대해 dropAt 실행
			for (int i = 0; i < N; i++) {
				dropAt(select[i]);
			}
			// drop 완료 후 남아있는 블럭 세기
			int leftOver = 0;
			for (int row = 1; row <= H; row++) {
				for (int col = 1; col <= W; col++) {
					if (board[row][col] > 0) {
						leftOver++;
					}
				}
			}

			// 최소 나머지 벽돌 개수 갱신
			minLeftOver = Math.min(minLeftOver, leftOver);

			// 손상된 board를 백업으로 복구 시킨다.
			for (int row = 0; row < H + 2; row++) {
				for (int col = 0; col < W + 2; col++) {
					board[row][col] = boardBU[row][col];
				}
			}

			return;
		}

		// 1~W의 수를 중복순열
		for (int i = 1; i <= W; i++) {
			select[sidx] = i;
			perm(sidx + 1);
		}

	}

	public static void dropAt(int stCol) {
		Queue<coor> hitQ = new LinkedList<>();
		// 체크배열, 패딩부분은 true처리
		boolean[][] check = new boolean[H + 2][H + 2];
		for (int row = 0; row < H + 2; row++) {
			for (int col = 0; col < W + 2; col++) {
				if (row == H + 1 || row == 0 || col == W + 1 || col == 0) {
					check[row][col] = true;
				}
			}
		}

		// 구슬 맞는 지점 확인, 열은 고정하고 행은 위에서 아래로
		for (int row = 1; row <= H; row++) {
			// hit
			if (board[row][stCol] > 0) {
				hitQ.add(new coor(row, stCol));
				check[row][stCol] = true;
				;
				break;
				// hit할게 없어서 아래벽에 맞음
			} else if (board[row][stCol] == -1) {
				return;
			}
		}

		// BFS 및 폭발 시작
		while (!hitQ.isEmpty()) {
			coor curr = hitQ.poll();
			// 현재의 이웃칸
			coor R = new coor(curr.row, curr.col);
			coor U = new coor(curr.row, curr.col);
			coor L = new coor(curr.row, curr.col);
			coor D = new coor(curr.row, curr.col);
			// 폭발범위 얻기
			int range = board[curr.row][curr.col] - 1;
			// 폭발범위값 얻고 폭발 처리
			board[curr.row][curr.col] = 0;
			// 폭발범위의 벽돌을 Q에 추가
			for (int i = 0; i < range; i++) {
				// 우
				R.row += dr[0];
				R.col += dc[0];
				if (R.row <= H && R.row >= 1 && R.col <= W && R.col >= 1 && !check[R.row][R.col]) {
					hitQ.add(new coor(R.row, R.col));
					check[R.row][R.col] = true;
				}
				// 상
				U.row += dr[1];
				U.col += dc[1];
				if (U.row <= H && U.row >= 1 && U.col <= W && U.col >= 1 && !check[U.row][U.col]) {
					hitQ.add(new coor(U.row, U.col));
					check[U.row][U.col] = true;
				}
				// 좌
				L.row += dr[2];
				L.col += dc[2];
				if (L.row <= H && L.row >= 1 && L.col <= W && L.col >= 1 && !check[L.row][L.col]) {
					hitQ.add(new coor(L.row, L.col));
					check[L.row][L.col] = true;
				}
				// 하
				D.row += dr[3];
				D.col += dc[3];
				if (D.row <= H && D.row >= 1 && D.col <= W && D.col >= 1 && !check[D.row][D.col]) {
					hitQ.add(new coor(D.row, D.col));
					check[D.row][D.col] = true;
				}
			}
		}

		// 빈부분 이어붙이기
		Stack<Integer> stk = new Stack<>();
		for (int col = 1; col <= W; col++) {
			// 위에서부터 블럭 모으기
			for (int row = 1; row <= H; row++) {
				if (board[row][col] > 0) {
					stk.add(board[row][col]);
					board[row][col] = 0;
				}
			}
			// 다시 밑에서부터 깔기
			for (int row = H; !stk.isEmpty() && row >= 1; row--) {
				board[row][col] = stk.pop();
			}
		}
	}

}
//End