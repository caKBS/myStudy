package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1233_주사위 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 합을 인덱스로 사용하고 값을 그 합의 개수로 하자.
		int[] sumList = new int[81];

		int S1 = sc.nextInt();
		int S2 = sc.nextInt();
		int S3 = sc.nextInt();

		// 경우의 수 다 해본다.
		for (int fIdx = 1; fIdx <= S1; fIdx++) {
			for (int sIdx = 1; sIdx <= S2; sIdx++) {
				for (int tIdx = 1; tIdx <= S3; tIdx++) {
					int sumIdx = fIdx + sIdx + tIdx;
					sumList[sumIdx]++;
				}
			}
		}

		// 최대를 찾아본다.
		int maxSum = 0;
		int maxSumIdx = 0;
		for (int sumIdx = 0; sumIdx <= 80; sumIdx++) {
			if (maxSum < sumList[sumIdx]) {
				maxSum = sumList[sumIdx];
				maxSumIdx = sumIdx;
			}
		}

		System.out.println(maxSumIdx);

	}

}
// End
