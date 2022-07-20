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

public class BOJ_1389_케빈베이컨6단계 {

	public static StringBuilder sb;
	public static int N;
	public static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		List<Integer>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] aline = br.readLine().split(" ");
			int st = Integer.parseInt(aline[0]);
			int ed = Integer.parseInt(aline[1]);
			adj[st].add(ed);
			adj[ed].add(st);
		}

		int minVal = Integer.MAX_VALUE;
		int minUser = -1;
		// 시작점
		for (int st = 1; st <= N; st++) {
			int bacon = BFS(st,adj);
			if( bacon < minVal) {
				minVal = bacon;
				minUser = st;
			}
		}
		
		// 출력
		System.out.println(minUser);

	}

	// 거리 계산 방식
	// 사용한 것 : 다음 노드를 Q에 추가할때 다음 노드에 대한 거리를 sum에 반영
	// 다른 방법 : 특정 노드를 Q에서 꺼냈을때 특정 노드에 대한 거리를 sum에 반영
	public static int BFS(int st, List<Integer>[] adj) {

		int sum = 0;
		int len = 1;
		Queue<Integer> Q = new LinkedList<>();
		boolean[] check = new boolean[N + 1];
		Q.add(st);
		check[st] = true;

		while (!Q.isEmpty()) {
			// 지금 Q에 있는 것 다 비울때까지 지켜보기
			int size = Q.size();
			for (int s = 0; s < size; s++) {
				int curr = Q.poll();

				for (int i = 0; i < adj[curr].size(); i++) {
					int target = adj[curr].get(i);
					if (!check[target]) {
						Q.add(target);
						check[target] = true;
						sum+=len;
					}
				}
			}
			// 층 하나를 다 비우고 다음 층으로 넘어가니 거리 하나 업
			len++;
		}
		
		return sum;

	}

}
//End