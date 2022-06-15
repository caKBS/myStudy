package com.ssafy.boj.y22.m06.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178_미로탐색 {
	public static class coor {
		public int r;
		public int c;
		public int d;

		public coor(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	public static StringBuilder sb;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int N;
	public static int M;
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new int[N][M];
		for (int r = 0; r < N; r++) {
			char[] aline = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				board[r][c] = aline[c] - '0';
			}
		} // 입력받기 완료

		System.out.println(BFS(new coor(0, 0, 1), new coor(N - 1, M - 1, -1)));

	}

	public static int BFS(coor st, coor ed) {
		boolean[][] check = new boolean[N][M];
		Queue<coor> Q = new LinkedList<>();
		Q.add(st);
		check[st.r][st.c] = true;

		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			// 종료조건_ed위치를 만나면 종료
			if (curr.r == ed.r && curr.c == ed.c) {
				return curr.d;
			}
			//

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				int nd = curr.d + 1;
				// BFS의 탐색 조건 : 
				// 1. Boundary 안에 있고
				// 2. 이전에 방문하지 않았고
				// 3. 접근 가능한 좌표일때
				if (BC(nr,nc) && !check[nr][nc] && board[nr][nc] == 1) {
					Q.add(new coor(nr, nc, nd));
					check[nr][nc] = true;
				}
			}
		}

		// ed위치를 못 만났을때
		return -1;

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