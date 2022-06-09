package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10974_모든순열 {

	public static int N;
	public static int [] sel;
	public static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		sel = new int[N];
		perm(0,0);
		System.out.println(sb);

	}
	
	public static void perm(int sidx, int check) {
		if(sidx==N) {
			// 순열 생성 완료
			for(int i=0; i<N;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		
		
		for(int i=1; i<= N; i++) {
			if( (check & (1<< i)) != 0) {
				continue;
			}
			sel[sidx]=i;
			perm(sidx+1, check | (1<<i));
		}
		
	}

}
//End