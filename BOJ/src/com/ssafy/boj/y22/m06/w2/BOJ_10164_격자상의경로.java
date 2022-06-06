package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_10164_격자상의경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] aline = br.readLine().split(" ");
		int N = Integer.parseInt(aline[0]);
		int M = Integer.parseInt(aline[1]);
		int K = Integer.parseInt(aline[2]);

		// O표시가 된 칸 위치
		int tr = (K - 1) / M;
		int tc = (K - 1) % M;
		// target의 오른쪽과 아래쪽을 처리하는 방식이
		// 원점의 오른쪽과 아래쪽을 처리하는 방식과 동일하므로
		// target이 없는 경우
		// 원점이 target이라고 해놓음
		// 어차피 else if로 걸러지지만
		if (K == 0) {
			tr = 0;
			tc = 0;
		}

		int[][] dp = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 행이 0이거나 열이 0인애들은 모두 1
				if (r == 0 || c == 0) {
					dp[r][c] = 1;
				// target과 같은 행 혹은 열을 가지되
				// target보다 오른쪽 혹은 아래에 위치한 애들은
			    // target과 같은 값을 가진다.
				} else if ( (r == tr && c > tc) || (c == tc && r > tr) ) {
					dp[r][c] = dp[tr][tc];
				// 그외는 (위에서 오는 방법+ 좌에서 오는 방법)으로
				// 값을 결정.
				} else {
					dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
				}
			}
		}

		System.out.println(dp[N-1][M-1]);

	}
}
//End