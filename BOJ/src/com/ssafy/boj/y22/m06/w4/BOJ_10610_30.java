package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_10610_30 {

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 30의 배수일라면 0이 맨뒤에 하나 있고 그외 전체합이 3의 배수여야함.
		// 고로 일단 30의 배수인가를 판단하고
		// 30의 배수 조건을 통과하면 숫자를 어떻게 바꿔도 0만 맨 마지막에 있으면
		// 무조건 30의 배수이다.(조건이 합이 3의 배수라고 했으니)
		// 고로, 내림차순으로 정렬해서 최대 수를 만든다.
		
		
		// 입력 받기
		// 자리수 모두 더하기
		int sum=0;
		// 0이 있는가
		boolean zeroFlag = false;
		String strN = br.readLine();
		PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
		
		// 각 자리수 스캔하면서 sum에 더하고 PQ에 넣고 zero있나 확인
		for(int i=0; i<strN.length();i++) {
			int digit = strN.charAt(i)-'0';
			sum+=digit;
			PQ.add(digit);
			if(digit == 0) {
				zeroFlag = true;
			}
		}
		
		// 내림차순으로 새로운 숫자 만들기
		while(!PQ.isEmpty()) {
			sb.append(PQ.poll());
		}

		// 30의 배수가 가능하면 새로 만든 숫자 출력
		if(zeroFlag && sum %3==0) {
			System.out.println(sb);
		// 불가능하면 -1 출력.
		}else {
			System.out.println(-1);
		}
		
	}

}
//End