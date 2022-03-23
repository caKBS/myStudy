package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_2798_블랙잭 {
	static int N;
	static int M;
	static int maxUnderM = 0;
	static int[] Arr;
	static boolean[] TF;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Arr = new int[N];
		TF = new boolean[N];
		// 숫자 배열 입력받기
		for (int nIdx = 0; nIdx < N; nIdx++) {
			Arr[nIdx] = sc.nextInt();
		}
		allCase(0, 0);
		System.out.println(maxUnderM);
	}

	// idx0 부터 시작해서 재귀를 사용하여 
	// 모든 케이스에 대해 확인
	public static void allCase(int dept, int trueNum) {
		int cnt = 0;
		// 3개의 카드일때만 max를 갱신하는 if문에 진입할 수 있음.
		if (trueNum == 3) {
			int sum = 0;
			for (int nIdx = 0; nIdx < dept; nIdx++) {
				if (TF[nIdx] == true) {
					sum += Arr[nIdx];
				}
			}
			if (maxUnderM < sum && sum <= M) {
				maxUnderM = sum;
			}
			return;
		}
		// 3개의 카드를 얻지 못한 상태에서 
		// 끝에 다다르는 경우는 아무것도 없이 끝내기.
		if (dept == N) {
			return;
		}
		TF[dept] = false;
		allCase(dept + 1, trueNum);
		TF[dept] = true;
		allCase(dept + 1, trueNum + 1);
	}
}
// End
