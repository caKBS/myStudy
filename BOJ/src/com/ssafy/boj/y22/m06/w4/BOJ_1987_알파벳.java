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


// 제출 결과 : 메모리 초과
// 실패 원인 : BFS로 구현할때 새로운 위치객체마다 각자의 trace내역(HashSet으로 구현)
//			   을 가지고 있기 때문에 탐색이 길고 커질수록 메모리 사용이 매우 커짐.
// 해결 방법 : DFS로 구현하여 하나의 trace내역만 사용하도록 하자.



public class BOJ_1987_알파벳 {
	public static class coor {
		public int r;
		public int c;
		public int d;
		public Set<Character> t;

		public coor(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.t = new HashSet<>();
		}
	}

	public static StringBuilder sb;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int R;
	public static int C;
	public static char[][] board;
	public static int maxT;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 결과 초기화
		maxT = -1;

		String[] RC = br.readLine().split(" ");
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		board = new char[R][C];
		for (int r = 0; r < R; r++) {
			board[r] = br.readLine().toCharArray();
		}

		// 칸수에 시작칸도 포함된다.
		coor st = new coor(0,0,1);
		// 시작위치에도 알파벳이 있으므로 반영해줘야 한다.
		st.t.add(board[0][0]);
		BFS(st);
		System.out.println(maxT);

	}

	public static void BFS(coor st) {
		// 방문한 곳을 또 방문해야하므로 check배열 필요없음.
		Queue<coor> Q = new LinkedList<>();
		Q.add(st);

		while (!Q.isEmpty()) {
			coor curr = Q.poll();

			// 주변에 갈곳이 있는가
			boolean flag = false;
			// 주변탐색시작
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				int nd = curr.d + 1;
				if (BC(nr, nc) && !curr.t.contains(board[nr][nc])) {
					flag = true;
					coor ncoor = new coor(nr,nc,nd);
					// 기존 trace 내역 승계
					Iterator<Character> it = curr.t.iterator();
					while(it.hasNext()) {
						ncoor.t.add(it.next());
					}
					// 새로운 위치를 trace에 추가
					ncoor.t.add(board[nr][nc]);
					// Q에 새로운 위치객체 추가
					Q.add(ncoor);
				}
			} // 주변탐색끝
			// 주변에 갈 곳이 없으면 최대칸수 갱신 시도
			if(!flag) {
				maxT = Math.max(maxT, curr.d);
			}
		}
	}

	public static boolean BC(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		} else {
			return false;
		}
	}

}
//End