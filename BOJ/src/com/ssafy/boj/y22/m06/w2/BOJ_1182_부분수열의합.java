package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1182_부분수열의합 {
	
	public static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		
		String [] NS = br.readLine().split(" ");
		int N = Integer.parseInt(NS[0]);
		int S = Integer.parseInt(NS[1]);
		String [] aline = br.readLine().split(" ");
		int [] nums = new int[N];
		for(int i=0; i<N;i++) {
			nums[i] = Integer.parseInt(aline[i]);
		}

		
		int cnt=0;
		//bitMask 생성
		for(int BM=1; BM<Math.pow(2, N); BM++) {
			// 해당 bitMask로 마스킹
			int sum = 0;
			for(int dgt=0; dgt <N;dgt++) {
				if( ((1<<dgt) & BM) != 0) {
					sum+=nums[dgt];
				}
			}
			// 합이 S가 되는 부분수열 카운트
			if(sum==S) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
}
//End