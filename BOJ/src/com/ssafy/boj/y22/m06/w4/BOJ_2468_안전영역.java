package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2468_안전영역 {
	public static class coor {
		public int r;
		public int c;

		public coor(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static StringBuilder sb;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int N;
	public static int maxCnt;
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 결과 초기화
		maxCnt = -1;

		// 입력받기
		N = Integer.parseInt(br.readLine());
		board = new int [N][N];
		int minH = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;
		for(int r=0; r<N; r++) {
			String [] aline = br.readLine().split(" ");
			for(int c=0; c<N;c++) {
				board[r][c] = Integer.parseInt(aline[c]);
				minH = Math.min(minH, board[r][c]);
				maxH = Math.max(maxH, board[r][c]);
			}
		}
		
		// 모든 강수량 경우에 대해 안전영역 개수 확인
		// 아무지역도 물에 잠기지 않는 경우를 반영하기 위해
		// 첫 h는 minH보다 하나 작은 값이어야 한다.
		for(int h = minH-1; h <= maxH; h++) {
			int cnt = 0;
			boolean [][] check = new boolean [N][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<N;c++) {
					if(!check[r][c] && board[r][c] > h) {
						cnt++;
						BFS(r,c,h,check);
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		// 출력
		System.out.println(maxCnt);
		
	}
	
	public static void BFS(int str, int stc, int h, boolean [][] check) {
		Queue<coor> Q = new LinkedList<>();
		Q.add(new coor(str,stc));
		check[str][stc] = true;
		
		while(!Q.isEmpty()) {
			coor curr = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curr.r +dr[i];
				int nc = curr.c +dc[i];
				if(BC(nr,nc) && !check[nr][nc] && board[nr][nc] > h) {
					Q.add(new coor(nr,nc));
					check[nr][nc] =true;
				}
			}
		}
		
	}
	
	public static boolean BC(int r, int c) {
		if(r>=0 && r<N && c>=0 && c<N) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
//End