package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15650_N과M2 {

	public static int N;
	public static int M;
	public static int [] sel;
	public static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String [] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		sel = new int[M];
		comb(1, 0);
		System.out.println(sb);


	}
	
	public static void comb(int bt, int sidx) {
		if(sidx==M) {
			// 조합 생성 완료
			for(int i=0; i<M;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i=bt; i<=N+1-M+sidx; i++) {
			sel[sidx] = i;
			comb(i+1, sidx+1);
		}

		
	}

}
//End