package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_10973_이전순열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String [] aline = br.readLine().split(" ");
		int [] perm = new int[N];
		for(int i=0; i<N;i++) {
			perm[i] = Integer.parseInt(aline[i]);
		}
		
		// pivot 찾기
		int pivot = -1;
		for(int i=N-2; i>=0; i--) {
			if(perm[i] > perm[i+1]) {
				pivot = i;
				break;
			}
		}
		
		// 사전순으로 가장 처음에 오는 순열인 경우
		if( pivot == -1) {
			System.out.println(-1);
			return;
		}
		
		// pivot 이후 부분 뒤집기
		int st = pivot+1;
		int ed = N-1;
		while(st<ed) {
			swap(perm,st,ed);
			st++;
			ed--;
		}
		
		// pivot 이후 부분에서 pivot보다 작으면서 가장 큰 성분 찾기
		// pivot 이후는 내림차순되어 있으므로 처음으로 찾은 pivot보다 작은 값이
		// 우리가 원하는 성분임.
		int target = -1;
		for(int i=pivot+1; i<N;i++) {
			if(perm[pivot] > perm[i]) {
				target = i;
				break;
			}
		}
		
		// swap
		swap(perm,pivot, target);
		
		// 출력
		for(int i=0; i<N;i++) {
			sb.append(perm[i]+" ");
		}
		System.out.println(sb);
	}
	
	public static void swap( int [] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
//End