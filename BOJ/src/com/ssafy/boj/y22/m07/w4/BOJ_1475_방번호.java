package com.ssafy.boj.y22.m07.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1475_방번호 {

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		char[] num = br.readLine().toCharArray();
		double[] freq = new double[10];
		for (int i = 0; i < num.length; i++) {
			freq[num[i] - '0']++;
		}

		// 9를 6에 편입
		freq[6] += freq[9];
		freq[9] = 0;

		double maxVal = -1;
		for (int i = 0; i < freq.length; i++) {
			if (i == 6) {
				maxVal = Math.max(maxVal, Math.round(freq[i] / 2));
			} else {
				maxVal = Math.max(maxVal, freq[i]);
			}
		}
		
		
		System.out.println((int)maxVal);

	}

}
//End