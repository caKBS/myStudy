package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1339_단어수학 {

	public static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		Integer [] ABC = new Integer [26];
		// 자료형을 Integer객체로 사용하기 때문에 default값이 없으므로
		// 따로 0으로 설정해준다.
		Arrays.fill(ABC, 0);
		for(int i=0; i<N;i++) {
			String word = br.readLine();
			for(int w=0; w<word.length(); w++) {
				ABC[word.charAt(w)-'A'] += (int)Math.pow(10, word.length()-1-w);
			}
		} // 입력받기 끝
		
		// 내림차순 정렬
		Arrays.sort(ABC, Collections.reverseOrder());
		
		// 비중이 큰 애부터 높은 수 할당
		// 총합
		int sum=0;
		// 할당할 수
		int num=9;
		// 알파벳 배열의 인덱스
		int idx=0;
		while(ABC[idx]!=0) {
			sum += num--*ABC[idx++];
		}
		
		// 출력
		System.out.println(sum);
	}
}
//End