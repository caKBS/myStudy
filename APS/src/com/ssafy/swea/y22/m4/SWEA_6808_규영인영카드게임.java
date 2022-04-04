package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class SWEA_6808_규영인영카드게임 {
	public static int cardN = 9;
	public static int[] kyuY;
	public static List<Integer> inY;
	public static boolean[] check;
	public static int[] result;
	public static int kyuWin = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {

			String[] aLine = br.readLine().split(" ");
			// 규영이 카드 저장
			kyuY = new int[cardN];
			// 규영이가 무슨 카드를 갖고 있나, 규영이 카드 숫자를 인덱스로 하는 배열
			boolean[] kyuCard = new boolean[19];
			for (int inIdx = 0; inIdx < cardN; inIdx++) {
				kyuY[inIdx] = Integer.parseInt(aLine[inIdx]);
				kyuCard[kyuY[inIdx]] = true;
			}

			// 인영이 카드 저장
			inY = new LinkedList<>();
			for (int dIdx = 1; dIdx <= 18; dIdx++) {
				if (kyuCard[dIdx] != true) {
					inY.add(dIdx);
				}
			}
			// check, result 배열
			check = new boolean[cardN];
			result = new int[cardN];
			// 규영이 승리횟수 초기화
			kyuWin = 0;

			// 순열 생성
			perm(0);

			// 출력
			bw.write("#" + tc + " " + kyuWin + " " + (362880 - kyuWin) + "\n");
			bw.flush();
		}
	}

	public static void perm(int idx) {
		if (idx == cardN) {
			int kyuPnt = 0;
			int inPnt = 0;
			// 아홉 라운드 진행
			for (int rnd = 0; rnd < cardN; rnd++) {
				// 규영 승
				if (kyuY[rnd] > result[rnd]) {
					kyuPnt += kyuY[rnd] + result[rnd];
				} else if (kyuY[rnd] < result[rnd]) {
					inPnt += kyuY[rnd] + result[rnd];
				}
			}
			if (kyuPnt > inPnt) {
				kyuWin++;
			}
			return;
		} else {
			for (int i = 0; i < cardN; i++) {
				if (check[i]) {
					continue;
				}
				result[idx] = inY.get(i);
				check[i] = true;
				perm(idx + 1);
				check[i] = false;
			}
		}
	}
}
//End