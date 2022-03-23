package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1966_숫자정렬_카운트정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 구성
		int tNum = sc.nextInt();
		for (int tIdx = 1; tIdx <= tNum; tIdx++) {

			// 각 케이스의 숫자들로 배열 구성
			// 최대값 저장.
			int caseLen = sc.nextInt();
			int[] caseArr = new int[caseLen];
			int maxNum = 0;
			for (int cIdx = 0; cIdx < caseLen; cIdx++) {
				caseArr[cIdx] = sc.nextInt();
				if (maxNum < caseArr[cIdx]) {
					maxNum = caseArr[cIdx];
				}
			}

			// count배열 생성
			// idx = 0,1,2....,maxNum
			int[] count = new int[maxNum + 1];
			for (int cIdx = 0; cIdx < caseLen; cIdx++) {
				count[caseArr[cIdx]]++;
			}
			// count배열 누적
			for (int coIdx = 1; coIdx <= maxNum; coIdx++) {
				count[coIdx] = count[coIdx] + count[coIdx - 1];
			}

			// caseArr -> newCaseArr
			int[] newCaseArr = new int[caseLen];
			for (int cIdx = caseLen - 1; cIdx >= 0; cIdx--) {
				int valueToMove = caseArr[cIdx];
				// *오답노트 :
				// 한줄로 된걸 나눠서 하다보니 destinationIdx
				// 를 계산하고 count[valueToMove]--;를 빼먹고
				// 하여 에러발생
				count[valueToMove]--;
				int destinationIdx = count[valueToMove];
				newCaseArr[destinationIdx] = valueToMove;
			}
			
			System.out.printf("#%d ", tIdx);
			for (int printIdx = 0; printIdx < caseLen; printIdx++) {
				System.out.printf("%d ", newCaseArr[printIdx]);
			}
			System.out.println();
		}
	}
}
//End