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
import java.util.StringTokenizer;

public class BOJ_1525_퍼즐 {

	public static StringBuilder sb;

	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static class coor {
		public int r;
		public int c;
		public boolean[][] check;
		public int[][] board;

		public coor(int r, int c, boolean[][] check, int[][] board) {
			this.r = r;
			this.c = c;
			this.check = check;
			this.board = board;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		int[][] board = new int[3][3];
		int[] start = new int[2];
		for (int r = 0; r < 3; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if (board[r][c] == 0) {
					start[0] = r;
					start[1] = c;
				}
			}
		}
		boolean[][] check = new boolean[3][3];
		coor st = new coor(start[0], start[1], check, board);
		// BFS
		System.out.println(BFS(st));;

	}

//
	public static int BFS(coor st) {
		Queue<coor> Q = new LinkedList<>();
		int mov = 0;

		Q.add(st);
		st.check[st.r][st.c] = true;

		while (!Q.isEmpty()) {
			int Qsize = Q.size();
			for (int c = 0; c < Qsize; c++) {
				coor curr = Q.poll();
				if (verify(curr.board)) {
					return mov;
				}

				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					if (BC(nr, nc) && !curr.check[nr][nc]) {
						Q.add(new coor(nr, nc, copyNupdateCheck(curr.check, nr, nc),
								copyNchangeBoard(curr.board, curr.r, curr.c, nr, nc)));
					}
				}
			}
			mov++;
		}
		return -1;
	}

//

	public static boolean verify(int[][] board) {
		boolean flag = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 2 && j == 2) {
					if (board[i][j] != 0) {
						flag = false;
					}
				} else {
					if (board[i][j] != j + 1 + 3 * i) {
						flag = false;
					}
				}

			}
		}
		return flag;
	}

	public static boolean[][] copyNupdateCheck(boolean[][] check, int nr, int nc) {
		boolean[][] newC = new boolean[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				newC[i][j] = check[i][j];
			}
		}
		newC[nr][nc] = true;
		return newC;
	}

	public static int[][] copyNchangeBoard(int[][] Board, int r, int c, int nr, int nc) {
		int[][] newB = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				newB[i][j] = Board[i][j];
			}
		}
		int tmp = newB[nr][nc];
		newB[nr][nc] = newB[r][c];
		newB[r][c] = tmp;
		return newB;
	}

	public static boolean BC(int r, int c) {
		if (r >= 0 && r < 3 && c >= 0 && c < 3) {
			return true;
		} else {
			return false;
		}
	}

}
//End