package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class SWEA_1232_사칙연산 {
	public static int N;
	public static Map<Integer,node> nodeMap;
	
	public static class node{
		

		public String data;
		public int nodeNumL;
		public int nodeNumR;

		public node() {
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
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
			return "node [data=" + data + ", nodeNumL=" + nodeNumL + ", nodeNumR=" + nodeNumR + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = 10;
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc);

			N = Integer.parseInt(br.readLine());
			nodeMap = new HashMap<>();
			
			// 트리 만들기
			for (int nc = 1; nc <= N; nc++) {
				String[] input = br.readLine().split(" ");
				node newNode = new node();
				newNode.setData(input[1]);
				// 자식 노드가 있으면 자식 노드 정보 반영
				if(input.length>=3) {
					newNode.setNodeNumL(Integer.parseInt(input[2]));
					newNode.setNodeNumR(Integer.parseInt(input[3]));
				}
				nodeMap.put(Integer.parseInt(input[0]), newNode);
			}
			
			// 후위탐색(LRV)
			sb.append( " " + (int)searchLRV(1) + "\n" );
			// 출력
			bw.write(sb.toString());
			bw.flush();
		}
	}
    
	// 리턴하면서 연산 수행
	public static float searchLRV(int nodeNum) {
		// 종료조건, 숫자를 가진 노드이면 가진 숫자를 리턴
		try {
			return Integer.parseInt(nodeMap.get(nodeNum).getData());
		// 숫자 노드 아니면(연산자 노드이면) 연산 진행
		} catch (NumberFormatException e) {
			// 좌
			float fromL = searchLRV(nodeMap.get(nodeNum).getNodeNumL());
			// 우
			float fromR = searchLRV(nodeMap.get(nodeNum).getNodeNumR());
			// 중
			switch (nodeMap.get(nodeNum).getData()) {
			case "+":
				return fromL + fromR;
			case "-":
				return fromL - fromR;
			case "*":
				return fromL * fromR;
			case "/":
				return fromL / fromR;
			default:
				return 0f;
			}
		}
	}

}
//End