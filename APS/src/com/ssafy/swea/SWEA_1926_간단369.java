package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1926_간단369 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int num = 1; num <= N; num++) {
			// 한자리수
			if (num <= 9) {
				// 3,6,9가 존재하지 않으면 숫자 출력
				if (!rule(num, 1)) {
					System.out.print(num);
				}
				// 두자리수
			} else if (num >= 10 && num <= 99) {
				if (!rule(num, 2)) {
					System.out.print(num);
				}
				// 세자리수
			} else if (num >= 100) {
				if (!rule(num, 3)) {
					System.out.print(num);
				}
			}
			System.out.print(" ");
		}
	}

	public static boolean rule(int num, int digit) {
		boolean exist = false;
		for (int i = 0; i < digit; i++) {
			if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
				exist = true;
				// 369가 존재할때마다 "-" 출력
				System.out.print("-");
			}
			num /= 10;
		}
		return exist;
	}
}
//End