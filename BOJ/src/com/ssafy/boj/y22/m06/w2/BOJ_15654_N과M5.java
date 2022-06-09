package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_15654_N과M5 {

	public static int N;
	public static int M;
	public static int [] sel;
	public static int [] data;
	public static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String [] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		String [] arr = br.readLine().split(" ");
		data = new int[N];
		for(int i=0; i<N;i++) {
			data[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(data);
		sel = new int[M];
		perm(0,0);
		System.out.println(sb);

	}
	
	public static void perm(int sidx, int check) {
		if(sidx==M) {
			// 순열 생성 완료
			for(int i=0; i<M;i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		
		
		for(int i=0; i< N; i++) {
			if( (check & (1<< i)) != 0) {
				continue;
			}
			sel[sidx]= data[i];
			perm(sidx+1, check | (1<<i));
		}
		
	}

}
//End