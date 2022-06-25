package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1439_뒤집기 {

	public static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		String N = br.readLine();
		
		// idx0 : 0세트의 개수 저장
		// idx1 : 1세트의 개수 저장
		int [] cnt = new int[2];
		int curr = -1;
		// cnt는 해당 세트를 시작할때 반영
		// 세트 개수 세기
		for(int i=0; i<N.length();i++) {
			if((N.charAt(i)-'0') != curr) {
				curr = (N.charAt(i)-'0');
				cnt[N.charAt(i)-'0']++;
			}
		}
		// 더 수가 작은 세트 개수 출력
		System.out.println(Math.min(cnt[0], cnt[1]));
	}
}
//End