package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2108_통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Integer[] numList = new Integer[N];
		// 빈도수 측정, idx4000 = 0, idx0 = -4000, idx8000 = 4000
		int[] freq = new int[8010];
		double sumVal = 0;
		for (int nc = 0; nc < N; nc++) {
			numList[nc] = Integer.parseInt(br.readLine());
			sumVal += numList[nc];
			freq[numList[nc] + 4000]++;
		}
		// 산술평균
		// 양수의 반올림이 더 +한쪽으로 가는 방향이라면
		// 음수의 반올림은 더 -한쪽으로 가는 방향이다.
		if (sumVal >= 0) {
			bw.write((int) (sumVal / N + 0.5) + "\n");
		} else {
			bw.write((int) (sumVal / N - 0.5) + "\n");
		}

		// 중앙값
		Arrays.sort(numList);
		bw.write(numList[N / 2] + "\n");

		// 최빈값 수정
		// 최빈값의 빈도수 찾기
		int maxFreq = 0;
		for (int fc = 0; fc <= 8000; fc++) {
			if (freq[fc] > maxFreq) {
				maxFreq = freq[fc];
			}
		}
		// 최빈값 집합
		// fc를 0부터 스캔하면서 넣으니
		// maxList는 오름차순 정렬되어있다.
		int mode = -4001;
		int[] maxList = new int[N];
		int mLidx = 0;
	    int cnt=0;
		for (int fc = 0; fc <= 8000; fc++) {
			if (freq[fc] == maxFreq) {
				maxList[mLidx] = fc;
				cnt++;
				if (mLidx < N) {
					mLidx++;
				}
			}
		}

		// 최빈값이 여러 개
		if (cnt >= 2) {
			mode = maxList[1] - 4000;
			// 최빈값이 하나
		} else {
			mode = maxList[0] - 4000;
		}
		// 최빈값
		bw.write(mode + "\n");

		// 범위
		// 위에서 오름차순 정렬함
		bw.write((numList[N - 1] - numList[0]) + "\n");
		
		// 출력
		bw.flush();
		bw.close();
	}

}
// End
