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

public class BOJ_2638_치즈 {

	public static StringBuilder sb;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int R;
	public static int C;
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		// 구조
		// 치즈 외부 한점에서 DFS를 하면 모든 치즈 외부 칸을 스캔할 수 있다.
		// 치즈 외부 칸을 스캔하면서 치즈 외부칸과 닿아 있는 애들의 mark배열에 +1한다.
		// 그리고 mark가 2이상인 애들을 제거한다.
		// 이방식으로 하면 치즈가 녹아 구멍속으로 공기가 들어가는 것이
		// 자연스럽게 해결된다.
		// 가장자리는 무조건 치즈가 없으므로 원점에서 시작하자.

		// 입력받기
		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);

		board = new int[R][C];
		// 보드 위에 치즈 개수
		int left = 0;
		for (int r = 0; r < R; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < C; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
				if (board[r][c] == 1) {
					left++;
				}
			}
		}

		int hour = 0;

		// 본인(치즈)이 접촉한 공기칸의 개수를 알려줌.
		int[][] mark = new int[R][C];

		// 모두 녹기 한시간전 치즈칸수를 물어보는 것 보니
		// 치즈가 아이에 없는 입력은 주어지지 않는 것 같지만
		// 혹시 모르니 처음부터 없는 경우를 처리하기 위해
		// "left > 0"를 도입.
		while (true && left > 0) {
			hour++;

			// 한번에 녹이기 위해 DFS때는 녹일 위치를 표시만 하고
			// DFS 끝나고 한번에 녹인다.
			boolean[][] check = new boolean[R][C];
			DFS(0, 0, check, mark);
			// 제거 후 남은 치즈 개수가 들어간다.
			left = delete(mark);
			
		}

		// 출력
		System.out.println(hour);
	}

	public static int delete(int[][] mark) {
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (mark[r][c]>=2) {
					board[r][c] = 0;
					// 제거 후 남은 치즈 개수
				} else if (board[r][c] == 1) {
					cnt++;
				}
				// 재활용을 위해 사용 흔적 지워주기
				mark[r][c] = 0;
			}
		}
		return cnt;
	}

	// 여기는 DFS 방문체크를 되돌아올때 지우면 안됨.
	public static void DFS(int r, int c, boolean[][] check, int[][] mark) {
		check[r][c] = true;

		// 주변에 녹일 치즈 표시하기
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (BC(nr, nc) && board[nr][nc] == 1) {
				mark[nr][nc]++;
			}
		}

		// 주변의 빈공간에 진입
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (BC(nr, nc) && !check[nr][nc] && board[nr][nc] == 0) {
				DFS(nr, nc, check, mark);
			}

		}

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