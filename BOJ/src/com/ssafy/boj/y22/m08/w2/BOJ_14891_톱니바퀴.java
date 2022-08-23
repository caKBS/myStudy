package com.ssafy.boj.y22.m08.w2;

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
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {

	public static StringBuilder sb;
	public static int R = 2;
	public static int L = 6;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		char[][] gear = new char[4][8];
		for (int i = 0; i < 4; i++) {
			gear[i] = br.readLine().toCharArray();
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			String[] aline = br.readLine().split(" ");
			// 4번 톱니바퀴는 3번 인덱스를 사용
			int gearNum = Integer.parseInt(aline[0])-1;
			int dir = Integer.parseInt(aline[1]);
			// 몇번 톱니를 어떤 방향으로 회전할지
			// 적어놓는 배열
			int [] setting = new int[4];
			setting[gearNum] = dir;
			// 해당 톱니 주변으로 전파
			// 무회전은 0이므로 -1을 곱하는 것이 무회전에선 전파차단된다.
			for(int d=1;d<=3;d++) {
				int pre = gearNum-d;
				int post = gearNum+d;
				if(BC(pre) && gear[pre][R] != gear[pre+1][L]) {
					setting[pre] = setting[pre+1]*-1;
				}
				if(BC(post) && gear[post-1][R] != gear[post][L]) {
					setting[post] = setting[post-1]*-1;
				}
			}
			// 일괄 회전
			rotate(gear[0],setting[0]);
			rotate(gear[1],setting[1]);
			rotate(gear[2],setting[2]);
			rotate(gear[3],setting[3]);
			
		}
		
		int sum=0;
		for(int i=0;i<4;i++) {
			sum+= (gear[i][0]-'0') * Math.pow(2, i);
		}
		System.out.println(sum);

	}
	
	public static boolean BC(int x) {
		if(x>=0 && x<4) {
			return true;
		}else {
			return false;
		}
	}

	public static void rotate(char[] gear, int dir) {
		switch (dir) {
		// 시계방향
		case 1:
			char last = gear[7];
			for (int i = 7; i >= 1; i--) {
				gear[i] = gear[i - 1];
			}
			gear[0] = last;
			break;

		// 반시계방향
		case -1:
			char first = gear[0];
			for (int i = 1; i <= 7; i++) {
				gear[i - 1] = gear[i];
			}
			gear[7] = first;
			break;
		// 무회전
		case 0:
			break;

		}
	}

}
//End