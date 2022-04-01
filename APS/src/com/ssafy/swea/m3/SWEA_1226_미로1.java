package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SWEA_1226_미로1 {

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

			int possible = 0;
			Stack<coor> path = new Stack<>();
			int[] running = { start[rIdx], start[cIdx] };
			// 동, 북, 서, 남
			int[] dr = { 0, -1, 0, 1 };
			int[] dc = { 1, 0, -1, 0 };

			search: while (true) {
				// 현재 장소인덱스를 스택에 쌓는다.
				coor Idx = new coor(running[rIdx], running[cIdx]);
				path.add(Idx);
				// 현재 장소가 탐색됐음을 표시한다.
				board[running[rIdx]][running[cIdx]] = 1;
				
				// 주변 탐색
				boolean posWay = false;
				for (int dirIdx = 0; dirIdx < 4; dirIdx++) {
					// 해당 장소가 0이면
					if (board[running[rIdx] + dr[dirIdx]][running[cIdx] + dc[dirIdx]] == 0) {
						posWay=true;
						running[rIdx] = running[rIdx] + dr[dirIdx];
						running[cIdx] = running[cIdx] + dc[dirIdx];
						break;
					} else if (board[running[rIdx] + dr[dirIdx]][running[cIdx] + dc[dirIdx]] == 3) {
						possible = 1;
						break search;
					}
				}
				// 주변에 갈 곳이 없다.
				if (!posWay) {
					// 돌아갈 길은 있다.
					if (path.size()>1) {
						// 방금 스택에 쌓은 나 자신 버리기
						path.pop();
						coor returnCoor = path.pop();
						running[rIdx] = returnCoor.getRow();
						running[cIdx] = returnCoor.getCol();
						continue;
					}
					// path에 나밖에 없는데 주변에 갈데가 없으면 불가능이므로 종료.
					else {
						break search;
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