package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_14888_연산자끼워넣기 {

	public static int N;
	public static int maxVal;
	public static int minVal;
	public static int [] sel ;
	public static int[] op;
	public static int[] nums;
	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 최대, 최소 초기화
		maxVal = Integer.MIN_VALUE;
		minVal = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		String[] A = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(A[i]);
		}

		String[] oper = br.readLine().split(" ");
		int[] opers = new int[4];
		for (int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(oper[i]);
		}
		op = new int[N - 1];
		int opIdx = 0;
		for (int i = 0; i < 4; i++) {
			while (opers[i] > 0) {
				op[opIdx++] = i;
				opers[i]--;
			}
		}
		
		// 부호 선택 배열(N-1개)
		sel = new int[N-1];
		
		// 부호 순열 만들기
		perm(0,0);
		
		// 출력
		System.out.println(maxVal);
		System.out.println(minVal);
		
	}
	
	public static void perm(int sidx, int check) {
		
		if(sidx==N-1) {
			// 부호 선택 완료
			int val = calcu(sel);
			maxVal = Math.max(maxVal, val);
			minVal = Math.min(minVal, val);
			return;
			
		}
		
		
		
		for(int i=0; i<N-1; i++) {
			if((check & (1<<i)) != 0) {
				continue;
			}
			sel[sidx] = op[i];
			perm(sidx+1, check | (1<<i));
		}
	}
	
	public static int calcu(int [] operators) {
		int sum=nums[0];
		for(int i=1; i<N;i++) {
			switch(operators[i-1]) {
			// '+'
			case 0:
				sum+=nums[i];
				break;
			// '-'
			case 1:
				sum-=nums[i];
				break;
			// '*'
			case 2:
				sum*=nums[i];
				break;
			// '%'
			case 3:
				if(sum >= 0) {
					sum /= nums[i];
				}else {
					sum = Math.abs(sum) / nums[i] * -1;
				}
				break;
			}
		}
		return sum;
	}

}
//End