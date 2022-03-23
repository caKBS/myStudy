package com.ssafy.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_7102_준홍이의카드놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] Arr = new int[N + M + 1];
			List<Integer> result = new ArrayList<>();

			// 모든 경우의 수를 해보고 빈도를 저장
			for (int nIdx = 1; nIdx <= N; nIdx++) {
				for (int mIdx = 1; mIdx <= M; mIdx++) {
					Arr[nIdx + mIdx]++;
				}
			}
			// 최대빈도 찾기
			int max = 0;
			for (int aIdx = 2; aIdx <= N + M; aIdx++) {
				if (max < Arr[aIdx]) {
					max = Arr[aIdx];
				}
			}

			// 최대빈도을 갖는 수 모음
			for (int aIdx = 2; aIdx <= N + M; aIdx++) {
				if (max == Arr[aIdx]) {
					result.add(aIdx);
				}
			}

			// 출력
			System.out.printf("#%d ", tIdx);
			for (int lIdx = 0; lIdx < result.size(); lIdx++) {
				System.out.print(result.get(lIdx)+" ");
			}
			System.out.println();
		}
	}
}
//End