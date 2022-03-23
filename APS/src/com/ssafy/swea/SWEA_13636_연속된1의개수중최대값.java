package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_13636_연속된1의개수중최대값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int caseLen = sc.nextInt();
			int maxCnt = 0;
			int cnt = 0;

			// 1과0으로 이루어진 수열을 Char의 배열로 받기
			char[] caseCharArr = sc.next().toCharArray();
			for (int cIdx = 0; cIdx < caseLen; cIdx++) {

				// 해당 char가 1이면 count++
				if (caseCharArr[cIdx] == '1') {
					cnt++;
				} else {
					cnt = 0;
				}
				// 각 char를 검사할때 마다 현재 cnt가 max인지 확인한다.
				// 그래야 다음 char에 상관없이 cnt를 업데이트할 수 있다.
				if (maxCnt < cnt) {
					maxCnt = cnt;
				}
			}
			System.out.printf("#%d %d\n", tIdx, maxCnt);
		}

	}
}

//End