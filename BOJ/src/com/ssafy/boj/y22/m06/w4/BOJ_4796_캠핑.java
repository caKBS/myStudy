package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4796_캠핑 {


	public static StringBuilder sb;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		int caseN = 1;
		while(true) {
			// 입력받기
			String [] aline = br.readLine().split(" ");
			if(Integer.parseInt(aline[0])==0) {
				break;
			}
			
			int L = Integer.parseInt(aline[0]);
			int P = Integer.parseInt(aline[1]);
			int V = Integer.parseInt(aline[2]);
			
			int a = V / P;
			int b = V % P;
			
			int sum = 0;
			if(b <= L) {
				sum = a * L + b;
			}else {
				sum = a * L + L;
			}
			sb.append("Case "+caseN+": "+sum+"\n");
			
			caseN++;
		}
		System.out.println(sb);
	}

}
//End