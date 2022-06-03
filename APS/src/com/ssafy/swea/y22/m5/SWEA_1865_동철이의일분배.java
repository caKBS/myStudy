package com.ssafy.swea.y22.m5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SWEA_1865_동철이의일분배 {
	
	public static int N;
	public static double [][] P;
	// gMax는 % 단위
	public static double gMax;


	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			
			N = Integer.parseInt(br.readLine());
			P = new double[N][N];
			for(int i=0; i<N;i++) {
				String [] tmp = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					P[i][j] = Double.parseDouble(tmp[j])/100;
				}
			}
			// 결과 초기화
			gMax=0;
			// 재귀 시작
			picking(0,0,1);
			
			System.out.println("#"+tc+" "+String.format("%.6f", gMax*100));

		}
	}
	
	// 가지치기 할려면 계산 결과를 들고 다니자.
	public static void picking(int hidx, int picked, double mul) {
		if(mul <= gMax) {
			return;
		}
		
		if(hidx == N) {
			gMax = Math.max(gMax, mul);
		}
		
		
		for(int jidx=0; jidx<N; jidx++) {
			// 이전에 선택되지 않은 경우
			if( (picked & (1 << jidx)) <= 0 ) {
			picking(hidx+1, picked | 1 << jidx, mul * P[hidx][jidx]);
			}
		}
		
	}
}
//End