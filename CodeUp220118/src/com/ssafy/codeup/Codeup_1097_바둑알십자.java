package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1097_바둑알십자 {

	public static void main(String[] args) {

		// 행렬 입력 받기
		Scanner sc = new Scanner(System.in);

		int[][] baduk = new int[19][19];
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				baduk[i][j] = sc.nextInt();
				;
			}
		}
        
		//십자뒤집기 횟수 받기
		int num = sc.nextInt();

		//십자 뒤집기 수행
		for (int i = 0; i < num; i++) {
			int indexY = sc.nextInt()-1;
			int indexX = sc.nextInt()-1;

			//동행에 대해 뒤집기
			for (int j = 0; j < 19; j++) {
				if (baduk[indexY][j] == 0) {
					baduk[indexY][j] = 1;
				} else {
					baduk[indexY][j] = 0;
				}
			}

			//동렬에 대해 뒤집기
			for (int j = 0; j < 19; j++) {
				if (baduk[j][indexX] == 0) {
					baduk[j][indexX] = 1;
				} else {
					baduk[j][indexX] = 0;
				}
			}
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