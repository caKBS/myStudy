package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			// 몇번째 case인지 -> 불필요
			int caseNum = sc.nextInt();
			// 인데스를 점수로 활용하는 배열, idx : 0~100
			int[] scoreBoard = new int[101];
			// 학생 1000명의 점수 받기
			for (int student = 1; student <= 1000; student++) {
				int newScore = sc.nextInt();
				scoreBoard[newScore]++;
			}

			// 가장 큰 값(문제에서의 빈도)과 그 인덱스를 저장
			int maxScoreNum = 0;
			int ScoreW_MaxNum = 0;
			for (int score = 0; score <= 100; score++) {
				// if문안에 equal을 통해 기존 최대와 같은 값이 나와도
				// max를 업데이트할 수 있게 하여
				// 최빈수가 여러 개 일 때에 가장 큰 점수가 마지막에 남도록 한다.
				if (maxScoreNum <= scoreBoard[score]) {
					maxScoreNum = scoreBoard[score];
					ScoreW_MaxNum = score;
				}
			}
			System.out.printf("#%d %d\n", tIdx, ScoreW_MaxNum);
		}
	}
}
//End