package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569_토마토 {
	public static class coor {
		public int h;
		public int r;
		public int c;

		public coor(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

	public static StringBuilder sb;
	//
	public static int[] dh = { -1, 1, 0, 0, 0, 0 };
	public static int[] dr = { 0, 0, -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, 0, 0, -1, 1 };
	public static int N;
	public static int M;
	public static int H;
	public static int maxCnt;
	public static int[][][] board;
	public static Queue<coor> Q;
	public static boolean[][][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		String[] MNH = br.readLine().split(" ");
		M = Integer.parseInt(MNH[0]);
		N = Integer.parseInt(MNH[1]);
		H = Integer.parseInt(MNH[2]);

		board = new int[H][N][M];
		Q = new LinkedList<>();
		check = new boolean[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				String[] aline = br.readLine().split(" ");
				for (int c = 0; c < M; c++) {
					board[h][r][c] = Integer.parseInt(aline[c]);
					if (board[h][r][c] == 1) {
						Q.add(new coor(h, r, c));
						check[h][r][c] = true;
					}
				}
			}
		} // 입력 받기 완료

		int day = -1;
		while (!Q.isEmpty()) {
			// 날이 밝았습니다.
			day++;
			// 현재 Queue에 있는 익토가 다 소진될때 까지 돌리자
			int today_work = Q.size();
			for (int w = 0; w < today_work; w++) {
				coor curr = Q.poll();
				// 감염됨
				board[curr.h][curr.r][curr.c] = 1;
				// 자, 주변 감염시키자
				for (int i = 0; i < 6; i++) {
					int nh = curr.h + dh[i];
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					if (BC(nh, nr, nc) && !check[nh][nr][nc] && board[nh][nr][nc] == 0) {
						Q.add(new coor(nh, nr, nc));
						check[nh][nr][nc] = true;
					}
				}
			}
		}

		// 출력
		// 잔여 미숙 토마토 검사
		if (!test()) {
			System.out.println("-1");
		} else {
			System.out.println(day);
		}

	}

	public static boolean test() {
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 미숙 토마토가 발견되면 바로 false를 리턴
					if (board[h][r][c] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean BC(int h, int r, int c) {
		if (h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		} else {
			return false;
		}
	}

}
//End