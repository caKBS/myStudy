package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SWEA_1868_파핑파핑지뢰찾기 {
	public static int[][] board;
	public static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };;
	public static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

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

		char mine = '*';
		char safe = '.';

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			int N = Integer.parseInt(br.readLine());
			// padding, -1로 상하좌우 한칸씩 패딩
			board = new int[N + 2][N + 2];
			for (int row = 0; row <= N + 1; row++) {
				for (int col = 0; col <= N + 1; col++) {
					if (row == 0 || col == 0 || row == N + 1 || col == N + 1) {
						board[row][col] = -1;
					}
				}
			}

			// 입력받기
			for (int row = 1; row <= N; row++) {
				char[] aLine = br.readLine().toCharArray();
				for (int col = 1; col <= N; col++) {
					board[row][col] = aLine[col - 1];
				}
			}

			// 일단 다 숫자를 오픈했다고 가정하고
			// 그 상태에서 (0묶음+맞닿아있는 숫자들)을 하나의 클릭으로 보고
			// 그 외는 다 각각이 하나의 클릭으로 봐서 총합을 더하면
			// 그게 최소 클릭
			// 그럼 일단 다 오픈 하자.
			// 숫자 다 오픈하기.
			// 0인곳을 모아둔 List
			List<coor> zeroList = new LinkedList<>();
			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= N; col++) {
					// 지뢰 없는 곳이면
					if (board[row][col] == safe) {
						// delta 탐색
						int cntMine = 0;
						for (int di = 0; di <= 7; di++) {
							if (board[row + dr[di]][col + dc[di]] == mine) {
								cntMine++;
							}
						}
						board[row][col] = cntMine;
						if (cntMine == 0) {
							zeroList.add(new coor(row, col));
						}
					}
				}
			}

			// (0묶음+맞닿아있는 숫자들)을 하나의 클릭 묶음으로 표시하는 방법 :
			// 내가 0이면 나를 처리완료표시하고 내주변에 0이 아닌 숫자(본인은 지뢰가 아니고 주변에
			// 지뢰가 최소 하나 있는 구역)를 처리완료표시하고
			// 0이 있으면 거기로 간다.
			// 처리 완료 표시는 -1로 한다.
			// 하나의 클릭으로 처리하면서 count 해주자.

			// 0인 칸을 우선 클릭 반영
			int clickCnt = 0;
			for (int listIdx = 0; listIdx < zeroList.size(); listIdx++) {
				int row = zeroList.get(listIdx).getRow();
				int col = zeroList.get(listIdx).getCol();
				clickCnt += Click(row, col);
			}

			// 이후 전체 클릭 반영
			for (int row = 1; row <= N; row++) {
				for (int col = 1; col <= N; col++) {
					if (board[row][col] >= 1 && board[row][col] <= 10) {
						clickCnt += Click(row, col);
					}
				}
			}

			// 출력
			bw.write("#" + tc + " " + clickCnt + "\n");
			bw.flush();
		}
	}

	public static int Click(int row, int col) {
		int tmpR = row;
		int tmpC = col;
		int clickCnt = 0;
		Stack<coor> path = new Stack<>();
		// 0을 포착
		if (board[tmpR][tmpC] == 0) {
			DFS: while (true) {
				// 나를 처리완료 표시
				board[tmpR][tmpC] = -1;
				path.add(new coor(tmpR,tmpC));
				// 주변에 0이 아닌 숫자를 탐색하고 처리완료 표시
				for (int di = 0; di <= 7; di++) {
					// 지뢰와 0이 아닌 숫자를 구별하기 위해 10이하로 제한
					if (board[tmpR + dr[di]][tmpC + dc[di]] >= 1 && board[tmpR + dr[di]][tmpC + dc[di]] <= 10) {
						board[tmpR + dr[di]][tmpC + dc[di]] = -1;
					}
				}
				// 주변에 0이 있으면 거기로 이동
				for (int di = 0; di <= 7; di++) {
					// 지뢰와 0이 아닌 숫자를 구별하기 위해 10이하로 제한
					if (board[tmpR + dr[di]][tmpC + dc[di]] == 0) {
						tmpR += dr[di];
						tmpC += dc[di];
						continue DFS;
					}
				}
				// 주변에 0이 없을때 stack이 있으면 다시 돌아가기
				// 주변에 0이 없을때 stack이 없으면 DFS 종료
				if( path.size()>1) {
					// 나 자신 쌓아둔거 버리기
					path.pop();
					coor wayBackHome = path.pop();
					tmpR = wayBackHome.getRow();
					tmpC = wayBackHome.getCol();
				}else {
					break DFS;
				}
				
			}
			clickCnt++;
			// 0이 아닌 숫자면 바로 클릭 수 카운트
		} else if (board[row][col] >= 1 && board[row][col] <= 10) {
			board[row][col] = -1;
			clickCnt++;
		}
		return clickCnt;
	}
}
//End