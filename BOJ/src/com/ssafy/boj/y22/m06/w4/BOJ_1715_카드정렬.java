package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1715_카드정렬 {

	public static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		for(int i=0; i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			PQ.add(num);
		} // 입력받기 끝
		
		// cnt : 총 비교 횟수
		int cnt = 0;
		// 숫자가 하나 남을때까지 더해줄거다.
		while(PQ.size() > 1) {
			// 가장 작은 2개 숫자 꺼내서 합치기
			int sum = PQ.poll() + PQ.poll();
			// 비교 횟수에 반영
			cnt += sum;
			// 합친 것을 다시 후보군에 넣기
			PQ.add(sum);
		}
		
		// 출력
		System.out.println(cnt);
	}

}
//End