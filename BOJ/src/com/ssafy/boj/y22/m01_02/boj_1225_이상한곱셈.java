package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1225_이상한곱셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// String으로 받아서 char 배열로 만들기
		String stringA = sc.next();
		String stringB = sc.next();
		char[] charA = stringA.toCharArray();
		char[] charB = stringB.toCharArray();
		
		// 각 자리수의 합이다.
		// 곱셈의결과는 모두 9로 구성된 만자리 숫자 두개로 가정하면
		// (10만-1)*(10만-1)= 99억+a로 범위가 int보다 크므로 
		// 답의 type이 이 결과를 담을 수 있게 해줘야함.
		// 그래서 long을 사용.
		long intAsum = 0;
		long intBsum = 0;

		// Ascii를 바탕으로 Char를 Int로 만들고 각 자리수 합
		for (int aIdx = 0; aIdx < charA.length; aIdx++) {
			intAsum += ((int) (charA[aIdx])) - 48;
		}

		for (int bIdx = 0; bIdx < charB.length; bIdx++) {
			intBsum += ((int) (charB[bIdx])) - 48;
		}

		// A와 B의 각 자리수합을 곱셈
		System.out.printf("%d\n", intAsum * intBsum);

	}

}
// End
