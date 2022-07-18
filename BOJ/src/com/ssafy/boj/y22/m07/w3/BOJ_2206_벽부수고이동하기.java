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

public class BOJ_2206_벽부수고이동하기 {

	public static StringBuilder sb;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int R;
	public static int C;
	public static int minRoad;
	public static int[][] board;
	
	public static class coor{
		public int r;
		public int c;
		public int road;
		public int left;
		
		
		public coor(int r, int c, int road, int left) {
			this.r = r;
			this.c = c;
			this.road = road;
			this.left = left;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 입력받기
		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		
		// 결과 초기화
		minRoad = -1;

		board = new int[R][C];
		for (int r = 0; r < R; r++) {
			char[] aline = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				board[r][c] = aline[c]-'0';
			}
		}
		
		//BFS 
		Queue<coor> Q = new LinkedList<>();
		// [0] : 부쉈을때, [1] : 부수지 않았을때
		boolean [][][] check = new boolean[R][C][2];
		Q.add(new coor(0,0,1,1));
		check[0][0][1] = true; // 부수지 않았을때
		
		while(!Q.isEmpty()) {
			coor curr = Q.poll();
			
			// 시작점에서 거리가 가까운 것부터 스캔함이 보장되므로
			// 먼저 목표점에 만난 coor객체가 무조건 거리최소이다.
			// 그리고 어차피 check처리해서 목표점에는
			// 무조건 한번 만난다.
			if(curr.r == R-1 && curr.c == C-1) {
				minRoad = curr.road;
				break;
			}
			
			
			for(int i=0; i<4; i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				if(!BC(nr,nc) || check[nr][nc][curr.left]) {
					continue;
				}
				
				if(board[nr][nc]==0){
					Q.add(new coor(nr,nc,curr.road+1,curr.left));
					check[nr][nc][curr.left] = true;
				}else if(board[nr][nc]==1 && curr.left==1) {
					Q.add(new coor(nr,nc,curr.road+1,curr.left-1));
					check[nr][nc][curr.left-1] = true;
				}
				
			}
		}
		
		System.out.println(minRoad);
		

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