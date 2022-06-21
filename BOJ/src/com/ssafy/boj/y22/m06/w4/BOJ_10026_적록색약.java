package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
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
	public static char[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		N = Integer.parseInt(br.readLine());
		board = new char [N][N];
		for(int r=0; r<N; r++) {
			char [] aline = br.readLine().toCharArray();
			for(int c=0; c<N;c++) {
				board[r][c] = aline[c];
			}
		}
		
		// 일반인
		boolean [][] check = new boolean [N][N];
		int normalCnt= 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N;c++) {
				if(!check[r][c]) {
					normalCnt++;
					normal(r,c,check);
				}
			}
		}
		
		// 적록색약
		check = new boolean [N][N];
		int disCnt= 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N;c++) {
				if(!check[r][c]) {
					disCnt++;
					disorder(r,c,check);
				}
			}
		}

		// 출력
		System.out.println(normalCnt+" "+disCnt);
		
	}
	
	public static void disorder(int str, int stc, boolean [][] check) {
		Queue<coor> Q = new LinkedList<>();
		Q.add(new coor(str,stc));
		check[str][stc] = true;
		
		while(!Q.isEmpty()) {
			coor curr = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				// 진입조건
				if( BC(nr,nc) && !check[nr][nc] 
						// 이전 이후 모두 Blue이거나
						// 이전 이후 모두 Blue가 아니거나
						&& ( (board[curr.r][curr.c] == 'B' && board[nr][nc] == 'B' ) 
								|| (board[curr.r][curr.c] != 'B' && board[nr][nc] != 'B' ))) {
					Q.add(new coor(nr, nc));
					check[nr][nc] = true;
				}
			}
		}
	}
	
	public static void normal(int str, int stc, boolean [][] check) {
		Queue<coor> Q = new LinkedList<>();
		Q.add(new coor(str,stc));
		check[str][stc] = true;
		
		while(!Q.isEmpty()) {
			coor curr = Q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if( BC(nr,nc) && !check[nr][nc] &&board[nr][nc] == board[curr.r][curr.c]) {
					Q.add(new coor(nr, nc));
					check[nr][nc] = true;
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