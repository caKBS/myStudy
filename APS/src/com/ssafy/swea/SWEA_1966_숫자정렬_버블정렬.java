package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1966_숫자정렬_버블정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();

		for (int tIdx = 1; tIdx <= tNum; tIdx++) {
			int caseLen = sc.nextInt();
			int[] caseArr = new int[caseLen];
			for (int cIdx = 0; cIdx < caseLen; cIdx++) {
				caseArr[cIdx] = sc.nextInt();
			}
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
			
			System.out.printf("#%d ", tIdx);
			for (int printIdx = 0; printIdx < caseLen; printIdx++) {
				System.out.printf("%d ", caseArr[printIdx]);
			}
			System.out.println();
		}

	}

}
//End