package com.ssafy.boj.y22.m03.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class boj_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String inNum = br.readLine();
		String[] Arr = inNum.split(" ");
		int[] Pi = new int[N];
		for (int i = 0; i < N; i++) {
			Pi[i] = Integer.parseInt(Arr[i]);
		}

		// i번째사람의 시간(Pi)은 총합에 i번 작용한다.
		// 고로 i*Pi의 총합이 결과이다.
		// 이것을 최소화하기 위해선 큰 시간(P)가 작은 i에 있어야 한다.
		// 내림차순 정렬
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int idx = 0; idx < N - 1; idx++) {
				if (Pi[idx] < Pi[idx + 1]) {
					flag = true;
					int tmp = Pi[idx];
					Pi[idx] = Pi[idx + 1];
					Pi[idx + 1] = tmp;
				}
			}
		}

		
		// ((본인idx+1)*본인값)의 합이 결과.
		int result = 0;
		for (int idx = 0; idx < N; idx++) {
			result +=(idx+1)*Pi[idx];
		}
		// 출력
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}
// End
