package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SWEA_12908_최소신장트리_PRIM {
	public static int[] p;
	public static int[] rank;
	public static class edge implements Comparable<edge>{
		public int st;
		public int ed;
		public int cost;
		
		public edge(int st, int ed, int cost) {
			this.st = st;
			this.ed =ed;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "edge [st=" + st + ", ed=" + ed + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);

			List<edge> [] edges = new ArrayList[E];
			
			// 배열안에 ArrayList 객체를 채워 넣어줘야한다!!!
			for (int i = 0; i < V+1; i++) {
				edges[i] = new ArrayList<>();
			}
			

			// edge 정보 받기
			for (int i = 0; i < E; i++) {
				String[] N1N2W = br.readLine().split(" ");
				int n1 = Integer.parseInt(N1N2W[0]);
				int n2 = Integer.parseInt(N1N2W[1]);
				int w = Integer.parseInt(N1N2W[2]);
				edges[n1].add(new edge(n1,n2,w));
				edges[n2].add(new edge(n2,n1,w));
			}
			
			// vertex check 배열
			boolean [] check = new boolean [V+1];

			// 탐방, vertex0부터 시작
			// 우선순위큐에 사용할 객체는 반드시 Comparable을 가지고 있어야 한다!!
			PriorityQueue<edge> pq = new PriorityQueue<>();
			check[0] = true;
			// 특정 Collection의 모든 원소를 한번에 넣어준다.
			pq.addAll(edges[0]);
			int cnt = 0;
			int sumW = 0;
			while(cnt != V) {
				edge newEdge = pq.poll();
				// 이미 확보한 정점이면 넘어가기
				if(check[newEdge.ed]) {
					continue;
				}
				// 확보
				check[newEdge.ed]= true;
			    cnt++;
			    sumW += newEdge.cost;
			    // 주변 edge들 추가하기
			    pq.addAll(edges[newEdge.ed]);
			}

			// 출력
			bw.write("#" + tc + " " + sumW + "\n");
			bw.flush();
		}
	}
}
//End