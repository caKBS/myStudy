package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1416_2진수변환 {

	public static void main(String[] args) {

		// 입력 얻기
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] ans = new int[40];
		int digit = 1;

		// 입력이 0인 경우
		if (num == 0) {
			System.out.print(0);
			return;
		}
		
		// 그외. 2로 나눈 나머지 배열에 저장, index가 곧 자릿수(index1부터 사용)
		while (true) {
			if (num == 0) {
				break;
			}
			ans[digit] = num % 2;
			num = num / 2;
			digit++;
		}

		// 출력
		for (int i = digit-1; i > 0; i--) {
			System.out.print(ans[i]);

		}
	}
}
// End