package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_2644_촌수계산 {

	public static StringBuilder sb;
	public static int [] pArr;
	public static List<Integer> [] adj;
	public static boolean stop;
	public static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		// 1부터 N까지 있어야 함.
		adj = new ArrayList [N+1];
		for(int i=1; i<N+1;i++) {
			adj[i] = new ArrayList<>();
		}
		String [] target = br.readLine().split(" ");
		int manA = Integer.parseInt(target[0]);
		int manB = Integer.parseInt(target[1]);
		
		int M = Integer.parseInt(br.readLine());
		
		// 입력 받기
		for(int i=0; i<M;i++) {
			String [] aline = br.readLine().split(" ");
			int st = Integer.parseInt(aline[0]);
			int ed = Integer.parseInt(aline[1]);
			adj[st].add(ed);
			adj[ed].add(st);
		} // 입력 받기 완료
		
		stop=false;
		ans=-1;
		dfs(manA,manB,0,1<<manA);
		
		//출력
		System.out.println(ans);
		
	}
	// check는 아랫방향으로만 진행하도록 도와준다.
	public static void dfs(int curr,int ed, int chon,int check) {
		if(curr == ed) {
			stop=true;
			ans=chon;
			return;
		}
		if(stop) {
			return;
		}
		
		for(int i=0; i<adj[curr].size(); i++) {
			if( ( check & (1<<adj[curr].get(i)) ) == 0 ) {
				// 진입할려는 노드가 다음 curr이 되고
				// 이번 curr이 다음 p가 된다.
				dfs(adj[curr].get(i),ed, chon+1, check | (1<<adj[curr].get(i)));
			}
		}
		
	}

}
//End