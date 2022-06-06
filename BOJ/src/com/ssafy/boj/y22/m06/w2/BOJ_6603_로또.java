package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_6603_로또 {
	public static int [] selected;
	public static int [] numSet;
	public static int k;
	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		while(true) {
			String [] aline = br.readLine().split(" ");
			k = Integer.parseInt(aline[0]);
			numSet = new int [k];
			for(int i=0; i<k;i++) {
				numSet[i] = Integer.parseInt(aline[i+1]);
			}
			
			// 0을 만났을때
			if(k==0) {
				break;
			}
			
			selected = new int [6];
			comb(0,0);
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static void comb(int idx, int sidx) {
		
		if(sidx == 6) {
			// 조합 완성
			for(int i=0; i<6;i++) {
				sb.append(selected[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<=k-6+sidx; i++) {
			selected[sidx]= numSet[i];
			comb(i+1,sidx+1);
		}
	}

	
}
//End