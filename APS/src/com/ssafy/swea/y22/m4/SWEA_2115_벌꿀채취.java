package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SWEA_2115_벌꿀채취 {
	public static int N;
	public static int M;
	public static int C;
	public static int[] setMoney = new int[2];
	public static int[][] board;
	public static int[][] set;
	public static int maxMoney;
	public static int mm0;
	public static int mm1;
	public static int edr0;
	public static int edc0;
	public static int r1;
	public static int c1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		C = Integer.parseInt(data[2]);
		board = new int[N][N];
		// set0와 set1
		set = new int[2][M];

		// 입력받기
		for (int r = 0; r < N; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
			}
		}

		// 최대 수익 초기화
		maxMoney = 0;
		// 세트 0 선정
		for (int r = 0; r < N; r++) {
			// 사이즈 M을 고려해 갈 수 있는 곳 까지
			for (int c = 0; c < N - M + 1; c++) {
				// set0 값 정하기
				for (int i = c; i < c + M; i++) {
					set[0][i - c] = board[r][i];
				}
				// set1 값 정하기
				selectSet1(r, c + M - 1);
			}
		}
			// 출력
			bw.write("#" + tc + " " + maxMoney + "\n");
			bw.flush();
		}
	}

	// 하나의 set0에 대한 set1의 경우들이 얻는다
	public static void selectSet1(int edR, int edC) {
		// 세트 1 선정
		for (int r = 0; r < N; r++) {
			// 사이즈 M을 고려해 갈 수 있는 곳 까지
			for (int c = 0; c < N - M + 1; c++) {
				// set0 초과일때만(r은 더 크고 c는 더 작은 경우도 처리될 수 있게끔
				// 범위 설정 잘 해줘야 한다.)
				if ((r == edR && c > edC) || (r > edR)) {
					// set1 값 정하기
					for (int i = c; i < c + M; i++) {
						set[1][i - c] = board[r][i];
					}
					// set1 생성완료
					// 최대 수익 초기화
					setMoney[0] = 0;
					setMoney[1] = 0;

					// 최대 수익의 조합 찾기
					// set0의 최대 수익 조합
					powerSet(0, 0, 0, 0);
					// set1의 최대 수익 조합
					powerSet(1, 0, 0, 0);
					// 최대 수익 갱신
					maxMoney = Math.max(maxMoney, setMoney[0] + setMoney[1]);

					// 계속 오류났던 이유 : 
					// 여기에 return을 써서 for문이 안돌았음...
					// 원인 :
					// 조합 알고리즘 구현 연습 부족
				}
			}
		}
	}

	public static void powerSet(int setN, int idx, int sum, int money) {

		if (sum > C) {
			return;
		}
		if (idx == M) {
			setMoney[setN] = Math.max(setMoney[setN], money);
			return;
		}
		// M에 도달하지 않았을때 최대를 얻을 수도 있지 않을까? C라는 제한에 의해
		// 이미 money는 최대인데 sum을 더 더했다가 컷 당할 수도 있으니까.
		// -> 어차피 모든 경우의 수를 다 해보니 불필요하다!!
		

		// set의 해당 idx를 선택
		powerSet(setN, idx + 1, sum + set[setN][idx], money + set[setN][idx] * set[setN][idx]);
		// set의 해당 idx를 선택X
		powerSet(setN, idx + 1, sum, money);
	}
}
//End