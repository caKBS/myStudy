package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1978_소수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int primeCnt = 0;
		for (int i = 0; i < num; i++) {
			int newNum = sc.nextInt();
			if (isPrime(newNum)) {
				primeCnt++;
			}
		}
		System.out.println(primeCnt);
	}

	public static boolean isPrime(int N) {
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0) {
				return false;
			}
		}
		if (N == 1) {
			return false;
		} else {
			return true;
		}
	}
}
// End
