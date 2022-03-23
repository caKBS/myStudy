package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int arrAlen = sc.nextInt();
			int arrBlen = sc.nextInt();
			int longArrlen = 0;
			int shortArrlen = 0;
			// A,B 배열 받기
			int[] arrA = new int[arrAlen];
			int[] arrB = new int[arrBlen];
			for (int aIdx = 0; aIdx < arrAlen; aIdx++) {
				arrA[aIdx] = sc.nextInt();
			}
			for (int bIdx = 0; bIdx < arrBlen; bIdx++) {
				arrB[bIdx] = sc.nextInt();
			}

			// A, B를 긴 배열, 짧은 배열로 분류
			int[] arrLong;
			int[] arrShort;
			if (arrAlen >= arrBlen) {
				arrLong = arrA;
				arrShort = arrB;
				longArrlen = arrAlen;
				shortArrlen = arrBlen;
			} else {
				arrLong = arrB;
				arrShort = arrA;
				longArrlen = arrBlen;
				shortArrlen = arrAlen;
			}

			// shift할 횟수
			int shift = longArrlen - shortArrlen;

			// 한번의 sum은 짧은 배열의 길이만큼 곱셈이고
			// 긴 배열의 idx를  1씩 shift하면서 sum 계산 반복
			// 마지막으로 최대 Sum 얻기
			int maxSum = -987654321;
			for (int sft = 0; sft <= shift; sft++) {
				int sum = 0;
				for (int mulIdx = 0; mulIdx < shortArrlen; mulIdx++) {
					sum += arrLong[mulIdx + sft] * arrShort[mulIdx];
				}
				if (sum > maxSum) {
					maxSum = sum;
				}
			}

			System.out.printf("#%d %d\n", tIdx, maxSum);

		}
	}
}
//End