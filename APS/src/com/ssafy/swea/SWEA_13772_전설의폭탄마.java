package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_13772_전설의폭탄마 {
	static int[][] happyBoard;
	static int N;
	static int P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			N = sc.nextInt();
			P = sc.nextInt();
			happyBoard = new int[N][N];

			// 2차원 배열 만들기
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					happyBoard[row][col] = sc.nextInt();
				}
			}

			// 스캔
			int maxHappy = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					// 더하기 형태로 스캔, 엑스자 형태로 스캔
					int happy = Math.max(scanP(row,col),scanX(row,col));
					if(maxHappy < happy) {
						maxHappy = happy;
					}

				}
			}
			System.out.printf("#%d %d\n", tIdx, maxHappy);
		}
	}

	public static int scanP(int row, int col) {
		int rowSum=0;
		int colSum=0;
		// 기준 행렬에 대해 좌로 P부터, 우로 P까지 스캔
		for (int distance = -1*P; distance <= P ; distance++) {
			if(col+distance >=0 && col+distance <=N-1){
			rowSum += happyBoard[row][col+distance];
			}
		}
		// 기준 행렬에 대해 상로 P부터, 하로 P까지 스캔
		for (int distance = -1*P; distance <= P ; distance++) {
			if(row+distance >=0 && row+distance <=N-1){
			colSum += happyBoard[row+distance][col];
			}
		}
		// rowSum+colSum하면 기준점의 값이 2번들어가니 한번 빼준다.
		return rowSum+colSum-happyBoard[row][col];

	}

	public static int scanX(int row, int col) {
		int plus45Sum=0;
		int minus45Sum=0;
		
		// X자의 우상단 방향 직선 스캔
		for (int distance = -1*P; distance <= P ; distance++) {
			if(row+distance >=0 && row+distance <=N-1
					&& col-distance >=0 && col-distance <=N-1){
			plus45Sum += happyBoard[row+distance][col-distance];
			}
		}
		// X자의 우하단 방향 직선 스캔
		for (int distance = -1*P; distance <= P ; distance++) {
			if(row+distance >=0 && row+distance <=N-1
					&& col+distance >=0 && col+distance <=N-1){
			minus45Sum += happyBoard[row+distance][col+distance];
			}
		}
		return plus45Sum+minus45Sum-happyBoard[row][col];
	}
}
//End