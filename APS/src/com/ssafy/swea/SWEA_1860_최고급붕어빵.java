package com.ssafy.swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_최고급붕어빵 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] timeBoard = new int[N];

			for (int nIdx = 0; nIdx < N; nIdx++) {
				timeBoard[nIdx] = sc.nextInt();
			}
			// 시간들을 오름차순 정렬
			Arrays.sort(timeBoard);

            boolean flag = true;
			for (int timeIdx = 0; timeIdx < N; timeIdx++) {
				// timeBoard[timeIdx] / M * K -> 내 시간까지 아무도 안먹었을때
				// 총 쌓인 개수
				// (timeIdx+1) -> 나 포함 내 이전 사람들이 먹은 개수
				if (timeBoard[timeIdx] / M * K - (timeIdx+1) < 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.printf("#%d %s\n", tIdx, "Possible");
			} else {
				System.out.printf("#%d %s\n", tIdx, "Impossible");
			}
		}
	}
}
//End