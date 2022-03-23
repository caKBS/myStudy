package com.ssafy.boj.y22.m01_02;


import java.util.Scanner;

public class 한수_1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받기
		int num = sc.nextInt();
		sc.close();
		int result = 0;
		int han = 0;
		int digit100 = 0;
		int digit10 = 0;
		int digit1 = 0;

		if (num < 100) {
			result = num;
		}
		else if ( num <= 110) {
			result = 99 ;
		} else {
			if (num == 1000) {
				num -= 1;
			}

			for (int i = 111; i <= num; i++) {
				int test = i;
				digit1 = test % 10;
				test /= 10;
				digit10 = test % 10;
				test /= 10;
				digit100 = test % 10;
				if ( (digit100 - digit10 == digit10 - digit1) || 
						(digit10 - digit100 == digit1 - digit10) ) {
					han++;
				}
			}
			result = 99 + han;
		}

		System.out.println(result);

	}
}
// End
