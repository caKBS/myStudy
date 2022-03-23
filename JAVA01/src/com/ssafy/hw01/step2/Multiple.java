package com.ssafy.hw01.step2;

import java.util.Scanner;

public class Multiple {
	public static void main(String[] args) {

		while (true) {

			System.out.print("숫자를 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();

			if (num == 0) {
				System.out.println("프로그램 종료");
				return;
			}

			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d \n", num, i, num * i);
			}
		}

	}
}
// 