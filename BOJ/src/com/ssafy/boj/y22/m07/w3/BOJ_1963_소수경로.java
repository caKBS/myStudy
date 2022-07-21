package com.ssafy.boj.y22.m07.w3;

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

public class BOJ_1963_소수경로 {

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] aline = br.readLine().split(" ");
			int st = Integer.parseInt(aline[0]);
			int ed = Integer.parseInt(aline[1]);

			// 에라토스테네스
			boolean[] notPrime = new boolean[10100];
			notPrime[0] = notPrime[1] = true;
			for (int i = 2; i <= 9999; i++) {
				if (!notPrime[i]) {
					for (int j = i * 2; j <= 9999; j += i) {
						notPrime[j] = true;
					}
				}
			}


			// BFS
			Queue<Integer> Q = new LinkedList<>();
			boolean[] check = new boolean[10100];
			Q.add(st);

			int cnt=0;
			boolean flag = false;
			BFS : while (!Q.isEmpty()) {
				
				int cycle = Q.size();
				for (int c = 0; c < cycle; c++) {
					int curr = Q.poll();

					if (curr == ed) {
						flag = true;
						break BFS;
					}

					// 바꿀 자리수 선정
					for (int i = 3; i >= 0; i--) {
						int[] currArr = toIntArray(curr);
						// 바꿀 수 선정
						for (int alter = 0; alter <= 9; alter++) {
							if (i == 0 && alter == 0) {
								continue;
							}
							currArr[i] = alter;
							int nxt = toInt(currArr);
							if (!check[nxt] && !notPrime[nxt]) {
								Q.add(nxt);
								check[nxt] = true;
							}
						}

					}
				}
				cnt++;
			}
			
			// 출력
			if(flag) {
				sb.append(cnt+"\n");
			}else {
				sb.append("Impossible\n");
			}
		}
		System.out.print(sb);
	}

	// 숫자를 각 자리수로 쪼갠 배열로
	public static int[] toIntArray(int num) {
		int[] Arr = new int[4];
		for (int i = 3; i >= 0; i--) {
			Arr[i] = num % 10;
			num/=10;
		}
		return Arr;
	}

	// 한자리 숫자 배열을 하나의 숫자로
	public static int toInt(int[] num) {
		int sum = 0;
		for (int i = 3; i >= 0; i--) {
			sum += num[i] * Math.pow(10, 3 - i);
		}
		return sum;
	}

}
//End