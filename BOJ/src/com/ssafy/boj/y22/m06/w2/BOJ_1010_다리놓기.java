package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1010_다리놓기 {
	public static int [] selected;
	public static int M;
	public static int N;

	// DP방식 사용
	// M개 중에서 N개를 선택하는 조합
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			String[] NM = br.readLine().split(" ");
			N = Integer.parseInt(NM[0]);
			M = Integer.parseInt(NM[1]);
			
			// 조합 결과를 저장하는 배열
			int [][] NR= new int [30][30];
			
			// 계산없이 알 수 있는 값들 저장
			for(int r=0; r<30;r++) {
				for(int c=0; c<30; c++) {
					if(c==0 || r==c) {
						NR[r][c] = 1;
					}
				}
			}
			
			// nCr = nC(n-r)
			if( N > M/2) {
				N = M-N;
			}
			
			// DP
			for(int r=0; r<=M;r++) {
				for(int c=0; c<=N; c++) {
					// 원래 값이 없던 곳 && nCr에서 n>=r인 곳
					if(c!=0 && r!=c && r>=c) {
						NR[r][c] = NR[r-1][c-1]+NR[r-1][c];
					}
				}
			}
			
			System.out.println(NR[M][N]);


			
			
			
		}

	}

	

	
}
//End