package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_7733_치즈도둑 {
	public static int[][] cheeze;
	public static int N;

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

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			N = Integer.parseInt(br.readLine());
			// 크기 1 패딩
			cheeze = new int[N + 2][N + 2];
			// 치즈 입력 받기
			for (int row = 1; row <= N; row++) {
				String[] aLine = br.readLine().split(" ");
				for (int col = 1; col <= N; col++) {
					cheeze[row][col] = Integer.parseInt(aLine[col - 1]);
				}
			}

			// 덩어리 탐색 시작
			int maxCnt = 1;
			for (int day = 1; day <= 100; day++) {
				int[][] done = new int[N + 2][N + 2];
				// 덩어리 개수
				int cnt = 0;
				// 모든 부위에 대해 덩어리 조사
				for (int row = 1; row <= N; row++) {
					for (int col = 1; col <= N; col++) {
						// 생존한 치즈 부위
						if (cheeze[row][col] > day && done[row][col] == 0) {
							// 해당 부위가 속한 덩어리를 모두 0(요정이먹은칸과 등가)으로 만든다.
							BFS(new coor(row, col), day, done);
							// 0으로 만든 덩어리 개수
							cnt++;
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}

//			//디버깅
//			for (int row = 0; row <= N+1; row++) {
//			System.out.println(Arrays.toString(cheeze[row]));
//			}

			// 출력
			bw.write("#" + tc + " " + maxCnt + "\n");
			bw.flush();
		}
	}

	public static void BFS(coor start, int day, int[][] done) {
		// 동, 북, 서, 남
		int[] dr = { 0, -1, 0, 1 };
		int[] dc = { 1, 0, -1, 0 };
		Queue<coor> Q = new LinkedList<>();
		Q.add(start);
		// 현재 위치 완료 표시
		done[start.getRow()][start.getCol()] = -1;
		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			// delta 탐색
			for (int d = 0; d < 4; d++) {
				int newR = curr.getRow() + dr[d];
				int newC = curr.getCol() + dc[d];
				if (cheeze[newR][newC] > day && done[newR][newC] == 0) {
					Q.add(new coor(newR, newC));
					// 현재 위치 완료 표시
					// Q에 넣을때 완료 표시 !!!!!!!블로그 메모ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
					done[newR][newC] = -1;
				}
			}
		}
	}
}
//End