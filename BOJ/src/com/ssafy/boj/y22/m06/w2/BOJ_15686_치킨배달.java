package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_15686_치킨배달 {
	public static StringBuilder sb;

	public static class coor {
		public int r;
		public int c;

		public coor(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "coor [r=" + r + ", c=" + c + "]";
		}
	}

	public static int N;
	public static int M;
	public static int minVal;
	public static coor[] sel;
	public static int[][] board;
	public static List<coor> homeList;
	public static List<coor> chickList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		board = new int[N][N];
		homeList = new ArrayList<>();
		chickList = new ArrayList<>();

		// 최솟값 초기화
		minVal = Integer.MAX_VALUE;

		// 입력받기
		for (int r = 0; r < N; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
				if (board[r][c] == 2) {
					chickList.add(new coor(r, c));
				} else if (board[r][c] == 1) {
					homeList.add(new coor(r, c));
				}
			}
		} // 입력받기 완료

		sel = new coor[M];
		comb(0, 0);
		System.out.println(minVal);
	}

	public static void comb(int idx, int sidx) {
		if (sidx == M) {
			// 치킨집 M개 조합 완료

			// 치킨거리 계산해서 최소이면 최솟값 갱신
			minVal = Math.min(minVal, chickDist());

			return;
		}

		for (int i = idx; i <= chickList.size() - M + sidx; i++) {
			sel[sidx] = chickList.get(i);
			comb(i + 1, sidx + 1);
		}
	}

	public static int chickDist() {
		int distSum = 0;
		// * 입력받을때 집 List도 만들어 놓으면
		// * 여기를 2중 for문이 아닌 단일 for문으로 만들 수 있다.
		// 각 집에 대해
		for (coor home : homeList) {
			// 치킨집중 가장 가까운 놈까지의 거리를 찾아라.
			int close = Integer.MAX_VALUE;
			for (int i = 0; i < M; i++) {
				close = Math.min(close,
						Math.abs(home.r - sel[i].r) + Math.abs(home.c - sel[i].c));
			}
			// 그 거리를 sum에 더하자
			distSum += close;
		}
		return distSum;
	}

}
//End