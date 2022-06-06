package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1256_사전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		
		String [] aline = br.readLine().split(" ");
		int N = Integer.parseInt(aline[0]);
		int M = Integer.parseInt(aline[1]);
		int K = Integer.parseInt(aline[2]);
		int T = N+M;
		
		// 문자열 초기화
		char [] arr = new char [N+M];
		for(int i=0; i<N+M; i++) {
			if(i<N) {
				arr[i] = 'a';
			}else {
				arr[i] = 'z';
			}
		}
		boolean flag = true;
		// K-1번 실행
		for(int kc = 0; kc < K-1; kc++) {
			
			int pivot=-1;
			for(int i= T-2; i>=0; i--) {
				if(arr[i] < arr[i+1]) {
					pivot=i;
					// 첫발견시 바로 빠져나와야함.
					// 첫 [a,z] 형태를 발견하는게 목적이므로
					break;
				}
			}
			
			// 이미 끝 문자열 도달
			// 규완이의 사전에 수록되어 있는 문자열의 개수가 K보다 작을때
			if(pivot==-1) {
				flag = false;
				break;
			}
			
			// swap
			swap(arr, pivot, pivot+1);
			
			// pivot 이후 오름차순 정렬
			Arrays.sort(arr, pivot+1, T);
			
		}
		
		if(flag) {
			System.out.println(arr);
		}else {
			System.out.println(-1);
		}
		
		
	}
	
	public static void swap(char [] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
//End