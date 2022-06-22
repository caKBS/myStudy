package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class BOJ_10162_전자레인지 {

	public static StringBuilder sb;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] rope = new int[N];
		for(int i=0; i<N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		// 오름차순 정렬
		Arrays.sort(rope);
		int maxVal = -1;
		// 작은 것 부터 가지치기
		// 본인 * 남은 총 개수로 maxVal 갱신
		for(int i=0; i<N; i++) {
			maxVal = Math.max(maxVal, rope[i]*(N-i));
		}
		
		// 출력
		System.out.println(maxVal);
	}

}
//End