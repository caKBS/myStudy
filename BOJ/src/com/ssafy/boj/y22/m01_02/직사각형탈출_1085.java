package com.ssafy.boj.y22.m01_02;


import java.util.Scanner;

public class 직사각형탈출_1085 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받기
		int x= sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		sc.close();
		
		int min = x;
		if (y < min) {
			min=y;
		}
		if (w-x < min) {
			min=w-x;
		}

		if (h-y < min) {
			min=h-y;
		}
		
		System.out.println(min);

	}
}
// End
