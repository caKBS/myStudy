package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1213_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {

			// 몇번째 case인지 -> 불필요
			int caseNum = sc.nextInt();

			String pattern = sc.next();

			String sentence = sc.next();

			int sIdx = 0;
			int pIdx = 0;
			int cnt = 0;
			// 고지식한 알고리즘 그대로 적용
			while (sIdx < sentence.length()) {
				if (pattern.charAt(pIdx) != sentence.charAt(sIdx)) {
					sIdx = sIdx - pIdx;
					pIdx = -1;
				}
				sIdx += 1;
				pIdx += 1;
				// if 문을 추가하여 발견시 cnt++하고 idx 위치 조정
				if (pIdx == pattern.length()) {
					cnt++;
					sIdx += 1;
					pIdx = 0;
				}
			}
			System.out.printf("#%d %d\n", tIdx, cnt);
		}
	}
}
//End