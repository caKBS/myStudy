package com.ssafy.boj.y22.m08.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503_벽부수고이동하기 {

	public static StringBuilder sb;
	// 북, 동, 남,서
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static int N;
	public static int M;
	public static int R = 0;
	public static int C = 1;

	public static int[][] board;
	public static boolean[][] check;
	public static coor robot;
	public static int d;

	public static class coor {
		public int r;
		public int c;

		public coor(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		robot = new coor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		d = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		check = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력받기 끝

		int cnt = 0;
		boolean flag = false;
		while (true) {
			// 갈곳없어서 후진으로 이동한 경우는
			// cnt 반영안한다.
			if (!check[robot.r][robot.c]) {
				check[robot.r][robot.c] = true;
				cnt++;
			}

			flag = false;
			for (int i = 0; i < 4; i++) {
				int nd = (d + 3) % 4;
				int nr = robot.r + dr[nd];
				int nc = robot.c + dc[nd];
				if (BC(nr, nc) && !check[nr][nc] && board[nr][nc] == 0) {
					d = nd;
					robot.r = nr;
					robot.c = nc;
					flag = true;
					break;
				} else {
					d = nd;
				}
			}
			int BR = robot.r + dr[(d + 2) % 4];
			int BC = robot.c + dc[(d + 2) % 4];
			if (!flag && BC(BR, BC) && board[BR][BC] == 0) {
				robot.r = BR;
				robot.c = BC;
			} else if (!flag && BC(BR, BC) && board[BR][BC] == 1) {
				break;
			}
		}

		System.out.println(cnt);

	}

	public static boolean BC(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		} else {
			return false;
		}
	}

}
//End