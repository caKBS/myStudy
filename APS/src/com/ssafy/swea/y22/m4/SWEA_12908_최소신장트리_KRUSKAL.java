package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class SWEA_12908_최소신장트리_KRUSKAL {
	public static int[] p;
	public static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);
			p = new int[V + 1];
			rank = new int[V + 1];

			// p배열 초기화
			for (int v = 0; v <= V; v++) {
				makeSet(v);
			}

			// edge 정보 받기
			int[][] edge = new int[E][3];
			for (int e = 0; e < E; e++) {
				String[] N1N2W = br.readLine().split(" ");
				// n1
				edge[e][0] = Integer.parseInt(N1N2W[0]);
				// n2
				edge[e][1] = Integer.parseInt(N1N2W[1]);
				// n3
				edge[e][2] = Integer.parseInt(N1N2W[2]);
			}

			// edge 오름차순 정렬
			Arrays.sort(edge, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});

			// edge 선택 -> V+1개의 노드가 있으니 V개의 edge를 union하고 종료
			int sumW=0;
			int cnt = 0;
			for (int e = 0; e < E; e++) {
				int n1 = edge[e][0];
				int n2 = edge[e][1];
				int w = edge[e][2];
				if(findSet(n1) != findSet(n2)) {
					sumW+=w;
					cnt+=1;
					// 묶어서 tree 구성하기
					union(n1,n2);
				}
				if(cnt==V) {
					break;
				}
			}

			// 출력
			bw.write("#" + tc + " " + sumW + "\n");
			bw.flush();
		}
	}

	public static void makeSet(int x) {
		p[x] = x;
		rank[x] = 0;
	}

	// 마지막을 찍고 찾은 대표값을 계속 가지고 리턴하면서 각 dept에서
	// p[x]를 해당 대표값으로 변경시킨다.
	public static int findSet(int x) {
		// 아직 대표값에 도달하지 않았으면 더 가야지
		if (x != p[x]) {
			// 리턴값은 부모값을 대표값으로 변경하는데 사용한다.
			p[x] = findSet(p[x]);
		}
		// 대표값에서는 x==p[x]이므로 이곳에서 둘(x,p[x]) 중에 뭐를 리턴하든 상관없지만
		// 대표값의 자손들에서는 부모값을 대표값으로 변경한 후 대표값을 그대로 계속
		// 자손에게 물려줘야 하므로 이곳에서 무조건 p[x]를 리턴해야 함.
		return p[x];
	}

	public static void union(int x, int y) {
		int repX = findSet(x);
		int repY = findSet(y);
		if (rank[repX] > rank[repY]) {
			p[repY] = repX;
		} else {
			p[repX] = repY;
			if (rank[repX] == rank[repY]) {
				rank[repY]++;
			}
		}
	}
}
//End