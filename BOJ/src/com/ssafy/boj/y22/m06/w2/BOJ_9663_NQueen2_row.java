package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_9663_NQueen2_row {

	public static int N;
	public static int cnt;
	public static StringBuilder sb;

	public static int[] pick;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		cnt = 0;
		N = Integer.parseInt(br.readLine());
		
		// 인덱스는 행, 값은 고른 열
		pick = new int [N];
		dfs(0);
		System.out.println(cnt);

	}

	public static void dfs(int r) {
		
		if(r==N) {
			cnt++;
			return;
		}
		
		
		// 열 고르기
		for(int c=0; c<N; c++) {
			// 이전 선택(rVal, cVal)들과 겹치는지 검사
			boolean flag = true;
			for(int rVal=0; rVal<r; rVal++) {
				int cVal = pick[rVal];
				if(c==cVal || Math.abs(r-rVal) == Math.abs(c-cVal)) {
					flag = false;
					// 겹친다고 나오면 바로 검사 종료
					break;
				}
			}
			// 이전과 겹치지 않을때
			if(flag) {
				pick[r] = c;
				dfs(r+1);
			}
		}
	}

}
//End