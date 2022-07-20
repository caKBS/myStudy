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

public class BOJ_5014_스타트링크 {

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		String[] FSGUD = br.readLine().split(" ");
		int F = Integer.parseInt(FSGUD[0]);
		int S = Integer.parseInt(FSGUD[1]);
		int G = Integer.parseInt(FSGUD[2]);
		int U = Integer.parseInt(FSGUD[3]);
		int D = Integer.parseInt(FSGUD[4]);

		int[] d = { U, -1 * D };
		Queue<Integer> Q = new LinkedList<>();
		boolean[] check = new boolean[F + 1];
		Q.add(S);
		check[S] = true;
		boolean flag = false;

		int btn = 0;
		BFS : while (!Q.isEmpty()) {

			int cycle = Q.size();
			for (int c = 0; c < cycle; c++) {
				int curr = Q.poll();
				if (curr == G) {
					flag = true;
					break BFS;
				}

				for (int i = 0; i < 2; i++) {
					int next = curr + d[i];
					if (next >= 1 && next <= F && !check[next]) {
						Q.add(next);
						check[next] = true;
					}
				}
			}
			btn++;
		}
		
		// 출력
		if(flag) {
			System.out.println(btn);
		}else {
			System.out.println("use the stairs");
		}

	}
	


}
//End