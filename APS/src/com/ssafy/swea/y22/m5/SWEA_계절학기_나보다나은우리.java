package com.ssafy.swea.y22.m5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_계절학기_나보다나은우리 {
	public static int N;
	public static int len;
	public static int curH;
	public static String answer;
	public static String[] submit;
	public static boolean pos;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 50; tc++) {

			N = Integer.parseInt(br.readLine());
			// 정답
			answer = br.readLine();
			// 문제 개수
			len = answer.length();
			// 학생 제출 답안
			submit = new String[N];
			for (int i = 0; i < N; i++) {
				submit[i] = br.readLine();
			}

			int minH = -1;
			pos = false;
			for (int h = 1; h <= N; h++) {
				curH = h;
				comb(0, 0, 0);
				if (pos) {
					minH = h;
					break;
				}
			}

			System.out.println(minH);
			br.readLine();
		}

	}

	public static void comb(int idx, int sidx, int done) {
		// 다 뽑았다.
		if (sidx == curH) {
			// 다 맞았을 경우
			if (done == ((1 << len) - 1)) {
				pos = true;
			}
			return;
		}

		// 조합
		for (int i = idx; i < N + 1 - (curH - sidx); i++) {
			int newDone = done;
			for (int j = 0; j < len; j++) {
				if (answer.charAt(j) == submit[i].charAt(j)) {
					newDone = newDone | (1 << j);
				}
			}
			comb(i + 1, sidx + 1, newDone);
			if (pos) {
				return;
			}
		}

	}

}
