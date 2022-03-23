package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_2817_부분수열합 {
	static int N;
	static int K;
	static int[] Arr;
	static boolean[] TF;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();
		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {
			N = sc.nextInt();
			K = sc.nextInt();
			Arr = new int[N];
			TF = new boolean[N];
			// 숫자 배열 입력받기
			for (int nIdx = 0; nIdx < N; nIdx++) {
				Arr[nIdx] = sc.nextInt();
			}
			System.out.printf("#%d %d\n", tIdx, allCase(0));
		}
	}

	// idx0 부터 시작해서 모든 케이스에 대해 확인
	public static int allCase(int dept) {
		int cnt = 0;
		if (dept == N) {
			int sum = 0;
			for (int nIdx = 0; nIdx < N; nIdx++) {
				if (TF[nIdx] == true) {
					sum += Arr[nIdx];
				}
			}
			if (sum == K) {
				return 1;
			}
			return 0;
		}
		// cnt가 return에 의해 누적되게끔.
		TF[dept] = false;
		cnt += allCase(dept + 1);
		TF[dept] = true;
		cnt += allCase(dept + 1);
		return cnt;
	}
}
//End