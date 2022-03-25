package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BOJ_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N 받기
		int N = Integer.parseInt(br.readLine());
		String[] inArr = br.readLine().split(" ");
		int[] nArr = new int[N];
		for (int nc = 0; nc < N; nc++) {
			nArr[nc] = Integer.parseInt(inArr[nc]);
		}
		// N 오름차순 정렬
		Arrays.sort(nArr);

		// M 받기
		int M = Integer.parseInt(br.readLine());
		inArr = br.readLine().split(" ");
		int[] mArr = new int[M];
		for (int mc = 0; mc < M; mc++) {
			mArr[mc] = Integer.parseInt(inArr[mc]);
		}
		
		// 검색 전적
		Map<Integer,Integer> record = new HashMap<Integer,Integer>();
		for (int mIdx = 0; mIdx < M; mIdx++) {
			// 전적 검색
			if( record.containsKey(mArr[mIdx])) {
				bw.write(record.get(mArr[mIdx]) + " ");
				continue;
			}
			// 검색 시작
			int maxIdx = nArr.length - 1;
			int minIdx = 0;
			int midIdx = (maxIdx + minIdx) / 2;
			boolean iGotIt = false;
			while (minIdx <= maxIdx) {
				// 이진 탐색 - 목표 숫자가 여러개일 경우 목표 숫자 중 하나에 착지
				if (nArr[midIdx] == mArr[mIdx]) {
					iGotIt = true;
					break;
				} else if (nArr[midIdx] < mArr[mIdx]) {
					minIdx = midIdx + 1;
				} else {
					maxIdx = midIdx - 1;
				}
				midIdx = (maxIdx + minIdx) / 2;
			}

			int numOfTarget = 0;
			// 목표 숫자를 포착했으면
			if (iGotIt) {
				// 처음 포착한 목표 숫자 선반영
				int cnt = 1;
				int delta = 1;
				boolean flag = true;
				// 주변 스캔
				while (flag) {
					flag = false;
					if (midIdx + delta <= N - 1 && nArr[midIdx + delta] == mArr[mIdx]) {
						flag = true;
						cnt++;
					}
					if (midIdx - delta >= 0 && nArr[midIdx - delta] == mArr[mIdx]) {
						flag = true;
						cnt++;
					}
					delta++;
				}
				numOfTarget = cnt;
				// 목표 숫자를 포착 못했으면
			} else {
				numOfTarget = 0;
			}
			record.put(mArr[mIdx], numOfTarget);
			bw.write(numOfTarget + " ");
		}
		bw.flush();
		bw.close();
	}
}
// End
