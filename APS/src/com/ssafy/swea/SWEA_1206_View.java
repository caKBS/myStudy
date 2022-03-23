package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1206_View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 10개
		for (int tIdx = 1; tIdx <= 10; tIdx++) {
			
			// 각 테스트 케이스 배열 생성
			int caseLen = sc.nextInt() + 2 + 2;
			int[] caseArr = new int[caseLen];
			
			// caseArr == [0,0,~~~~,0,0];
			for (int cIdx = 2; cIdx < caseLen - 2; cIdx++) {
				caseArr[cIdx] = sc.nextInt();
			}
			
			// 첫 빌딩부터 쭉 스캔한다.
			// 해당 빌딩 인접 4개 빌딩에 대해 조사한다.
			// 해당빌딩보다 같거나 큰 빌딩이 있는가?
			// 없으면 해당 빌딩의 조망권 세대 수 ==
			// (본인 높이 - 인접 4개 빌딩중 최고층 빌딩높이)
			int view = 0;
			for (int cIdx = 2; cIdx < caseLen - 2; cIdx++) {
				if (!((caseArr[cIdx - 2] >= caseArr[cIdx]) || (caseArr[cIdx - 1] >= caseArr[cIdx])
						|| (caseArr[cIdx + 1] >= caseArr[cIdx]) || (caseArr[cIdx + 2] >= caseArr[cIdx]))) {

					int maxNeighbor = 0;
					int[] Neighbor = { -2, -1, 1, 2 };
					for (int distance : Neighbor) {
						if (maxNeighbor < caseArr[cIdx + distance]) {
							maxNeighbor = caseArr[cIdx + distance];
						}
					}
					view += caseArr[cIdx] - maxNeighbor;
				}
			}
			System.out.printf("#%d %d\n", tIdx, view);
		}
	}
}
//End