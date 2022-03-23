package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1096_바둑판흰돌 {

	public static void main(String[] args) {

		//입력받기 및 0으로 초기화
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] baduk = new int[19][19];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				baduk[i][j] = 0;
			}
		}

		// 해당 인덱스값 변경
		for (int i = 0; i < num; i++) {
			int indexX = sc.nextInt();
			int indexY = sc.nextInt();
			baduk[indexX-1][indexY-1] = 1;
		}

		// 출력
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				System.out.printf("%d ", baduk[i][j]);
			}
			System.out.println("");
		}

	}
}
// End