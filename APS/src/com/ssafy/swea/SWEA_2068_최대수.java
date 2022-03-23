package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_2068_최대수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			int max = 0;
			for (int j = 0; j < 10; j++) {
				int newNum = sc.nextInt();
				if (max < newNum) {
					max = newNum;
				}
			}
			System.out.printf("#%d %d\n", i, max);
		}

	}

}
//End