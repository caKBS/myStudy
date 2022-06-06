package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1759_암호만들기 {
	public static char [] selected;
	public static int L;
	public static int C;
	public static char [] candi;

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 1. 조건을 만족하도록 조합하기
		// 2. 일단 모든 조합찾고 조건을 만족하는 것만 거르기
		// 2번으로 가자.
		
		// 입력받기
		String [] LC = br.readLine().split(" ");
		L = Integer.parseInt(LC[0]);
		C = Integer.parseInt(LC[1]);
		String [] aline = br.readLine().split(" ");
		candi = new char [C];
		for(int i=0; i<C;i++) {
			candi[i] = aline[i].charAt(0);
		}
		// 알파벳 후보군도 조합전에 먼저 sort를 한번 해놓으면
		// 출력이 사전순으로 나온다.
		Arrays.sort(candi);

		// C개의 알파벳 중 L개를 조합
		selected = new char [L];
		comb(0,0);
		
	}
	
	
	public static void comb(int idx, int sidx) {
		if(sidx==L) {
			// 조합완료
			// 모음, 자음 개수 세기
			int motherCnt = 0;
			int sonCnt = 0;
			for(int i=0; i< L; i++) {
				if(selected[i]== 'a' || selected[i]== 'e' || selected[i]== 'i' ||
						selected[i]== 'o' || selected[i]== 'u' ) {
					motherCnt += 1;
				}else {
					sonCnt+=1;
				}
			}
			
			// 조건을 만족하는 경우
			if(motherCnt>=1 && sonCnt>=2) {
				char [] tmp = new char [L];
				for(int i=0; i< L; i++) {
					tmp[i] = selected[i];
				}
				Arrays.sort(tmp);
				System.out.println(tmp);
			}
				
				
			return;
		}
		
		
		for(int i=idx; i<= C-L+sidx; i++) {
			selected[sidx] = candi[i];
			comb(i+1, sidx+1);
		}
	}
	

	
}
//End