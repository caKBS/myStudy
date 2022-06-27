package com.ssafy.boj.y22.m06.w4;

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

public class BOJ_2583_영역구하기 {
	public static int M;
	public static int N;
	public static int K;
	public static boolean[][] board;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 원래 그림을 90도 시계방향으로 돌려서 사용.
		String[] MNK = br.readLine().split(" ");
		M = Integer.parseInt(MNK[0]);
		N = Integer.parseInt(MNK[1]);
		K = Integer.parseInt(MNK[2]);
		board = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			String[] aline = br.readLine().split(" ");
			int r1 = Integer.parseInt(aline[0]);
			int c1 = Integer.parseInt(aline[1]);
			int r2 = Integer.parseInt(aline[2]);
			int c2 = Integer.parseInt(aline[3]);
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					board[r][c] = true;
				}
			}
		}

		// 탐색
		int cnt = 0;
		List<Integer> area = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!board[r][c]) {
					int[] calcu = new int[1];
					DFS(r, c, calcu);
					cnt++;
					area.add(calcu[0]);
				}
			}
		}
		Collections.sort(area);

		// 출력
		sb.append(cnt + "\n");
		for (int i = 0; i < area.size(); i++) {
			sb.append(area.get(i) + " ");
		}
		System.out.println(sb);

	}

	public static void DFS(int r, int c, int[] calcu) {
		board[r][c] = true;
		calcu[0] += 1;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (BC(nr, nc) && !board[nr][nc]) {
				DFS(nr, nc, calcu);
			}
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