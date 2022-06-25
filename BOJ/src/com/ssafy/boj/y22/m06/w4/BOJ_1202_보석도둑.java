package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1202_보석도둑 {

	
	public static class jewel implements Comparable<jewel>{
		public int m;
		public int v;
		
		public jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(jewel o) {
			return o.v - this.v;
		}
		
	}

	public static StringBuilder sb;
	
	// 탐욕적 선택 : 
	// 가장 가치가 큰 보석부터 담을 수 있는 최대한 작은 가방에 담자.
	// 어떤 보석을 담을 때 가능한 작은 걸로 담아야 하는 이유 : 
	// 선택 가능한 두 가방 A,B(A<B)가 있을때
	// B를 선택해서 A를 남기는 것보다
	// A를 선택해서 B를 남기는 게 다음 차례에서 활용도가 무조건 높기때문이다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String [] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		// 보석 담아둘 PQ
		// 비싼게 먼저 나오게 한다.
		PriorityQueue<jewel> PQ = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			String [] MV = br.readLine().split(" ");
			PQ.add(new jewel( Integer.parseInt(MV[0]) , Integer.parseInt(MV[1]) ));
		}
		// 가방 담아둘 linked list
		List<Integer> bags = new LinkedList<>();
		int maxBag = -1;
		for(int i=0; i<K; i++) {
			int weight = Integer.parseInt(br.readLine());
			maxBag = Math.max(maxBag, weight);
			bags.add(weight);
		}
		// 오름차순 정렬
		// 작은 가방이 앞으로 오게 한다.
		Collections.sort(bags);
		
		// 게임시작
		int valSum = 0;
		while(!PQ.isEmpty()) {
			jewel curr = PQ.poll();
			// 최대 가방보다 더 큰놈은 제낀다.
			if(curr.m > maxBag) {
				continue;
			}
			int bsize = bags.size();
			// 이 보석을 담을 수 있는 가장 작은 가방 찾기
			for(int i=0; i<bsize;i++) {
				if(curr.m <= bags.get(i)) {
					valSum+=curr.v;
					bags.remove(i);
					break;
				}
			}
		}
		System.out.println(valSum);
		
	}

}
//End