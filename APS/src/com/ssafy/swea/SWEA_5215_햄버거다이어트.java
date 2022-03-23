package com.ssafy.swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	static int N;
	static int L;
	static int[][] ingre;
	static boolean[] TF;
	// idx0에는 점수를, idx1에는 칼로리를 저장했다.
	static int scoreIdx = 0;
	static int calorieIdx = 1;
	static int maxSS = 0;

	// 재귀를 사용하여 모든 케이스를 확인
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {
			
			
			
			// 각 케이스마다 maxScoreSum 초기화 ㅁㅁㅁㅁㅁ
			// 티스토리에 주의 하라고 써놓기!!!!!!!!!!!!!!
			maxSS=0;
			
			
			
			
			N = sc.nextInt();
			L = sc.nextInt();
			// 2차열 배열을 이용해 각 idx에 점수와 칼로리, 2개의 정보를 저장하도록함.
			ingre = new int[N][2];
			TF = new boolean[N];

			for (int iIdx = 0; iIdx < N; iIdx++) {
				ingre[iIdx][scoreIdx] = sc.nextInt();
				ingre[iIdx][calorieIdx] = sc.nextInt();
			}
			// 시작은 dept==0, score==0, calorie==0
			allCase(0, 0, 0);
			System.out.printf("#%d %d\n", tIdx, maxSS);
		}
	}

	public static void allCase(int dept, int score, int calorie) {
		// 칼로리가 제한을 넘으면 바로 그 케이스는 종료되고 아무 영향도 미치지 않는다.
		if (calorie > L) {
			return;
		}
		// 끝까지와서 점수 합친 score가 기존 maxScoreSum보다 크면 갱신.
		else if (dept == N) {
			if (maxSS < score) {
				maxSS = score;
			}
			return;
		}
		// score와 calorie가 재귀하면서 누적되게 끔.
		TF[dept] = false;
		allCase(dept + 1, score, calorie);
		TF[dept] = true;
		allCase(dept + 1, score + ingre[dept][scoreIdx], calorie + ingre[dept][calorieIdx]);
		return;
	}
}
//End