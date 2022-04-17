package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SWEA_2383_점심식사시간 {
	public static List<stair> sList;
	public static List<person> pList;
	public static int[][] select;
	public static int minVal;

	public static class person implements Comparable<person> {
		public int row;
		public int col;
		public int stair;
		public int[] dist;

		public person(int row, int col) {
			super();
			this.row = row;
			this.col = col;
			this.dist = new int[2];
		}

		@Override
		public String toString() {
			return "person [row=" + row + ", col=" + col + ", stair=" + stair + ", dist=" + Arrays.toString(dist) + "]";
		}

		@Override
		public int compareTo(person o) {
			// TODO Auto-generated method stub
			return this.dist[this.stair] - o.dist[o.stair];
		}

	}

	public static class stair {
		public int row;
		public int col;
		public int len;

		public stair(int row, int col, int len) {
			this.row = row;
			this.col = col;
			this.len = len;
		}

		@Override
		public String toString() {
			return "stair [row=" + row + ", col=" + col + ", len=" + len + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			minVal = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());

			// 크기1짜리 패딩
			int[][] board = new int[N][N];

			// 사람,계단 정보 저장
			sList = new ArrayList<>();
			pList = new ArrayList<>();
			// 입력받기
			for (int row = 0; row < N; row++) {
				String[] sInfo = br.readLine().split(" ");
				for (int col = 0; col < N; col++) {
					board[row][col] = Integer.parseInt(sInfo[col]);
					// 계단 발견
					if (board[row][col] >= 2 && board[row][col] <= 10) {
						sList.add(new stair(row, col, board[row][col]));
					} else if (board[row][col] == 1) {
						pList.add(new person(row, col));
					}
				}
			}

			// dist정보 저장
			for (int i = 0; i < pList.size(); i++) {
				// stair0까지의 거리
				pList.get(i).dist[0] = Math.abs(pList.get(i).row - sList.get(0).row)
						+ Math.abs(pList.get(i).col - sList.get(0).col);
				// stair1까지의 거리
				pList.get(i).dist[1] = Math.abs(pList.get(i).row - sList.get(1).row)
						+ Math.abs(pList.get(i).col - sList.get(1).col);
			}

			powerSet(0);

			// 출력
			bw.write("#" + tc + " " + minVal + "\n");
			bw.flush();
		}

	}

	public static void powerSet(int idx) {

		if (idx == pList.size()) {
			// 부분집합 생성완료
			PriorityQueue<person> s0 = new PriorityQueue<>();
			PriorityQueue<person> s1 = new PriorityQueue<>();
			for (int i = 0; i < pList.size(); i++) {
				// stair0소속
				if (pList.get(i).stair == 0) {
					// person 수정안할거니까 새로 안만들고 객체 그대로 삽입.
					s0.add(pList.get(i));
				} else {
					s1.add(pList.get(i));
				}
			}
			// 두 계단 중에서 가장 늦게 나온 애가 정답 후보
			minVal = Math.min(minVal, Math.max(doGame(s0), doGame(s1)));

		} else {
			pList.get(idx).stair = 0;
			powerSet(idx + 1);
			pList.get(idx).stair = 1;
			powerSet(idx + 1);
		}
	}

	public static int doGame(PriorityQueue<person> sN) {
		// timeTable은 해당 시각에 계단위에 있는 것을 표시.
		// timeTable이니 사람빠지는 건 고려안해줘도 됨.
		int[] timeTable = new int[10000];
		int ed = 0;
		int plus = 0;
		while (!sN.isEmpty()) {
			person player = sN.poll();
			int st = player.dist[player.stair] + 1;
			// ed는 계단에서 완전히 빠져나오는 시각
			ed = st + sList.get(player.stair).len;
			// st~ed-1에서 3명 이상 있는 시간대만큼 ed를 연장
			plus = 0;
			for (int i = st; i < ed; i++) {
				if (timeTable[i] >= 3) {
					plus++;
				}
			}
			for (int i = st + plus; i < ed + plus; i++) {
				timeTable[i]++;
			}
		}
		// 가장 늦게 나온 애
		return ed + plus;
	}

}
//End