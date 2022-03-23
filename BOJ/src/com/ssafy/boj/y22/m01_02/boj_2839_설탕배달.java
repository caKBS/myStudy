package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] depth = new int[X+10];
		depth[3] = 1;
		depth[5] = 1;

		// 완전히 안담아지는경우도 작용을 받는다
		// 작용을 안받게끔
		for (int xIdx = 3; xIdx < X; xIdx++) {
			if (depth[xIdx] != 0) {
				depth[xIdx + 3] = min(depth[xIdx + 3], depth[xIdx] + 1);
				depth[xIdx + 5] = min(depth[xIdx + 5], depth[xIdx] + 1);
			}
		}
		if (depth[X] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(depth[X]);
		}
	}

	public static int min(int existVal, int newVal) {
		// 아직 초기화값 그대로인 애들은 최소계산에
		// 포함되지 않도록 한다.
		if (existVal == 0) {
			return newVal;
		} else if (existVal > newVal) {
			return newVal;
		} else {
			return existVal;
		}
	}
}
// End
