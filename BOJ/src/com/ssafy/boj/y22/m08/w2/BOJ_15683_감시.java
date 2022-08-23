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
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	public static StringBuilder sb;

	// 북, 동, 남,서
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static int N;
	public static int M;
	public static int minCnt;
	public static int [][] board;
	public static int [] rotArr;
	public static List<coor> cctvList;


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
		String [] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new int [N][M];
		cctvList = new ArrayList<>();
		for(int r=0;r<N;r++) {
			String [] aline = br.readLine().split(" ");
			for(int c=0;c<M;c++) {
				board[r][c] = Integer.parseInt(aline[c]);
				if(board[r][c]>=1 && board[r][c]<=5) {
					cctvList.add(new coor(r,c));
				}
			}
		}
		
		minCnt = Integer.MAX_VALUE;
		rotArr = new int[cctvList.size()];
		makeRotArr(0);
		System.out.println(minCnt);
	}
	
	public static void makeRotArr(int sidx) {
		if(sidx == cctvList.size()) {
			int [][] test = deepCpy(board);
			for(int i=0; i<cctvList.size();i++) {
				coor curr = cctvList.get(i);
				spread(test,curr.r,curr.c,rotArr[i]);
			}
			minCnt = Math.min(minCnt, cnt(test));
			
			return;
		}
		
		for(int rot=0; rot<4; rot++) {
			rotArr[sidx] = rot;
			makeRotArr(sidx+1);
		}
		
	}
	
	// cctv 종류에 따른 분기
	public static void spread(int [][] test, int r, int c, int rot) {
		// cctv의 종류
		switch (test[r][c]) {
		case 1 : 
			// 동쪽을 기준으로 rot만큼 회전
			draw(test,r,c,1,rot);
			break;
		case 2 :
			// 동쪽을 기준으로 rot만큼 회전
			draw(test,r,c,1,rot);
			// 서쪽을 기준으로 rot만큼 회전
			draw(test,r,c,3,rot);
			break;
		case 3 :
			// 북쪽을 기준으로 rot만큼 회전
			draw(test,r,c,0,rot);
			// 동쪽을 기준으로 rot만큼 회전
			draw(test,r,c,1,rot);
			break;
		case 4 :
			// 북쪽을 기준으로 rot만큼 회전
			draw(test,r,c,0,rot);
			// 동쪽을 기준으로 rot만큼 회전
			draw(test,r,c,1,rot);
			// 서쪽을 기준으로 rot만큼 회전
			draw(test,r,c,3,rot);
			break;
		case 5 :
			// 모든 방향에 대해 draw
			for(int dir=0; dir<4;dir++) {
				draw(test,r,c,dir,0);
			}
			break;
		}
		
	}
	
	// cctv 감시 가능 영역 표시 메서드
	// dir은 기준 방향
	public static void draw(int [][] test, int r, int c, int dir, int rot) {
		int dirIdx = (dir+rot)%4;
		// 퍼지기 시작
		while(true) {
			r = r+dr[dirIdx];
			c = c+dc[dirIdx];
			// 범위를 넘어가거나 벽을 만나면 종료
			if(!BC(r,c) || test[r][c] == 6) {
				break;
			}
			// 0인 부분을 감시할수있는영역(-1)로 표시하기
			if(test[r][c] == 0) {
				test[r][c] = -1;
			}
		}
	}
	
	public static int cnt(int [][] test) {
		int cnt = 0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(test[r][c] ==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static int [][] deepCpy(int [][] orig) {
		int [][] tmp = new int[N][M];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				tmp[r][c] = orig[r][c];
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