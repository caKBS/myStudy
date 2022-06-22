package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class BOJ_1987_알파벳_DFS {
	public static class coor {
		public int r;
		public int c;

		public coor(int r, int c, int d) {
			this.r = r;
			this.c = c;
		}
	}

	public static StringBuilder sb;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int R;
	public static int C;
	public static char[][] board;
	public static int maxP;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 결과 초기화
		maxP = -1;

		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		board = new char[R][C];
		for (int r = 0; r < R; r++) {
			board[r] = br.readLine().toCharArray();
		}
		
		// 경로
		Set<Character> path = new HashSet<>();

		// 칸수에 시작칸도 포함된다.
		DFS(0,0,1,path);
		
		// 출력
		System.out.println(maxP);


	}

	public static void DFS(int r, int c, int dept, Set<Character> path) {
		// 현재 진입한 위치를 진입 직후 path에 넣어준다.
		path.add(board[r][c]);
		
		// 더 이상 갈데가 있느냐
		boolean flag = false;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(BC(nr,nc) && !path.contains(board[nr][nc])) {
				flag = true;
				DFS(nr,nc,dept+1,path);
			}
		}
		
		//더이상 갈데가 없으면 최대칸수 갱신
		if(!flag) {
			maxP = Math.max(maxP, dept); 
		}
		
		path.remove(board[r][c]);
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