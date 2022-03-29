package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1248_공통조상 {
	public static Map<Integer, node> nodeMap;

	public static class node {
		public int nodeNumL;
		public int nodeNumR;

		public node() {
			nodeNumL = 0;
			nodeNumR = 0;
		}

		public int getNodeNumL() {
			return nodeNumL;
		}

		public void setNodeNumL(int nodeNumL) {
			this.nodeNumL = nodeNumL;
		}

		public int getNodeNumR() {
			return nodeNumR;
		}

		public void setNodeNumR(int nodeNumR) {
			this.nodeNumR = nodeNumR;
		}

		@Override
		public String toString() {
			return "node [nodeNumL=" + nodeNumL + ", nodeNumR=" + nodeNumR + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
		StringBuilder sb = new StringBuilder();
			sb.append("#" + tc);

		String[] inStr = br.readLine().split(" ");
		int V = Integer.parseInt(inStr[0]);
		int E = Integer.parseInt(inStr[1]);
		int Node1 = Integer.parseInt(inStr[2]);
		int Node2 = Integer.parseInt(inStr[3]);
		Stack<Integer> routeN1 = new Stack<>();
		Stack<Integer> routeN2 = new Stack<>();

		nodeMap = new HashMap<>();

		String[] EList = br.readLine().split(" ");
		for (int ec = 0; ec < E; ec++) {
			// 간선꺼내와서 부모, 자식 번호 확인
			int parent = Integer.parseInt(EList[2 * ec]);
			int child = Integer.parseInt(EList[2 * ec + 1]);
			// 이미 있는 노드이면 map에서 꺼내와서 사용
			// 아니면 새로 만들기
			// 그냥 단순할당으로 map에서 꺼내오면 Map에 있는 객체를 그대로 사용
			// 이러게 하면 이미 없는 노드는 새 객체, 이미 있는 노드는 Map에 있는 객체를
			// 사용하면서 다시 Map에 저장할때 꼬일 수가 있다.

			node newNode = new node();
			if (nodeMap.containsKey(parent)) {
				newNode.setNodeNumL(nodeMap.get(parent).getNodeNumL());
				newNode.setNodeNumR(nodeMap.get(parent).getNodeNumR());
				nodeMap.remove(parent);
			}
			// 자식노드는 없으면 새로 만들어주되 있다고 수정해주진 않는다.
			// 자식노드는 정보가 바뀌는 게 없으므로
			if (!nodeMap.containsKey(child)) {
				node newChildNode = new node();
				nodeMap.put(child, newChildNode);
			}

			// 노드 인스턴스에 자식 정보 저장
			if (newNode.getNodeNumL() == 0) {
				newNode.setNodeNumL(child);
			} else {
				newNode.setNodeNumR(child);
			}

			// newNode를 Map에 저장
			nodeMap.put(parent, newNode);
		}

		// Node1과 Node2의 경로 찾기
		searchRoute(1, Node1, routeN1);
		searchRoute(1, Node2, routeN2);

		int n1 = -1;
		int n2 = -1;
		int n1B = -1;
		while (n1 == n2) {
			n1B = n1;
			n1 = routeN1.pop();
			n2 = routeN2.pop();
		}
		// 가장 가까운 공통조상
		int common = n1B;
		// 가장 가까운 공통조상을 루트로 하는 서브 트리의 크기
		int subTree = searchLRV(common);
		sb.append(" "+common+" "+subTree+"\n");
		bw.write(sb.toString());
		bw.flush();
		}
	}

	// 탐색 성공한 경로의 리턴으로 경로 축적
	public static boolean searchRoute(int nodeNum, int targetNode, Stack<Integer> route) throws IOException {
		// 종료조건
		if (nodeNum == 0) {
			return false;
		} else if (nodeNum == targetNode) {
			route.push(nodeNum);
			return true;
		}
		// 좌
		boolean FeedBackL = searchRoute(nodeMap.get(nodeNum).getNodeNumL(), targetNode, route);
		if (FeedBackL == true) {
			route.push(nodeNum);
			return true;
		}
		// 우
		boolean FeedBackR = searchRoute(nodeMap.get(nodeNum).getNodeNumR(), targetNode, route);
		if (FeedBackR == true) {
			route.push(nodeNum);
			return true;
		}
		return false;
	}

	// 리턴하면서 누적 수행
	public static int searchLRV(int nodeNum) {
		// 종료조건
		if (nodeNum == 0) {
			return 0;
		}
		// 좌
		int fromL = searchLRV(nodeMap.get(nodeNum).getNodeNumL());
		// 우
		int fromR = searchLRV(nodeMap.get(nodeNum).getNodeNumR());
		// 중, +1은 본인 노드를 의미함.
		return fromL + fromR + 1;
	}
}
//End