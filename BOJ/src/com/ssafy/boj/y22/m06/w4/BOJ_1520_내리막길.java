package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1520_내리막길 {

	public static StringBuilder sb;
	public static int M;
	public static int N;
	public static int[][] board;
	public static int cnt;

	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		String[] MN = br.readLine().split(" ");
		M = Integer.parseInt(MN[0]);
		N = Integer.parseInt(MN[1]);

		board = new int[M][N];
		for (int r = 0; r < M; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
			}
		} // 입력받기 끝

		// 결과 초기화
		cnt = 0;
		boolean[][] check = new boolean[M][N];
		// 게임시작
		DFS(0, 0, check);
		// 출력
		System.out.println(cnt);

	}

	public static void DFS(int r, int c, boolean[][] check) {
		check[r][c] = true;
		// 제일 오른쪽 아래점 찾음.
		if (r == M - 1 && c == N - 1) {
			cnt++;
		} else {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (BC(nr, nc) && !check[nr][nc] && board[nr][nc] < board[r][c]) {
					DFS(nr, nc, check);
				}
			}
		}
		check[r][c] = false;
	}

	public static boolean BC(int r, int c) {
		if (r >= 0 && r < M && c >= 0 && c < N) {
			return true;
		} else {
			return false;
		}
	}

}
//End