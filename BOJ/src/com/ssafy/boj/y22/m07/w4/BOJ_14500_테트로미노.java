package com.ssafy.boj.y22.m07.w4;

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

public class BOJ_14500_테트로미노 {

	public static StringBuilder sb;
	public static boolean[][] check;
	public static int[][] board;
	public static int N;
	public static int M;
	public static int maxVal;
	// 우, 상, 좌, 하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// DFS로 하고
		// 지나온 칸의 개수를 세서 4개면 리턴 시키기.

		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 결과초기화
		maxVal = -1;
		check = new boolean[N][M];
		// 시작 위치
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				for(int d=0; d<4;d++) {
					maxVal= Math.max(maxVal, blue(r,c,d));
					maxVal= Math.max(maxVal, yellow(r,c));
					maxVal= Math.max(maxVal, orange(r,c,d));
					maxVal= Math.max(maxVal, green(r,c,d));
					maxVal= Math.max(maxVal, purple(r,c,d));
				}
			}
		}
		
		// 출력
		System.out.println(maxVal);

	}

	public static int blue(int r, int c, int dir) {
		int sum = 0;
		
		for(int i=0; i<4;i++) {
			int nr = r+dr[dir]*i;
			int nc = c+dc[dir]*i;
			if(!BC(nr,nc)) {
				return -1;
			}else {
				sum+=board[nr][nc];
			}
		}
		
		return sum;
	}
	
	public static int yellow(int r, int c) {
		int sum = 0;
		
		if( !BC(r,c) || !BC(r,c+1) || !BC(r+1,c) || !BC(r+1,c+1)) {
			return -1;
		}else {
			sum = board[r][c] + board[r][c+1] + board[r+1][c] 
					+  board[r+1][c+1];
		}
		
		return sum;
	}
	
	public static int orange(int r, int c, int dir) {
		int sumA = 0;
		int sumB = 0;
		
		for(int i=0; i<3;i++) {
			int nr = r+dr[dir]*i;
			int nc = c+dc[dir]*i;
			if(!BC(nr,nc)) {
				return -1;
			}else {
				sumA+=board[nr][nc];
				sumB+=board[nr][nc];
			}
		}
		
		int nr = r+dr[dir]*2+dr[(dir+1)%4];
		int nc = c+dc[dir]*2+dc[(dir+1)%4];
		if(!BC(nr,nc)) {
			sumA= -1;
		}else {
			sumA+=board[nr][nc];
		}
		
		nr = r+dr[dir]*2+dr[(dir+3)%4];
		nc = c+dc[dir]*2+dc[(dir+3)%4];
		if(!BC(nr,nc)) {
			sumB= -1;
		}else {
			sumB+=board[nr][nc];
		}
		
		
		
		return Math.max(sumA, sumB);
	}
	
	public static int green(int r, int c, int dir) {
		int sumA = 0;
		int sumB = 0;
		
		int nr1 = r; int nc1 = c;
		int nr2 = nr1+dr[dir]; int nc2 = nc1+dc[dir]; 
		int nr3 = nr2+dr[(dir+1)%4]; int nc3 = nc2+dc[(dir+1)%4]; 
		int nr4 = nr3+dr[dir]; int nc4 = nc3+dc[dir]; 
		
		if( !BC(nr1,nc1) || !BC(nr2,nc2) || !BC(nr3,nc3) || !BC(nr4,nc4)) {
			return -1;
		}else {
			sumA = board[nr1][nc1] + board[nr2][nc2] + board[nr3][nc3] 
					+  board[nr4][nc4];
		}
		
		nr3 = nr2+dr[(dir+3)%4]; nc3 = nc2+dc[(dir+3)%4]; 
		nr4 = nr3+dr[dir]; nc4 = nc3+dc[dir]; 

		if( !BC(nr1,nc1) || !BC(nr2,nc2) || !BC(nr3,nc3) || !BC(nr4,nc4)) {
			return -1;
		}else {
			sumB = board[nr1][nc1] + board[nr2][nc2] + board[nr3][nc3] 
					+  board[nr4][nc4];
		}
		
		
		return Math.max(sumA, sumB);
	}
	
	public static int purple(int r, int c, int dir) {
		int sum = 0;
		
		int nr1 = r; int nc1 = c;
		int nr2 = nr1+dr[dir]; int nc2 = nc1+dc[dir]; 
		int nr3 = nr2+dr[(dir+3)%4]; int nc3 = nc2+dc[(dir+3)%4]; 
		int nr4 = nr2+dr[dir]; int nc4 = nc2+dc[dir]; 
		
		if( !BC(nr1,nc1) || !BC(nr2,nc2) || !BC(nr3,nc3) || !BC(nr4,nc4)) {
			return -1;
		}else {
			sum = board[nr1][nc1] + board[nr2][nc2] + board[nr3][nc3] 
					+  board[nr4][nc4];
		}
		return sum;
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