package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CodingTest_A_기지국건설 {
	public static long maxSum;
	public static int H;
	public static int W;
	public static int[][] comm;
	public static int[][] connectable;
	// 코끼리코 모양
	public static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };
	public static boolean[][] check;

	public static class bee implements Comparable<bee> {
		public int num;
		public int cost;

		public bee(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(bee o) {
			// TODO Auto-generated method stub
			return o.cost - this.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		int T = Integer.parseInt(br.readLine());
//		// 테스트 케이스 T번
//		for(int tc=0; tc<T; tc++) {
		String[] WH = br.readLine().split(" ");
		W = Integer.parseInt(WH[0]);
		H = Integer.parseInt(WH[1]);

		// 입력받기
		comm = new int[H][W];
		for (int i = 0; i < H; i++) {
			String[] aLine = br.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				int input = Integer.parseInt(aLine[j]);
				comm[i][j] = input;
			}
		}

		List<bee>[] board = new ArrayList[W * H + 1];

		boolean[] check = new boolean[W * H + 1];

		// 채워주기
		for (int i = 1; i < W * H + 1; i++) {
			board[i] = new ArrayList<>();
		}

		// 관계설정
		for (int i = 1; i < W * H + 1; i++) {
			if ((i - 1) % W >= 0 && (i - 1) % W < H && (i - 1) / W >= 0 && (i - 1) / W < W) {
				board[i].add(new bee(i - 1, comm[(i - 1) % W][(i - 1) / W]));
			}
			if ((i - 1) % W >= 0 && (i - 1) % W < H && (i - 1) / W >= 0 && (i - 1) / W < W) {
				board[i].add(new bee(i - W, comm[(i - 1) % W][(i - 1) / W]));
			}
			if ((i - 1) % W >= 0 && (i - 1) % W < H && (i - 1) / W >= 0 && (i - 1) / W < W) {
				board[i].add(new bee(i + 1, comm[(i - 1) % W][(i - 1) / W]));
			}
			if ((i - 1) % W >= 0 && (i - 1) % W < H && (i - 1) / W >= 0 && (i - 1) / W < W) {
				board[i].add(new bee(i + W - 1, comm[(i - 1) % W][(i - 1) / W]));
			}
			if ((i - 1) % W >= 0 && (i - 1) % W < H && (i - 1) / W >= 0 && (i - 1) / W < W) {
				board[i].add(new bee(i + W, comm[(i - 1) % W][(i - 1) / W]));
			}
			if ((i - 1) % W >= 0 && (i - 1) % W < H && (i - 1) / W >= 0 && (i - 1) / W < W) {
				board[i].add(new bee(i + W + 1, comm[(i - 1) % W][(i - 1) / W]));
			}
		}

		// 모두 한번씩 확인
		
		
		for (int i = 1; i < W * H + 1; i++) {
			PriorityQueue<bee> pq = new PriorityQueue<>();
			int sumVal = 0;
			int cnt = 0;
			while (cnt < 4) {
				bee newBee = pq.poll();
				if (check[newBee.num]) {
					continue;
				}
				check[newBee.num] = true;
				sumVal += newBee.cost;
				cnt++;
				
				int maxVal = 0;
				int maxNum = 0;
				for (int j = 1; j < board[i].size(); j++) {
					if (board[i].get(j).cost > maxVal && check[board[i].get(j).num] == false) {
						maxVal = board[i].get(j).cost;
						maxNum = board[i].get(j).num;
						pq.add(new bee(board[i].get(j).num, board[i].get(j).cost));
					}
				}
			}
			maxSum = Math.max(maxSum, sumVal);
		}


//		// 디버깅
//		for (int i = 0; i < H+1; i++) {
//			System.out.println(Arrays.toString(comm[i]));
//		}

//		}
	}

	public static void findMax(int row, int col) {

	}

	public static void DFS(int row, int col, int dept, long sum) {
		for (int i = 0; i < H + 1; i++) {
			for (int j = 0; j < W; j++) {
				if (check[i][j]) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
		System.out.println("---------------------");

		check[row][col] = true;

		// 종료조건
		if (dept == 5) {
			maxSum = Math.max(maxSum, sum);
			check[row][col] = false;
			return;
		}

		// 현재 위치 값 축적
		long sumNew = sum + comm[row][col];
		// 우,하,좌 탐색
		for (int i = 0; i < 8; i++) {
			int rowD = row + dr[i];
			int colD = col + dc[i];

			// boundary안에 있고 방문하지 않았고 벌집을 위해 비워둔 곳이 아닐때
			if (rowD <= H && rowD >= 0 && colD <= W - 1 && colD >= 0 && !check[rowD][colD] && comm[rowD][colD] != 0) {
				DFS(rowD, colD, dept + 1, sumNew);
			}
		}

		check[row][col] = false;
	}

}
