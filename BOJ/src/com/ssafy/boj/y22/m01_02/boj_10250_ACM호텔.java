package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_10250_ACM호텔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tIdx = 1; tIdx <= T; tIdx++) {
			String inNum = br.readLine();
			String[] Arr = inNum.split(" ");

			int H = Integer.parseInt(Arr[0]);
			int W = Integer.parseInt(Arr[1]);
			int N = Integer.parseInt(Arr[2]);
			int floor = 0;
			int ho = 0;
			int total = 0;

			floor = N % H;
			ho = N / H + 1;
			//꼭대기층에 대한 특별처리
			if (floor == 0) {
				floor = H;
				ho--;
			}
			
			total = floor * 100 + ho;

			// 출력
			bw.write(total + "\n");
			bw.flush();
		}
		bw.close();
	}
}
// End
