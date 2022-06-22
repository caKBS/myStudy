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


public class BOJ_5585_거스름돈 {

	public static StringBuilder sb;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int K = 1000-Integer.parseInt(br.readLine());
		int [] bill = {1,5,10,50,100,500};
		int N = bill.length;
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