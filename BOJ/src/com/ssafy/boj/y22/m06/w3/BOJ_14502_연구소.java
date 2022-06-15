package com.ssafy.boj.y22.m06.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_14502_연구소 {
	public static class coor {
		public int r;
		public int c;

		public coor(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "coor [r=" + r + ", c=" + c + "]";
		}
	}

	public static StringBuilder sb;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int N;
	public static int M;
	public static int maxSafe;
	public static int[][] board;
	public static coor[] select;
	public static List<coor> zero;
	public static List<coor> virus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 안전영역 최대 크기 초기화
		maxSafe = -1;

		// 입력받기
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new int[N][M];
		zero = new ArrayList<>();
		virus = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
				if (board[r][c] == 0) {
					zero.add(new coor(r, c));
				} else if (board[r][c] == 2) {
					virus.add(new coor(r, c));
				}
			}
		} // 입력받기 완료

		select = new coor[3];
		comb(0, 0);
		System.out.println(maxSafe);

	}

	// 벽을 세울 3곳 선정
	public static void comb(int idx, int sidx) {
		if (sidx == 3) { // 3곳 선정 완료

			/// 전파
			int safe = spreadNcount(copy(board));
			maxSafe = Math.max(maxSafe, safe);

			return;
		}

		for (int i = idx; i <= zero.size() - select.length + sidx; i++) {
			select[sidx] = zero.get(i);
			comb(i + 1, sidx + 1);
		}
	}

	// 전파
	public static int spreadNcount(int[][] tmp) {
		// 3곳에 벽세우기
		for (int i = 0; i < 3; i++) {
			tmp[select[i].r][select[i].c] = 1;
		}
		
		// 모든 virus에 대해 BFS
		for(coor st : virus) {
			BFS(st.r,st.c,tmp);
		}
		
		// 안전 영역 개수 세기
		return safeCnt(tmp);
	}
	
	public static void BFS(int str, int stc, int [][] tmp) {
		boolean[][] check = new boolean[N][M];
		Queue<coor> Q = new LinkedList<>();
		Q.add(new coor(str, stc));
		check[str][stc] = true;

		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			// 전염
			tmp[curr.r][curr.c]= 2;
			//
			for(int i=0;i<4;i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				// 주변 칸중에 비어있는 칸은 접근
				if(BC(nr,nc) && !check[nr][nc] && tmp[nr][nc] == 0) {
					Q.add(new coor(nr,nc));
					check[nr][nc]=true;
				}
			}
		}	
	}
	
	
	public static int safeCnt(int[][] tmp) {
		int cnt=0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(tmp[r][c] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int[][] copy(int[][] board) {
		int[][] tmp = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tmp[r][c] = board[r][c];
			}
		}
		return tmp;
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