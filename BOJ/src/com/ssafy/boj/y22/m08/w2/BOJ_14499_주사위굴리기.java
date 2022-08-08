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

public class BOJ_14499_주사위굴리기 {

	public static StringBuilder sb;
	// 남동서북
	// 문제에서 주어진 수의 %4로 인덱싱
	public static int[] dr = { 1, 0, 0, -1 };
	public static int[] dc = { 0, 1, -1, 0 };
	public static int N;
	public static int M;

	public static int[][] board;
	public static int[] dice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int currR = Integer.parseInt(st.nextToken());
		int currC = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		
		board = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dice = new int[7];
		st = new StringTokenizer(br.readLine());
		// order
		for (int i = 0; i < K; i++) {
			
			int d = Integer.parseInt(st.nextToken());
			int nr = currR+dr[d%4];
			int nc = currC+dc[d%4];
			if(BC(nr,nc)) {
				currR = nr;
				currC = nc;
				gamble(d);
				if(board[currR][currC] ==0) {
					board[currR][currC] = dice[6];
				}else {
					dice[6] = board[currR][currC];
					board[currR][currC]=0;
				}
				sb.append(dice[1]+"\n");
			}
		}
		System.out.println(sb);

	}

	public static void gamble(int dir) {
		int tmp;
		switch (dir) {
		case 1:
			tmp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			break;
		case 2:
			tmp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:
			tmp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 4:
			tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}

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