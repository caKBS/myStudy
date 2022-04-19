package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_2567_색종이2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[][] board = new boolean[102][102];
		
		// N장에 대해 색칠놀이
		for (int nIdx = 1; nIdx <= N; nIdx++) {
			String inNum = br.readLine();
			String[] Arr = inNum.split(" ");

			int col = Integer.parseInt(Arr[0]);
			int row = Integer.parseInt(Arr[1]);

			// 색종이 범위에 색칠
			// 첫값 미포함, 마지막 값 포함(idx0을 비워둘려고,boundary때문에)
			for (int r = row+1; r <= row + 10; r++) {
				for (int c = col+1; c <= col + 10; c++) {
					board[r][c] = true;
				}
			}
		}
		int[] dr = { 0,  -1,  0, 1};
		int[] dc = { 1, 0,  -1,  0 };
		int cnt = 0;
		boolean [][] bound = new boolean[102][102];
		// 주변에 흰색이 있는 검은색원소는 둘레를 구성하는 성분이다.
		// idx0와 idx99가 사용하는 가장 바깥
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				// 해당 원소가 검은색
				if (board[r][c] == true) {
					// 검은색이고 boundary이면 무조건 둘레 구성 성분.
						// 주변 스캔
						for (int d = 0; d <= 3; d++) {
							// 해당 원소 주변에 흰색이 있으면 이 원소는
							// 둘레를 구성하는 성분이다.
							// 주변 흰색의 개수만큼 둘레에 일조한다.
							// -> 주변 흰색이 2개인 곳은 각인 곳이고 이곳은
							// 두 변에 대해 둘레에 일조한다.
							if (board[r + dr[d]][c + dc[d]] == false) {
								cnt++;
								bound[r][c]=true;
							}
					}
				}
			}
		}
//		System.out.println("---------board-------------");
//		for (int r = 0; r <= 100; r++) {
//			for (int c = 0; c <= 100; c++) {
//				if (board[r][c] == true) {
//					System.out.print(1 + " ");
//				} else {
//					System.out.print(0 + " ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("---------bound-------------");
//		for (int r = 0; r <= 100; r++) {
//			for (int c = 0; c <= 100; c++) {
//				if (bound[r][c] == true) {
//					System.out.print(1 + " ");
//				} else {
//					System.out.print(0 + " ");
//				}
//			}
//			System.out.println();
//		}

		// 출력
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}
// End
