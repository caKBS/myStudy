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

public class BOJ_16234_인구이동_시간초과 {

	public static StringBuilder sb;

	// 북, 동, 남,서
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static int[][] board;
	public static int N;
	public static int R;
	public static int L;

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
		String[] aline = br.readLine().split(" ");
		N = Integer.parseInt(aline[0]);
		L = Integer.parseInt(aline[1]);
		R = Integer.parseInt(aline[2]);

		board = new int[N][N];
		for (int r = 0; r < N; r++) {
			aline = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
			}
		}

		boolean flag = true;
		int day=0;
		while (flag) {
			day++;
			flag = false;
			int[][] newboard = new int[N][N];
			boolean[][] newCheck = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 한번 union한 집단의 구성원이 다시 선택되도
					// 집단 외는 무조건 차이가 [L,R] 범위 외이고
					// 집단 내는 무조건 차이가 0인데
					// L은 항상 0보다 크므로
					// 혼자만 union형성한다.
					// 그래서 따로 방문처리 안해줘도 된다.
					// 여기선 속도를 높여주기 위해서 방문처리 해준다.
					if (!newCheck[r][c] && BFS(r, c, newboard, newCheck)) {
						flag = true;
					}
					;
				}
			}
			board = newboard;
		}
		day--;
		System.out.println(day);

	}

	// 하나짜리 연합도 BFS진입한다.
	// 고로 하나짜리도 따로 처리없이 다수연합일때와 같은 로직으로 처리가능.
	public static boolean BFS(int str, int stc, int[][] newboard, boolean[][] newCheck) {
		boolean flag = false;
		boolean[][] check = new boolean[N][N];
		Queue<coor> Q = new LinkedList<>();
		int sum = 0;
		int cnt = 0;
		Q.add(new coor(str, stc));
		check[str][stc] = true;
		newCheck[str][stc] = true;
		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			sum += board[curr.r][curr.c];
			cnt += 1;
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if (BC(nr, nc) && !check[nr][nc] && Math.abs(board[curr.r][curr.c] - board[nr][nc]) >= L
						&& Math.abs(board[curr.r][curr.c] - board[nr][nc]) <= R) {
					flag = true;
					Q.add(new coor(nr, nc));
					check[nr][nc] = true;
					newCheck[nr][nc] = true;
				}
			}
		} // BFS 끝
			// 연합 평균
		int avg = sum / cnt;

		// 연합(BFS로 지나갔던 국가)에 대해 새로운 값 부여.
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (check[r][c]) {
					newboard[r][c] = avg;
				}
			}
		}
		return flag;
	}

	public static boolean BC(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N) {
			return true;
		} else {
			return false;
		}
	}

}
//End