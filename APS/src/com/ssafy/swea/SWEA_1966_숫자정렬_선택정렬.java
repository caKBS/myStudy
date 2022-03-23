package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1966_숫자정렬_선택정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 구성
		int tNum = sc.nextInt();
		for (int tIdx = 1; tIdx <= tNum; tIdx++) {

			// 각 케이스의 숫자들로 배열 구성
			int caseLen = sc.nextInt();
			int[] caseArr = new int[caseLen];
			for (int cIdx = 0; cIdx < caseLen; cIdx++) {
				caseArr[cIdx] = sc.nextInt();
			}

			// flag는 기준위치, seek는 탐색위치.
			// 미정렬 원소가 하나 남은 상황에서는 마지막 원소가
			// 가장 큰 값을 갖게 되므로, 선택 정렬 완료.
			for (int flagIdx = 0; flagIdx < caseLen - 1; flagIdx++) {
				int minIdx = flagIdx;
				for (int seekIdx = flagIdx + 1; seekIdx < caseLen; seekIdx++) {
					if (caseArr[minIdx] > caseArr[seekIdx]) {
						minIdx = seekIdx;
					}
				}
				// swap
				int tmp = caseArr[minIdx];
				caseArr[minIdx] = caseArr[flagIdx];
				caseArr[flagIdx] = tmp;

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