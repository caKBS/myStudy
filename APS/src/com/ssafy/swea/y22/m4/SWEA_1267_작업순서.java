package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SWEA_1267_작업순서 {
	public static class node {
		public int inDegree;
		public List<Integer> neigh;

		public node() {
			this.inDegree = 0;
			// 이렇게 클래스안에 클래스로 변수를 사용할때
			// 객체를 채워주고 사용해야 한다는 것 주의하자!!
			this.neigh = new LinkedList<>();
		}

		@Override
		public String toString() {
			return "node [inDegree=" + inDegree + ", neigh=" + neigh + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = 10;
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {

			// 입력받기
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);

			// nArr생성 및 node객체 채우기
			// idx1부터 쓸 것
			node[] nodeArr = new node[V + 1];
			for (int i = 1; i <= V; i++) {
				nodeArr[i] = new node();
			}

			String[] edgesIn = br.readLine().split(" ");
			// E개의 간선을 받음
			for (int i = 0; i < E; i++) {
				int st = Integer.parseInt(edgesIn[2 * i + 0]);
				int ed = Integer.parseInt(edgesIn[2 * i + 1]);
				// 이웃 추가
				nodeArr[st].neigh.add(ed);
				// 해당 이웃의 진입차수 증가
				nodeArr[ed].inDegree++;
			}
			
			// 위상 정렬 시작
			List<Integer> Seq = new LinkedList<>();
			Queue<Integer> Q = new LinkedList<>();
			boolean [] check = new boolean [V+1];
			check[0]=true;
			// 진입 차수가 0인 모든 노드를 Q에 삽입
			for (int i = 1; i <= V; i++) {
				if (nodeArr[i].inDegree == 0) {
					Q.add(i);
					check[i]=true;
				}
			}
			while (!Q.isEmpty()) {
				// 원소 하나 꺼내기
				int curr = Q.poll();
				// 작업 순서에 기록
				Seq.add(curr);
				// 연결된 노드의 진입 차수 감소
				for (int node : nodeArr[curr].neigh) {
					nodeArr[node].inDegree--;
				}
				
				// 진입 차수가 0인 모든 노드를 Q에 삽입
				for (int i = 1; i <= V; i++) {
					if (!check[i] && nodeArr[i].inDegree == 0) {
						Q.add(i);
						// Q에 같은 노드 재진입을 막기 위해
						// Q에 삽입시 체크처리해줘야함!!
						check[i]=true;
					}
				}
			}
			
			// 출력
			bw.write("#" + tc);
			for (int i = 0; i < Seq.size(); i++) {
				bw.write(" "+Seq.get(i));
			}
			bw.write("\n");
			bw.flush();
		}
	}
}
//End