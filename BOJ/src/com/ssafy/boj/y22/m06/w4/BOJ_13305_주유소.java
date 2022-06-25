package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13305_주유소 {

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		String[] aline = br.readLine().split(" ");
		String[] bline = br.readLine().split(" ");
		int[] road = new int[N - 1];
		int[] station = new int[N];
		for (int i = 0; i < N - 1; i++) {
			road[i] = Integer.parseInt(aline[i]);
		}
		for (int i = 0; i < N; i++) {
			station[i] = Integer.parseInt(bline[i]);
		}

		int idx = 1;
		long curPrice = station[0];
		long curKm = road[0];
		long sum = 0;
		while (idx < N) {
			// 마지막 주유소를 만나면 그동안 쌓인 거 모두 계산하고 끝내기
			if (idx == N - 1) {
				sum += curPrice * curKm;
			// 현재 가격보다 낮은 가격의 주유소를 만날때 갱신
			// A>B일대 A~B까지만 A가격으로 하고 B이후는 B가격으로 한다.
			} else if (station[idx] < curPrice) {
				// 그동안 모아놓은 거 계산
				sum += curPrice * curKm;
				// 가격 바꾸기
				curPrice = station[idx];
				// 거리 모아두기
				curKm = road[idx];
			// 현재 가격보다 낮은 가격의 주유소를 만날때 까지 거리 모아두기
			} else {
				curKm += road[idx];
			}
			idx++;
		}

		System.out.println(sum);

	}

}
//End