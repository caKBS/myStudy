package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		int[] dir = new int[6];
		int[] len = new int[6];
		for (int i = 0; i < 6; i++) {
			String inNum = br.readLine();
			String[] Arr = inNum.split(" ");
			dir[i] = Integer.parseInt(Arr[0]);
			len[i] = Integer.parseInt(Arr[1]);
		}
		int area;
		// ABAB 패턴 찾기
		int A1;
		int B1;
		int A2;
		int B2;
		int idx = 0;
		while (true) {
			A1 = idx % 6;
			B1 = (idx + 1) % 6;
			A2 = (idx + 2) % 6;
			B2 = (idx + 3) % 6;
			// ABAB 패턴을 찾으면 B1,A2가 내부 사각형을 나타내고
			// A1,B1,A2,B2 이외의 두 변이 외부 사각형을 나타낸다.
			if (dir[A1] == dir[A2] && dir[B1] == dir[B2]) {
				area = len[(idx + 4) % 6] * len[(idx + 5) % 6] - len[B1] * len[A2];
				break;
			} else {
				idx++;
			}
		}
		// 출력
		bw.write(K * area + "\n");
		bw.flush();
		bw.close();
	}
}
// End
