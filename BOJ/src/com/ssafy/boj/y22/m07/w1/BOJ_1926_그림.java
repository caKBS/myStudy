package com.ssafy.boj.y22.m07.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1926_그림 {

	public static StringBuilder sb;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int R;
	public static int C;
	public static int maxArea;
	public static int area;
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);

		board = new int[R][C];

		for (int r = 0; r < R; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
			}
		} // 입력받기 완료

		// 결과 초기화
		// 그림이 하나도 없는 경우에는 그림의 넓이는 0이다.
		maxArea = 0;

		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c] == 1) {
					cnt++;
					area = 0;
					DFS(r, c);
				}
			}
		}

		sb.append(cnt + "\n");
		sb.append(maxArea);
		System.out.print(sb);

	}

	public static void DFS(int r, int c) {
		area++;
		board[r][c] = 0;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (BC(nr, nc) && board[nr][nc] == 1) {
				DFS(nr, nc);
			}
		}

		maxArea = Math.max(maxArea, area);
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