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

public class BOJ_1967_트리의지름 {

	public static StringBuilder sb;
	public static List<node>[] adj;
	public static int n;
	public static int target;
	public static int result;

	public static class node {
		public int num;
		public int w;

		public node(int num, int w) {
			this.num = num;
			this.w = w;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			String[] aline = br.readLine().split(" ");
			int st = Integer.parseInt(aline[0]);
			int ed = Integer.parseInt(aline[1]);
			int w = Integer.parseInt(aline[2]);
			adj[st].add(new node(ed, w));
			adj[ed].add(new node(st, w));
		}

		// 결과 초기화
		result = -1;

		// 게임시작
		boolean[] check = new boolean[n + 1];

		dfs(1, 0, check);
		dfs(target, 0, check);

		// 출력
		System.out.println(result);

	}

	public static void dfs(int curr, int sum, boolean[] check) {
		check[curr] = true;

		boolean flag = false;
		for (int i = 0; i < adj[curr].size(); i++) {
			int next = adj[curr].get(i).num;
			int weight = adj[curr].get(i).w;
			if (!check[next]) {
				flag = true;
				dfs(next, sum + weight, check);
			}
		}

		if (!flag) {
			if (result < sum) {
				target = curr;
				result = sum;
			}
		}

		check[curr] = false;
	}

}
//End