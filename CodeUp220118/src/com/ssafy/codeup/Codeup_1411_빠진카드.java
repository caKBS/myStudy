package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1411_빠진카드 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		// 배열을 0으로 초기화
		int[] card = new int[num + 1];
		for (int i = 1; i < num + 1; i++) {
			card[i] = 0;
		}

		// 입력값에 해당하는 인덱스에 1을 저장
		for (int i = 1; i < num; i++) {
			int input = sc.nextInt();
			card[input] = 1;
		}

		// 선택되지 못하고 0으로 남은 데이터의 인덱스 출력
		for (int i = 1; i < num + 1; i++) {
			if (card[i] == 0) {
				System.out.printf("%d ", i);
			}

		}

	}
}
// End