package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_2071_평균값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			double sum=0;
			for (int j = 0; j < 10; j++) {
				sum += sc.nextInt();
			}
			int avg = (int)((sum+5) / 10);
			System.out.printf("#%d %d\n",i, avg);
		}

	}

}
//End