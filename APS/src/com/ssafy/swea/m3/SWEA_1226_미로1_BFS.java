package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1226_미로1_BFS {

	public static class coor {
		public int row;
		public int col;

		public coor() {
		}

		public coor(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		@Override
		public String toString() {
			return "coor [row=" + row + ", col=" + col + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = 10;
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] board = new int[16][16];
			int[] start = new int[2];
			int[] end = new int[2];
			int rIdx = 0;
			int cIdx = 1;
			// 입력받기
			for (int row = 0; row < 16; row++) {
				char[] aLine = br.readLine().toCharArray();
				for (int col = 0; col < 16; col++) {
					board[row][col] = Character.getNumericValue(aLine[col]);
					if (board[row][col] == 2) {
						start[rIdx] = row;
						start[cIdx] = col;
					} else if (board[row][col] == 3) {
						end[rIdx] = row;
						end[cIdx] = col;
					}
				}
			}

			// 시작
			int possible = 0;
			Queue<coor> Q = new LinkedList<>();
			Q.add(new coor(start[rIdx], start[cIdx]));
			// 동, 북, 서, 남
			int[] dr = { 0, -1, 0, 1 };
			int[] dc = { 1, 0, -1, 0 };

			BFS : while (!Q.isEmpty()) {
				coor curr = Q.poll();
				// 현재 위치 완료 표시
				board[curr.getRow()][curr.getCol()] = 1;
				// delta 탐색
				for(int d=0; d<4; d++) {
					int newR = curr.getRow()+dr[d];
					int newC = curr.getCol()+dc[d];
					if(board[newR][newC] == 0) {
						Q.add(new coor(newR, newC));
					// delta 탐색할때 3이 있으면 가능함 체크하고 종료
					}else if(board[newR][newC] == 3) {
						possible=1;
						break BFS;
					}
				}
			}
			// 출력
			bw.write("#" + tc + " " + possible + "\n");
			bw.flush();
		}
	}
}
//End