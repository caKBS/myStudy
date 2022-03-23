package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1989_초심자회문검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {
			//스트링 받기
			String word = sc.next();
			//스트링 길이
			int wLen = word.length();
			int lastIdx = wLen-1;
			// 절반을 홀수일땐 (길이-1)/2, 짝수일땐 길이/2로 본다.
			int halfLen=(wLen-wLen%2)/ 2;
			boolean palin = true;

			// 앞뒤로 절반index까지 비교하면서 다르면 palin = false
			for (int wIdx=0; wIdx < halfLen; wIdx++) {
				if(word.charAt(wIdx) != word.charAt(lastIdx-wIdx)) {
					palin = false;
				}
			}
			
			if (palin) {
				System.out.printf("#%d %d\n", tIdx, 1);
			} else {
				System.out.printf("#%d %d\n", tIdx, 0);
			}	
		}
	}
}
//End