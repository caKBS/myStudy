package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SWEA_5656_벽돌깨기 {
	public static int[][] board;
	public static int[][] boardBU;
	public static int N;
	public static int W;
	public static int H;
	public static int origN;
	public static int[] select;
	public static int minLeftOver;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static class coor {
		public int row;
		public int col;

		public coor(int row, int col) {
			this.row = row;
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
			// 정답 초기화
			minLeftOver = Integer.MAX_VALUE;

			String[] NWH = br.readLine().split(" ");
			N = Integer.parseInt(NWH[0]);
			W = Integer.parseInt(NWH[1]);
			H = Integer.parseInt(NWH[2]);

			board = new int[H][W];
			origN=0;
			for (int row = 0; row < H; row++) {
				String[] aRow = br.readLine().split(" ");
				for (int col = 0; col < W; col++) {
					board[row][col] = Integer.parseInt(aRow[col]);
					if(board[row][col]>0) {
						origN++;
					}
				}
			}

			// drop할 perm만들기
			select = new int[N];
			perm(0);
			
			// 출력
			bw.write("#" + tc + " " + minLeftOver + "\n");
			bw.flush();
		}
	}
	
	public static void perm(int idx) {
		if(idx==N) {
			// 중복순열 생성완료
			// 순서대로 drop
			int delCnt = 0;
			int [][] copy = copy();
			for(int i=0; i<N ; i++) {
				delCnt+=dropAt(select[i],copy);
				gravity(copy);
			}
			minLeftOver = Math.min(minLeftOver, origN-delCnt);
			return;
		}
		
		for(int i=0; i<W; i++) {
			select[idx]=i;
			perm(idx+1);
		}
	}
	
	// 제거한 벽돌 개수 리턴
	public static int dropAt(int wIdx, int [][] cpy) {
		Queue<coor> Q = new LinkedList<>();
		boolean [][]check = new boolean[H][W];
		int delCnt=0;
		// 가장 먼저 맞는 벽돌찾기
		for(int h=0;h<H;h++) {
			if(cpy[h][wIdx]>0) {
				Q.add(new coor(h,wIdx));
				check[h][wIdx]=true;
				break;
			}
		}
		
		// 벽돌 있으면 BFS 연쇄작용.
		while(!Q.isEmpty()) {
			coor curr = Q.poll();
			int range = cpy[curr.row][curr.col]-1;
			// 제거
			cpy[curr.row][curr.col] = 0;
			delCnt++;

			for(int d = 0; d<4;d++) {
				for(int r=1; r<=range;r++) {
					int rowD = curr.row+dr[d]*r;
					int colD = curr.col+dc[d]*r;
					// Boundary안에 있고 방문한 적 없는 벽돌이면 Q에 넣기
					if(rowD>=0 && rowD <H && colD>=0 && colD <W && !check[rowD][colD] && cpy[rowD][colD]>0) {
						Q.add(new coor(rowD,colD));
						check[rowD][colD] = true;
					}
				}
			}
		}
		return delCnt;
	}
	
	public static void gravity(int [][] cpy){
		for(int col=0; col<W;col++) {
			Stack<Integer> stk = new Stack<>();
			// 수거
			for(int row=0;row<H;row++) {
				if(cpy[row][col]>0) {
					stk.add(cpy[row][col]);
					cpy[row][col]=0;
				}
			}
			// 바닥부터 재배열
			int curR = H-1;
			while(!stk.isEmpty()) {
				cpy[curR][col] = stk.pop();
				curR--;
			}
		}
	}
	
	public static int[][] copy() {
		int [][] cpyBoard = new int[H][W];
		for (int row = 0; row < H; row++) {
			for (int col = 0; col < W; col++) {
				cpyBoard[row][col] = board[row][col];
			}
		}
		return cpyBoard;
	}

}
//End