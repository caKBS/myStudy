package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1193_분수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();

		// [a,b] -> a/b
		int[] frac = { 2, 0 };

		// [2(수),0(공)]으로 시작해서
		// 공격이 1씩 늘어나고 수비는 1씩 줄어들다가
		// 수비가 1이 되면 공격이 +1하고
		// 공수교체 후 반복
		int atkIdx = 1;
		int defIdx = 0;
		boolean upgrade = false;

		for (int i = 0; i < num; i++) {
			if (upgrade == true) {
				frac[atkIdx]++;
				atkIdx = atkIdx ^ 1;
				defIdx = defIdx ^ 1;
				upgrade = false;
			} else {
				frac[atkIdx]++;
				frac[defIdx]--;
				if (frac[defIdx] == 1) {
					upgrade = true;
				}
			}
		}

		System.out.printf("%d/%d", frac[0], frac[1]);

	}
}

// End
