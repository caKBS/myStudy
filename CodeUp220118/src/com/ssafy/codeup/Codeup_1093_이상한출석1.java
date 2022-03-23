package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1093_이상한출석1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] count = new int[23];
		
		// count배열 초기화
		for (int i = 0; i < 23; i++) {
			count[i] = 0;
		}

		// 입력 바탕으로 count 배열 값 상승
		for (int i = 0; i < num; i++) {
			int call = sc.nextInt();
			count[call-1]++;
		}
		
		// 출력
		for (int i = 0; i < 23; i++) {
			System.out.printf("%d ", count[i]);
		}
		

	}
}
// End