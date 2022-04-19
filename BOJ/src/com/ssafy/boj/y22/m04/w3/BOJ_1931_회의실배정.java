package com.ssafy.boj.y22.m04.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1931_회의실배정 {
	public static meet[] meetList;
	public static int N;
	public static int maxCnt;

	public static class meet implements Comparable<meet> {
		public int st;
		public int ed;

		public meet(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}

		@Override
		public int compareTo(meet o) {
			// TODO Auto-generated method stub
			return this.st - o.st;
		}

		@Override
		public String toString() {
			return "meet [st=" + st + ", ed=" + ed + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기, 입력 순서대로 시간 배정하는 것은 아니다!
		N = Integer.parseInt(br.readLine());
		meetList = new meet[N];
		for (int i = 0; i < N; i++) {
			String[] aLine = br.readLine().split(" ");
			int st = Integer.parseInt(aLine[0]);
			int ed = Integer.parseInt(aLine[1]);
			meetList[i] = new meet(st, ed);
		}
		// 시작시간 기준 오름차순 정렬
		Arrays.sort(meetList);

		// 첫 회의
		
		
		
		
		
		
		
		// 출력
		bw.write(maxCnt + "\n");
		bw.flush();

	}

}
//End