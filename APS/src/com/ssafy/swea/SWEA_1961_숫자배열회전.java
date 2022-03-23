package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int N = sc.nextInt();
			// 입력받은 행렬 저장용
			int[][] matrix = new int[N][N];
			// 출력할 행렬 저장용
			int[][] newMatrix = new int[N][3];
			// 입력을 90도 뒤집으며 받기
			for (int rIdx = 0; rIdx <= N - 1; rIdx++) {
				for (int cIdx = 0; cIdx <= N - 1; cIdx++) {
					matrix[cIdx][N - 1 - rIdx] = sc.nextInt();
				}
			}
			// deg90 - 0 : 90도 회전, 1 : 180도 회전, 2 : 270도 회전
			int deg90 = 0;
			// matrix의 각 행을 가장 오른쪽 열부터 자릿수에 맞춰 누적.
			for (int rIdx = 0; rIdx <= N - 1; rIdx++) {
				int set = 0;
				for (int digit = 0; digit <= N - 1; digit++) {
					set += matrix[rIdx][N - 1 - digit] * Math.pow(10, digit);
				}
				// 누적한 값을 newMatrix의 해당 열에 넣기
				newMatrix[rIdx][deg90] = set;
			}

			// 180도 회전일때
			deg90++;
			int[][] matrix180 = new int[N][N];
			for (int rIdx = 0; rIdx <= N - 1; rIdx++) {
				for (int cIdx = 0; cIdx <= N - 1; cIdx++) {
					matrix180[cIdx][N - 1 - rIdx] = matrix[rIdx][cIdx];
				}
			}
			for (int rIdx = 0; rIdx <= N - 1; rIdx++) {
				int set = 0;
				for (int digit = 0; digit <= N - 1; digit++) {
					set += matrix180[rIdx][N - 1 - digit] * Math.pow(10, digit);
				}
				// 누적한 값을 newMatrix의 해당 열에 넣기
				newMatrix[rIdx][deg90] = set;
			}

			// 270도 회전일때
			deg90++;
			int[][] matrix270 = new int[N][N];
			for (int rIdx = 0; rIdx <= N - 1; rIdx++) {
				for (int cIdx = 0; cIdx <= N - 1; cIdx++) {
					matrix270[cIdx][N - 1 - rIdx] = matrix180[rIdx][cIdx];
				}
			}
			for (int rIdx = 0; rIdx <= N - 1; rIdx++) {
				int set = 0;
				for (int digit = 0; digit <= N - 1; digit++) {
					set += matrix270[rIdx][N - 1 - digit] * Math.pow(10, digit);
				}
				// 누적한 값을 newMatrix의 해당 열에 넣기
				newMatrix[rIdx][deg90] = set;
			}

			System.out.printf("#%d\n", tIdx);
			for (int i = 0; i <= N - 1; i++) {
				for (int j = 0; j <= 3 - 1; j++) {
					// 숫자의 가장 앞 자리수가 0이면
					// 따로 표시해준다.
					if (newMatrix[i][j] < Math.pow(10, N - 1)) {
						System.out.print(0);
					}
					System.out.printf("%d ", newMatrix[i][j]);
				}
				System.out.println();
			}
		}
	}
}
//End