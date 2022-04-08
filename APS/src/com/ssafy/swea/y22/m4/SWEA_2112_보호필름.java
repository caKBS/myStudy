package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SWEA_2112_보호필름 {
	// film에서 A가 0이면 chemical에서도 A를 0으로 맞춰줘야 함.
	public static int doA = 0;
	public static int doB = 1;
	public static int keep = 2;
	public static int D;
	public static int W;
	public static int K;
	public static int[][] film;
	public static int[] chemical;
	public static int minVal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			String[] data = br.readLine().split(" ");
			D = Integer.parseInt(data[0]);
			W = Integer.parseInt(data[1]);
			K = Integer.parseInt(data[2]);
			film = new int[D][W];
			chemical = new int[D];
			// 입력받기
			for (int d = 0; d < D; d++) {
				String[] aline = br.readLine().split(" ");
				for (int w = 0; w < W; w++) {
					film[d][w] = Integer.parseInt(aline[w]);
				}
			}
			// 최소투입횟수 초기화
			minVal = D + 1;
			// 부분집합 생성 및 테스트
			subset(0);
			// 출력
			bw.write("#" + tc + " " + minVal + "\n");
			bw.flush();
		}
	}

	public static boolean test() {
		for (int w = 0; w < W; w++) {
			int serialCnt = 0;
			int running = -1;
			for (int d = 0; d < D; d++) {
				// 약품 안넣은 D는 보호필름값을 따르고
				if (chemical[d] == keep) {
					// 연속값이 해당값과 다르면 연속값을 업데이트하고 카운트를 초기화
					if (running != film[d][w]) {
						running = film[d][w];
						serialCnt = 1;
						// 연속값이 해당값과 다르면 카운트+1
					} else {
						serialCnt++;
					}
					// 약품 넣은 D는 화학약품값을 따른다.
				} else {
					// 연속값이 해당값과 다르면 연속값을 업데이트하고 카운트를 초기화
					if (running != chemical[d]) {
						running = chemical[d];
						serialCnt = 1;
						// 연속값이 해당값과 다르면 카운트+1
					} else {
						serialCnt++;
					}
				}
				// 연속 3개가 확보되면 다음 W 확인
				if (serialCnt >= K) {
					break;
				}
			}
			// 연속 3개가 안되면 이번판은 나가리이고 연속 3개가 되면 다음 for문으로
			if (serialCnt < K) {
				return false;
			}

		}
		// for문을 다 통과했으면 합격
		return true;
	}

	public static void subset(int idxChem) {
		if (idxChem == D) {
			// 3차 부분집합 생성 완료
			if (test()) {
				// 약품투입 몇개 했냐
				int cnt = 0;
				for (int d = 0; d < D; d++) {
					if (chemical[d] != keep) {
						cnt++;
					}
				}
				if (cnt < minVal) {
					minVal = cnt;
				}
			}
			return;

		}
		for (int doWhat = 0; doWhat <= 2; doWhat++) {
			chemical[idxChem] = doWhat;
			subset(idxChem + 1);
		}
	}
}
//End