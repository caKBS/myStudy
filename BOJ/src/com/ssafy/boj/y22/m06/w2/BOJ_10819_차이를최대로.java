package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_10819_차이를최대로 {

	public static int N;
	public static int maxVal;
	public static int [] sel;
	public static int [] data;
	public static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 최댓값 초기화
		maxVal=-1;
		
		// 입력 받기
		N = Integer.parseInt(br.readLine());
		String [] aline= br.readLine().split(" ");
		data = new int[N];
		for(int i=0; i<N;i++) {
			data[i]=Integer.parseInt(aline[i]);
		}

		// 선택배열
		sel = new int [N];
		
		// 순열 만들기
		perm(0,0);
		
		// 출력
		System.out.println(maxVal);

	}
	
	public static void perm(int sidx, int check) {
		if(sidx==N) {
			// 순열 생성 완료
			int val = equ(sel);
			maxVal = Math.max(maxVal, val);
			return;
		}
		
		for(int i=0; i<N;i++) {
			if((check & (1<<i)) != 0){
				continue;
			}
			sel[sidx] = data[i];
			perm(sidx+1, check | (1<<i));
		}
	}
	
	public static int equ(int [] selected) {
		int sum=0;
		for(int i=0; i<N-1; i++) {
			sum+= Math.abs(selected[i]-selected[i+1]);
		}
		return sum;
	}
	
	
}
//End