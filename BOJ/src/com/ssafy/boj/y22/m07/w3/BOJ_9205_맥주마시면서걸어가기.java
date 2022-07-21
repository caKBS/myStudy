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

public class BOJ_9205_맥주마시면서걸어가기 {

	public static StringBuilder sb;
	public static int LIMIT = 1000;
	
	public static class coor {
		public int r;
		public int c;
		
		public coor(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력받기
			int N = Integer.parseInt(br.readLine());
			coor [] spots = new coor[N+1];
			for (int i = 0; i < N + 1; i++) {
				String[] spot = br.readLine().split(" ");
				spots[i] = new coor(Integer.parseInt(spot[0]), Integer.parseInt(spot[1]));
			}
			String[] festival = br.readLine().split(" ");
			coor fest = new coor(Integer.parseInt(festival[0]),Integer.parseInt(festival[1]));
			
			// BFS
			Queue<coor> Q = new LinkedList<>();
			boolean [] check = new boolean[N+1];
			Q.add(spots[0]);
			check[0] = true;
			boolean flag = false;
			while(!Q.isEmpty()) {
				coor curr = Q.poll();
				
				int lastMile = Math.abs(curr.r-fest.r)+Math.abs(curr.c-fest.c);
				if(lastMile<=LIMIT) {
					flag = true;
					break;
				}
				
				
				for(int i=0; i<N+1; i++) {
					int dist = Math.abs(curr.r-spots[i].r)+Math.abs(curr.c-spots[i].c);
					if(!check[i] && dist <= LIMIT) {
						Q.add(spots[i]);
						check[i] = true;
					}
				}
			}
			
			// 출력
			if(flag) {
				sb.append("happy"+"\n");
			}else {
				sb.append("sad"+"\n");
			}
		}
		System.out.print(sb);
	}

}
//End