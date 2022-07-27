package com.ssafy.boj.y22.m07.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력 받기
		int M = Integer.parseInt(br.readLine());
		Set<Integer> S = new HashSet<>(); 
		for(int m=0; m<M; m++) {
			String [] aline = br.readLine().split(" ");
			String order = aline[0];
			int X = -1;
			if(aline.length==2) {
				X = Integer.parseInt(aline[1]);
			}
			
			switch(order) {
			case "add" :
				S.add(X);
				break;
			case "remove" :
				S.remove(X);
				break;
			case "check" :
				if(S.contains(X)) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
				break;
			case "toggle" :
				if(S.contains(X)) {
					S.remove(X);
				}else {
					S.add(X);
				}
				break;
			case "all" :
				S.clear();
				for(int i=1; i<=20;i++) {
					S.add(i);
				}
				break;
			case "empty" :
				S.clear();
				break;
			}
		}
		
		System.out.print(sb);
		

	}

}
//End