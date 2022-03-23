package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_5097_회전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			// 입력받기
			int N = sc.nextInt();
			int M = sc.nextInt();
			int n = M % N;
			int ans = 0;
			// M%N번째 원소가 정답
			for (int nIdx = 0; nIdx < N; nIdx++) {
				int tmp = sc.nextInt();
				if (nIdx == n) {
					ans = tmp;
				}
			}
			System.out.printf("#%d %d\n", tIdx, ans);
		}
	}
}
//End