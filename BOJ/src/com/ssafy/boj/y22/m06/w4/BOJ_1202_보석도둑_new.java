package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1202_보석도둑_new {

	public static class jewel{
		public int m;
		public int v;

		public jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public String toString() {
			return "jewel [m=" + m + ", v=" + v + "]";
		}
	}

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		// 보석 담아둘 배열
		jewel[] jewels = new jewel[N];
		for (int i = 0; i < N; i++) {
			String[] MV = br.readLine().split(" ");
			jewels[i] = new jewel(Integer.parseInt(MV[0]), Integer.parseInt(MV[1]));
		}
		// 가방 담아둘 배열
		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		// 보석을 무게에 대해 오름차순 정렬
		Arrays.sort(jewels, new Comparator<jewel>(){
			@Override
			public int compare(jewel o1, jewel o2) {
				// TODO Auto-generated method stub
				return o1.m - o2.m;
			}
		});
		
		// 가방을 오름차순으로 정렬
		Arrays.sort(bags);
		
		// 게임시작
		int j=0;
		long sum=0;
		PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<K;i++) {
			
			while( j<N && jewels[j].m <= bags[i]) {
				PQ.add(jewels[j].v);
				j++;
			}
			
			if(!PQ.isEmpty()) {
				sum += PQ.poll();
			}
			
		}
		
		// 출력
		System.out.println(sum);

	}

}
//End