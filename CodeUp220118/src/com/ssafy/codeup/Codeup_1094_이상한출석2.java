package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1094_이상한출석2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] Arr = new int[num];
		


		// 입력을 배열로
		for (int i = 0; i < num; i++) {
			Arr[i]= sc.nextInt();
		}
		
		// 거꾸로 출력
		for (int i = num-1 ; i >=0 ; i--) {
			System.out.printf("%d ", Arr[i]);
		}
		

	}
}
// End