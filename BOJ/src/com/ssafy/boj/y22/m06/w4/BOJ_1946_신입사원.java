package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1946_신입사원 {

	public static StringBuilder sb;
	
	public static class human implements Comparable<human>{
		public int paper;
		public int interview;
		
		public human(int paper, int interview) {
			this.paper = paper;
			this.interview = interview;
		}

		@Override
		public int compareTo(human o) {
			// TODO Auto-generated method stub
			return this.paper - o.paper;
		}

		@Override
		public String toString() {
			return "human [paper=" + paper + ", interview=" + interview + "]";
		}	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			// 입력받기
			int N = Integer.parseInt(br.readLine());
			human [] humans = new human[N];
			// 점수 입력 받기 및 서류성적 순 정렬
			for(int i=0; i<N;i++) {
				String [] aline = br.readLine().split(" ");
				humans[i] = new human(Integer.parseInt(aline[0]),Integer.parseInt(aline[1]));
			}
			Arrays.sort(humans); // 점수 입력 받기 및 서류성적 순 정렬 끝
			
			
			// 서류성적 앞선 순서대로 면접 점수 확인
			// 이전까지의 최소 면접등수보다 내 면접등수가 더 작으면(더 우등하면) 합격
			int minVal = Integer.MAX_VALUE;
			int cnt = 0;
			for(int i=0; i<N;i++) {
				if(humans[i].interview < minVal) {
					cnt++;
					minVal = humans[i].interview;
				}
			}
			
			// 출력
			System.out.println(cnt);
		}
	}

}
//End