package com.ssafy.boj.y22.m07.w1;

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
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_2251_물통 {

	public static StringBuilder sb;
	public static int[] limit;
	public static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// 입력받기
		String[] ABC = br.readLine().split(" ");
		int A = Integer.parseInt(ABC[0]);
		int B = Integer.parseInt(ABC[1]);
		int C = Integer.parseInt(ABC[2]);
		limit = new int[3];
		limit[0] = A;
		limit[1] = B;
		limit[2] = C;

		Set<Integer> pos = new TreeSet<>();
		check = new boolean[A + 1][B + 1];
		DFS(2, 2, 0, 0, C, pos);

		// 출력
		for(int num : pos) {
			sb.append(num+" ");
		}
		System.out.println(sb);

	}

	public static void DFS(int from, int to, int a, int b, int c, Set<Integer> pos) {
		int[] water = { a, b, c };
		// 받기 전 물의 양
		int prev = water[to];
		// 받은 후 물의 양
		water[to] = Math.min(limit[to], water[to] + water[from]);
		water[from] = water[from] - (water[to] - prev);

		// 탈출조건 : 세 물통에 있는 물의 양이 이전과 동일한 조합을 가지면 return
		// C는 A,B가 결정되면 자동 결정되므로 A, B만 따진다.
		if (check[water[0]][water[1]]) {
			return;
		}
		check[water[0]][water[1]] = true;
		// 첫번째 물통이 비어있을때
		if (water[0] == 0) {
			pos.add(water[2]);
		}

		// 주는 애 선정
		for (int i = 0; i < 3; i++) {
			if (water[i] > 0) {
				// 받는 애 선정
				for (int j = 0; j < 3; j++) {
					if (j != i) {
						DFS(i, j, water[0], water[1], water[2], pos);
					}
				}

//				//틀린코드
//				// 본래의도 : j가 i랑 같을때만 동작안하게 해야지
//				// 실제 동작 : j가 i랑 같을때 바로 종료
//				for(int j=0; j<3 && j!=i; j++) {
//					DFS(i,j,water[0],water[1],water[2],pos);
//				}
			}
		}
	}

}
//End