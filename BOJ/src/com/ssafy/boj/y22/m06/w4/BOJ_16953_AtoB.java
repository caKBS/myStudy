package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_16953_AtoB {

	public static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		String [] AB = br.readLine().split(" ");
		int A = Integer.parseInt(AB[0]);
		int B = Integer.parseInt(AB[1]);
		
		// 몇번 연산
		int cnt = 0;
		// 만났느냐를 알려준다.
		boolean flag = false;
		// B가 작아지는 방향으로 간다.
		while(B>0) {
			// 만났다.
			if(B==A) {
				flag = true;
				break;
			}
			// B가 짝수이면
			if(B%2==0) {
				B /= 2;
			// B 끝자리가 1이면
			}else if(B % 10 == 1) {
				B /= 10;
			// B가 위 2가지 조건에 안걸리면 A한테 갈 수 없는 것.
			}else {
				break;
			}
			cnt++;
		}
		
		if(flag) {
			System.out.println(cnt+1);
		}else {
			System.out.println(-1);
		}
		
	}
}
//End