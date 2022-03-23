package com.ssafy.codeup;

import java.util.Scanner;

public class Codeup_1098_설탕과자뽑기 {

	public static void main(String[] args) {

		// 값 얻기
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] baduk = new int[h][w];
		int num = sc.nextInt();

		// 1 채우기
		for (int exe = 0; exe < num; exe++) {
			int l = sc.nextInt();
			int d = sc.nextInt();
			int y = sc.nextInt() - 1;
			int x = sc.nextInt() - 1;
			if (d == 0) {
				for (int xts = 0; xts < l; xts++) {
					baduk[y][x + xts] = 1;
				}
			} else {
				for (int xts = 0; xts < l; xts++) {
					baduk[y + xts][x] = 1;
				}
			}

		}

		// 출력
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.printf("%d ", baduk[i][j]);
			}
			System.out.println("");
		}

	}
}
// End