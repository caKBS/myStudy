package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_3499_퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int N = sc.nextInt();
			// 홀수일경우 앞선 카드 세트(card1)가 1장 더 많도록
			int halfN = (N + 1) / 2;
			// 두개의 카드 세트에 나눠 담는다.
			String[] card1 = new String[halfN];
			String[] card2 = new String[N - halfN];
			for (int nIdx = 0; nIdx < N; nIdx++) {
				if (nIdx < halfN) {
					card1[nIdx] = sc.next();
				} else {
					card2[nIdx - halfN] = sc.next();
				}
			}

			System.out.printf("#%d", tIdx);
			// 두개의 카드세트를 각각 앞에서 부터 출력
			for (int pIdx = 0; pIdx < halfN; pIdx++) {
				System.out.print(" " + card1[pIdx]);
				// 카드수가 홀수이면 마지막 iteration에서
				// card1만 출려되야하므로 card2는 출력 안되도록
				if (card2.length - 1 >= pIdx) {
					System.out.print(" " + card2[pIdx]);
				}
			}
			System.out.println();
		}
	}
}
//End