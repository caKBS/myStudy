package com.ssafy.boj.y22.m06.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4963_섬의개수 {
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
	public static int [] dr = { 0,-1,-1,-1,0,1,1,1 };
	public static int [] dc = { 1,1,0,-1,-1,-1,0,1 };
	public static int w;
	public static int h;
	public static int [][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		
		while(true) {
			// 입력받기
			String [] wh = br.readLine().split(" ");
			w = Integer.parseInt(wh[0]);
			h = Integer.parseInt(wh[1]);
			
			// 탈출 조건
			if(w==0 && h==0) {
				break;
			} // 탈출 조건 완료
			
			board = new int [h][w];
			for(int r=0; r<h; r++) {
				String[] aline = br.readLine().split(" ");
				for(int c=0; c<w;c++) {
					board[r][c] = Integer.parseInt(aline[c]);
				}
			} // 입력 받기 완료
			
			// 섬의 개수
			int cnt=0;
			// 출발점
			for(int r=0; r<h; r++) {
				for(int c=0; c<w;c++) {
					if(board[r][c]==1) {
						cnt++;
						DFS(r,c);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void DFS(int r, int c) {
		board[r][c] = 2;
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(BC(nr,nc) && board[nr][nc] == 1) {
				DFS(nr,nc);
			}
		}
	}
	
	public static boolean BC(int r, int c) {
		if(r>=0 && r<h && c>=0 && c<w) {
			return true;
		}else {
			return false;
		}
	}

}
//End