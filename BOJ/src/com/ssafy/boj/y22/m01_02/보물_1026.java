package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class 보물_1026 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받기
		int num = sc.nextInt();
		int[] Arr1 = new int[num];
		int[] Arr2 = new int[num];
		for (int i = 0; i < num; i++) {
			Arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < num; i++) {
			Arr2[i] = sc.nextInt();
		}
		sc.close();

		int buf = 0;
		boolean flag = true;
		// 오름차순
		while (flag) {
			flag = false;
			for (int i = 0; i < num - 1; i++) {
				if (Arr1[i] > Arr1[i + 1]) {
					buf = Arr1[i];
					Arr1[i] = Arr1[i + 1];
					Arr1[i + 1] = buf;
					flag = true;
				}
			}
		}

		buf = 0;
		flag = true;
		// 내림차순
		while (flag) {
			flag = false;
			for (int i = 0; i < num - 1; i++) {
				if (Arr2[i] < Arr2[i + 1]) {
					buf = Arr2[i];
					Arr2[i] = Arr2[i + 1];
					Arr2[i + 1] = buf;
					flag = true;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += Arr1[i] * Arr2[i];
		}

		System.out.println(sum);

	}

}
// End
