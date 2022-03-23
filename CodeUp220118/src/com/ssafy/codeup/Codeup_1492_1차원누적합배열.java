package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1492_1차원누적합배열 {

	public static void main(String[] args) {

		// 값 얻기
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] Arr = new int[num];
		for (int i = 0; i < num; i++) {
			Arr[i] = sc.nextInt();
		}

		for (int i = 1; i < num; i++) {
			Arr[i] = Arr[i] + Arr[i - 1];
		}

		// 출력
		for (int i = 0; i < num; i++) {
			System.out.printf("%d ", Arr[i]);
		}

	}
}
// End