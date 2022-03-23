package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2563_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[][] board = new boolean[101][101];

		// N장에 대해 색칠놀이
		for (int nIdx = 1; nIdx <= N; nIdx++) {
			String inNum = br.readLine();
			String[] Arr = inNum.split(" ");

			int col = Integer.parseInt(Arr[0]);
			int row = Integer.parseInt(Arr[1]);

			// 색종이 범위에 색칠
			// 마지막 값은 미포함
			for (int r = row; r < row + 10; r++) {
				for (int c = col; c < col + 10; c++) {
					board[r][c] = true;
				}
			}
		}
		// 색칠된 영역 확인
		int cnt = 0;
		for (int r = 0; r <= 100; r++) {
			for (int c = 0; c <= 100; c++) {
				if (board[r][c] == true) {
					cnt++;
				}
			}
		}
		// 출력
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}
// End
