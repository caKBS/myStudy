package com.ssafy.boj.y22.m07.w3;

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

public class BOJ_2589_보물섬 {

	public static StringBuilder sb;
	public static int R;
	public static int C;
	public static boolean[][] board;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

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

		// 입력 받기
		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);

		board = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			char[] aline = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (aline[c] == 'L') {
					board[r][c] = true;
				}
			}
		}

		// 결과값
		int maxH = -1;
		// BFS 시작점
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c]) {
					maxH = Math.max(maxH, BFS(r, c));
				}
			}
		}
		// 출력
		System.out.println(maxH);

	}

	public static int BFS(int r, int c) {
		Queue<coor> Q = new LinkedList<>();
		boolean[][] check = new boolean[R][C];
		Q.add(new coor(r, c));
		check[r][c] = true;
		int d = 0;

		while (!Q.isEmpty()) {
			int Qsize = Q.size();
			for (int q = 0; q < Qsize; q++) {
				coor curr = Q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					if (BC(nr, nc) && !check[nr][nc] && board[nr][nc] == true) {
						Q.add(new coor(nr, nc));
						check[nr][nc] = true;
					}
				}
			}
			d++;
		}
		// 마지막에 갈데가 없을때도 d++하고 끝나므로 그 반영분을 제거해줘야 한다.
		return d-1;
	}

	public static boolean BC(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		} else {
			return false;
		}
	}

}
//End