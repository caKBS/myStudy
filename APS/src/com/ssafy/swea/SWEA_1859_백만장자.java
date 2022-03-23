package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1859_백만장자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// 실행시간이 너무 기니까 실행시간 줄일 수
		// 있는 코드 찾아 공부하자ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
		
		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {
			int N = sc.nextInt();
			int[] cost = new int[N];
			int lastIdx = N - 1;
			int maxCost = 0;
			int maxIdx = 0;
			// 입력받으면서 최대값과 최대값의 인덱스 저장
			for (int nIdx = 0; nIdx < N; nIdx++) {
				cost[nIdx] = sc.nextInt();
				if (cost[nIdx] > maxCost) {
					maxCost = cost[nIdx];
					maxIdx = nIdx;
				}
			}
			// 매도전 총매수가격
			long buy = 0;
			// 매도전 총매수개수
			long stock = 0;
			long profit = 0;
			int prevMaxIdxP1 = 0;
			do {
				// 이전맥스 다음부터 현재 맥스까지 buy
				for (int nIdx = prevMaxIdxP1; nIdx < maxIdx; nIdx++) {
					buy += cost[nIdx];
					stock++;
				}
				// 매수가와 매도가로 이득계산
				profit += cost[maxIdx] * stock - buy;
				//매도 후 매수정보제거
				buy=0;
				stock=0;
				// 현재 맥스 이후 원소들의 최대 구하기
				prevMaxIdxP1 = maxIdx + 1;
				maxCost = 0;
				maxIdx = 0;
				for (int nIdx = prevMaxIdxP1; nIdx < N; nIdx++) {
					if (cost[nIdx] > maxCost) {
						maxCost = cost[nIdx];
						maxIdx = nIdx;
					}
				}
			} while (prevMaxIdxP1 != lastIdx+1);
			
			System.out.printf("#%d %d\n", tIdx, profit);
		}
	}
}
//End