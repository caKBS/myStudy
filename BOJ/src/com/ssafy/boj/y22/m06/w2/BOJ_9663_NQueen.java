package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_9663_NQueen {

	public static int N;
	public static int cnt;
	public static StringBuilder sb;
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		cnt = 0;
		N = Integer.parseInt(br.readLine());

		boolean[][] check = new boolean[N][N];
		board = new int[N][N];

		// 첫 row,col은 첫 시행에서 Queen을 놓지 않음을 표시하기 위해 -1,-1
		dfs(-1, -1, check, 0);

		System.out.println(cnt);

	}

	// row, col : 현재 Queen의 위치, check : 이전 후보군, dept : 놓은 Queen 개수
	public static void dfs(int row, int col, boolean[][] check, int dept) {
		if(dept == N) {
			cnt++;
			return;
		}
		
		// 놓을 수 있는 후보군 만들기
		// 이전 후보군 계승
		boolean[][] tmp = copy(check);
		// 처음 진입했을때는 작동 안하게
		if (row != -1) {
			// 현재 퀸 위치와 같은 행, 열, 대각선, 현재 퀸 이전
			// 을 모두 true 표시하여 못하게 함.
			paint(tmp, row, col);
		}
		
		// 다음 둘 곳 정하기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 놓을 수 있는 곳 발견
				if (!tmp[r][c]) {
					// 다음 시행에서 본인 포함 이전 전부 true처리 할거라 필요없다.
//					tmp[r][c] = true;
					// 다음 퀸 놓을 위치 결정, 후보군 승계
					dfs(r, c, tmp, dept + 1);
//					tmp[r][c] = false;
				}
			}
		}
	}

	public static boolean[][] copy(boolean[][] from) {
		boolean[][] to = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				to[r][c] = from[r][c];
			}
		}
		return to;
	}

	public static void paint(boolean[][] tmp, int row, int col) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 현재 퀸 위치와 같은 행, 열, 대각선, 현재 퀸 이전
				// 을 접근 불가 처리 함.
				if ((r == row) || (c == col) || (100 * r + c <= 100 * row + col) || (r + c == row + col)
						|| Math.abs(r - row) == Math.abs(c - col)) {
					tmp[r][c] = true;
				}
			}
		}
	}

}
//End