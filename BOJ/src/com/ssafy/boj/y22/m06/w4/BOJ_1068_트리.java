package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1068_트리 {

	public static StringBuilder sb;
	public static int N;
	public static int cnt;
	public static List<Integer>[] chd;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		N = Integer.parseInt(br.readLine());
		chd = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			chd[i] = new ArrayList<>();
		}

		String[] aline = br.readLine().split(" ");
		int root = -1;
		for (int child = 0; child < N; child++) {
			int p = Integer.parseInt(aline[child]);
			if (p != -1) {
				chd[p].add(child);
			} else {
				root = child;
			}
		}

		// 결과 초기화
		cnt = 0;

		int killer = Integer.parseInt(br.readLine());
		boolean[] dead = new boolean[N];
		deleteDFS(killer, dead);
		if (!dead[root]) {
			cntDFS(root, dead);
		}

		System.out.println(cnt);

	}

	public static void deleteDFS(int curr, boolean[] dead) {
		dead[curr] = true;

		for (int i = 0; i < chd[curr].size(); i++) {
			int child = chd[curr].get(i);
			deleteDFS(child, dead);
		}
	}

	public static void cntDFS(int curr, boolean[] dead) {

		boolean flag = false;
		for (int i = 0; i < chd[curr].size(); i++) {
			int child = chd[curr].get(i);
			if (!dead[child]) {
				flag = true;
				cntDFS(child, dead);
			}
		}

		if (!flag) {
			cnt++;
		}
	}

}
//End