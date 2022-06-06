package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_10972_다음순열 {

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
		
		// 맨뒤부터 값을 올릴 자릿수 찾기
		int pick = -1;
		int pickIdx = -1;
		for(int i= N-2; i>=0; i--) {
			if(perm[i] < perm[i+1]) {
				pick= perm[i];
				pickIdx = i;
				break;
			}
		}
		
		// 사전순으로 마지막에 오는 순열인 경우
		if(pickIdx == -1) {
			System.out.println(-1);
			return;
		}
		
		// swap할 친구 찾기
		int target = Integer.MAX_VALUE;
		int targetIdx = -1;
		for(int i= pickIdx+1; i<N; i++) {
			if(perm[i] <target && perm[i] > pick) {
				target = perm[i];
				targetIdx = i;
			}
		}
		
		// swap
		perm[pickIdx] = target;
		perm[targetIdx] = pick;
		
		// pick 이후 오름차순 정렬, toIndex는 exclusive이므로 정해준 Idx 직전까지 정렬한다.
		Arrays.sort(perm,pickIdx+1,N);
		
		for(int i=0; i<N;i++) {
			sb.append(perm[i]+" ");
		}
		System.out.println(sb);
	}
}
//End