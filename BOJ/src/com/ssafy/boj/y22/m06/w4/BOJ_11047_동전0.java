package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class BOJ_11047_동전0 {

	public static StringBuilder sb;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String [] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		int [] bill = new int[N];
		for(int i=0; i<N; i++) {
			bill[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt =0;
		while(N>0 && K >0) {
			N--;
			cnt+= K / bill[N];
			K = K % bill[N];
		}
		System.out.println(cnt);
	}

}
//End