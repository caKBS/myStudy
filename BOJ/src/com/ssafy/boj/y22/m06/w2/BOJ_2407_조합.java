package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ_2407_조합 {
	public static int N;
	public static int K;

	// DP방식 사용
	// M개 중에서 N개를 선택하는 조합
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		K = Integer.parseInt(NM[1]);

		// 조합 결과를 저장하는 배열
		BigInteger[][] NR = new BigInteger[110][110];

		// nCr = nC(n-r)
		if (K > N / 2) {
			K = N - K;
		}

		// DP
		for (int r = 0; r <= N; r++) {
			for (int c = 0; c <= r; c++) {
				if (c == 0 || r == c) {
					NR[r][c] = new BigInteger("1");
				}
				else {
					NR[r][c] = NR[r - 1][c].add(NR[r - 1][c - 1]);
					
				}
			}
		}

		System.out.println(NR[N][K]);
	}
}
//End