package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_2063_중간값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int caseLen = sc.nextInt();
		int[] caseArr = new int[caseLen];
		for (int cIdx = 0; cIdx < caseLen; cIdx++) {
			caseArr[cIdx] = sc.nextInt();
		}
		// 오름차순 정렬
		for (int nSwap = 0; nSwap < caseLen - 1; nSwap++) {
			for (int swap = 0; swap < (caseLen - 1) - nSwap; swap++) {
				int tmp;
				if (caseArr[swap] > caseArr[swap + 1]) {
					tmp = caseArr[swap + 1];
					caseArr[swap + 1] = caseArr[swap];
					caseArr[swap] = tmp;
				}
			}
		}

		// 중간인덱스는 (Array의 length-1)/2
		System.out.printf("%d", caseArr[(caseLen-1)/2]);


	}

}
//End