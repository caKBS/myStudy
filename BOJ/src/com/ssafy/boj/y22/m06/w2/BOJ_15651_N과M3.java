package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15651_N과M3 {

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
		perm(0);
		System.out.println(sb);

	}
	
	public static void perm(int sidx) {
		if(sidx==M) {
			// 순열 생성 완료
			for(int i=0; i<M;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		
		
		for(int i=1; i<= N; i++) {
			sel[sidx]=i;
			perm(sidx+1);
		}
		
	}

}
//End