package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_7465_창용마을무리개수 {
	public static int[] p;
	public static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			p = new int[N + 1];
			rank = new int[N + 1];

			// P배열 초기화
			for (int n = 1; n <= N; n++) {
				makeSet(n);
			}

			// edge 받기 및 union
			for (int m = 1; m <= M; m++) {
				String[] edge = br.readLine().split(" ");
				int e1 = Integer.parseInt(edge[0]);
				int e2 = Integer.parseInt(edge[1]);
				union(e1,e2);
			}
			
			// 대표자 수 세시
		    int repCnt = 0;
		    for (int n = 1; n <= N; n++) {
		    	// 부모가 나이면 나는 대표자
		    	if(p[n]==n) {
		    		repCnt++;
		    	}
		    }

			// 출력
			bw.write("#" + tc + " " + repCnt + "\n");
			bw.flush();
		}
	}

	public static void makeSet(int x) {
		p[x] = x;
		rank[x] = 0;
	}

	public static int findSet(int x) {
		// 아직 대표값에 도달하지 않았으면 더 가야지
		if (x != p[x]) {
			// 리턴값은 부모값을 대표값으로 변경하는데 사용한다.
			p[x] = findSet(p[x]);
		}
		// 대표값에서는 x==p[x]이므로 이곳에서 둘(x,p[x]) 중에 뭐를 리턴하든 상관없지만
		// 대표값의 자손들에서는 부모값을 대표값으로 변경한 후 대표값을 계속
		// 자손에게 물려줘야 하므로 이곳에서 무조건 p[x]를 리턴해야 함.
		return p[x];
	}
	
	public static void union(int x, int y) {
		int repX = findSet(x);
		int repY = findSet(y);
		if(rank[repX] > rank[repY]) {
			p[repY] = repX;
		}else {
			p[repX] = repY;
			if(rank[repX] == rank[repY]) {
				rank[repY]++;
			}
		}
	}
}
//End