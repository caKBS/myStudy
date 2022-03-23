package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_5432_쇠막대기자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			String testCase = sc.next();
			char[] charArr = testCase.toCharArray();

			int sum = 0;
			int running = 0;
			for (int cidx = 0; cidx < charArr.length; cidx++) {
				if ((cidx + 1 < charArr.length) && charArr[cidx] == '(' 
						&& charArr[cidx + 1] == ')') {
					sum += running;
					cidx++;
				} else if (charArr[cidx] == '(') {
					sum++;
					running++;
				} else if (charArr[cidx] == ')') {
					running--;
				}
			}
			System.out.printf("#%d %d\n", tIdx, sum);
		}
	}
}
//End