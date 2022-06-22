package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7562_나이트의이동 {
	public static class coor {
		public int r;
		public int c;
		public int depth;

		public coor(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

	}

	public static StringBuilder sb;
	// 우,상,좌,하
	public static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[] dc = { 2, 1, -1, -2, -2, -1, 1, 2 };
	public static int I;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			I = Integer.parseInt(br.readLine());
			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");

			coor st = new coor(Integer.parseInt(start[0]), Integer.parseInt(start[1]),0);
			coor ed = new coor(Integer.parseInt(end[0]), Integer.parseInt(end[1]),-1);
			
			System.out.println(BFS(st,ed));
		}

	}
	
	public static int BFS(coor st, coor ed) {
		Queue<coor> Q = new LinkedList<>();
		boolean [][] check = new boolean[I][I];
		Q.add(st);
		check[st.r][st.c]=true;
		
		while(!Q.isEmpty()) {
			coor curr= Q.poll();
			if(curr.r == ed.r && curr.c == ed.c) {
				return curr.depth;
			}
			for(int i=0; i<8;i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				int nd = curr.depth+1;
				if(BC(nr,nc) && !check[nr][nc]) {
					Q.add(new coor(nr,nc,nd));
					check[nr][nc] = true;
				}
			}
		}
		
		// Not Found
		return -1;
	}
	
	public static boolean BC(int r, int c) {
		if(r>=0 && r<I && c>=0 && c<I) {
			return true;
		}else {
			return false;
		}
	}

}
//End