package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class SWEA_1247_최적경로 {
	public static int[][] board;
	public static int N;
	public static int minRoad;
	public static List<coor> csList;
	public static coor [] csPerm;

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

			// 고객 좌표 리스트
			csList = new ArrayList<>();
			// 맨 앞에 회사, 맨 뒤에 집을 먼저 저장하고
			// 나머지 (1 ~ N+1)에 대해 순열 생성
			csPerm = new coor[N+2];

			// 입력받기
			String[] aLine = br.readLine().split(" ");
			coor work = new coor(Integer.parseInt(aLine[0]),Integer.parseInt(aLine[1]));
			coor home = new coor(Integer.parseInt(aLine[2]),Integer.parseInt(aLine[3]));

			for (int idx = 4; idx < aLine.length; idx=idx+2) {
				csList.add(new coor(Integer.parseInt(aLine[idx]),Integer.parseInt(aLine[idx+1])));
			}
			
			// 순열생성재귀로 길이를 파라미터로 계속 가지고 가면서 가지치기
			// 비트마스킹을 통한 순열 생성으로 구현해보자
			minRoad = Integer.MAX_VALUE;
			// 첫칸은 회사가 먹는다.
			csPerm[0]=work;
			// 마지막칸은 홈이 먹는다.
			csPerm[N+1]=home;
			// perm은 idx=1부터 시작(첫칸은 회사가 먹었으므로), check==0, 이동거리==0;
			perm(1,0,0);

			// 출력
			bw.write("#" + tc + " " + minRoad + "\n");
			bw.flush();
		}
	}

	public static void perm(int idxPerm, int check, int totalR) {
		// csPerm의 첫칸은 회사가 쓸 것이다.
		if(idxPerm == N+1) {
			// 순열생성완료
			// Last Mile 반영해주기
			int road = totalR+ Math.abs(csPerm[N+1].getRow()-csPerm[N].getRow())
			+ Math.abs(csPerm[N+1].getCol()-csPerm[N].getCol());
			if(road < minRoad) {
				minRoad = road;
			}
			return;
			
		}
		for(int i=0; i< N; i++) {
			// 앞선 자리수와의 중복 방지
			if( ( check & (1<<i) ) > 0) {
				continue;
			}
			// 순열 배열에 해당 값 넣기
			csPerm[idxPerm] =  csList.get(i);
		    // 현재 장소와 이전 장소간 이동거리 구해서 누적
			int road = totalR+ Math.abs(csPerm[idxPerm].getRow()-csPerm[idxPerm-1].getRow())
			+ Math.abs(csPerm[idxPerm].getCol()-csPerm[idxPerm-1].getCol());
			// 이게 기존 최소보다 크거나 같으면 불필요한 경로이므로 가지치기.
			if(road >= minRoad) {
				return;
			}
			// 순열 배열의 다음 값 채우러 가자
			perm(idxPerm+1, check | (1<<i), road);
		}

	}
}
//End