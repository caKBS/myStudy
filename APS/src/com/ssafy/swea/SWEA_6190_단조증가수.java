package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_6190_단조증가수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			// 입력받기
			int N = sc.nextInt();
			int[] Arr = new int[N];
			for (int nIdx = 0; nIdx < N; nIdx++) {
				Arr[nIdx] = sc.nextInt();
			}

			// 모든 두 항의 곱셈 경우의 수에 대해 확인
			int maxVal = Integer.MIN_VALUE;
			boolean danzoExist = false;
			for (int fIdx = 0; fIdx < N - 1; fIdx++) {
				for (int sIdx = fIdx + 1; sIdx < N; sIdx++) {
					int newNum = Arr[fIdx] * Arr[sIdx];
					int tmpNum = newNum;
					// 첫자리수가 다음 자리수보다 크거나 같으면
					// 다음 자리수가 첫자리수가 되고 단조는 true
					// 끝까지 단조가 true면 통과.
					// 작으면 단조는 false되고 바로 끝.
					int remain = tmpNum % 10;
					boolean danzo = false;
					while (tmpNum > 0) {
						if (remain >= tmpNum % 10) {
							remain = tmpNum % 10;
							danzo = true;
							tmpNum /= 10;
						} else {
							danzo = false;
							break;
						}
					}
					// 단조인 애들 중 기존 최대보다 크면 업데이트
					if (danzo) {
						danzoExist = true;
						if (newNum > maxVal) {
							maxVal = newNum;
						}
					}
				}
			}
			if (danzoExist) {
				System.out.printf("#%d %d\n", tIdx, maxVal);
			} else {
				System.out.printf("#%d %d\n", tIdx, -1);
			}
		}
	}
}
//End