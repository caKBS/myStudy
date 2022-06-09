package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_14889_스타트와링크 {

	public static int N;
	public static int [][] S;
	public static int [] sel;
	public static int minVal;
	public static boolean [] team;
	
	public static StringBuilder sb;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		// 능력치의 차이의 최솟값 초기화
		minVal = Integer.MAX_VALUE;
		// 입력 받기
		N = Integer.parseInt(br.readLine());
		S = new int [N+1][N+1];
		for(int i=1; i<=N;i++) {
			String [] aline = br.readLine().split(" ");
			for(int j=1; j<=N; j++) {
				S[i][j] = Integer.parseInt(aline[j-1]);
			}
		}
		
		// 인덱스 1부터 사용
		team = new boolean[N+1];
		// 게임 시작
		// 데이터가 1부터 시작
		comb(1,0);
		
		// 출력
		System.out.println(minVal);

	}
	// 팀배정용 조합
	public static void comb(int idx, int sidx) {
		if(sidx==N/2) { // 팀배정완료
			// 팀 분배
			int [] start = new int[N/2];
			int [] link = new int [N/2];
			int idxs = 0;
			int idxl=0;
			for(int i=1; i<=N;i++) {
				if(team[i]) {
					start[idxs++] = i;
				}else {
					link[idxl++] = i;
				}
			} // 팀 분배 완료 
			// [1,4][2,3] 이나 [2,3][1,4]나 똑같은데 어떻게 거르지??ㅁㅁㅁㅁ
			// 타인코드는 걸렀나 보기ㅁㅁㅁㅁ

			// 각 팀의 powerSum 구하기
			sel = new int[2];
			int [] startSum = new int [1];
			int [] linkSum  = new int [1];
			powerSum(0,start,startSum,0);
			powerSum(0,link,linkSum,0);
			// powerSum 차이 구하고 기존 최솟값 보다 작으면 최솟값 갱신
			int diff = Math.abs(startSum[0]-linkSum[0]);
			minVal = Math.min(minVal, diff);

			return;
		}
		
		
		for(int i=idx; i<=N+1-N/2+sidx; i++) {
			team[i] = true;
			comb(i+1,sidx+1);
			team[i] =false;
		}
	}
	
	// N/2에서 2개를 순열
	public static void powerSum(int sidx, int [] data, int[] sum, int check) {
		
		if(sidx == 2) {
			// 능력치 산정할 2개 선택완료
			sum[0] += S[sel[0]][sel[1]];
			
			return;
		}
		
		for(int i=0; i<N/2; i++) {
			if((check & (1<<i)) != 0) {
				continue;
			}
			sel[sidx] = data[i];
			powerSum(sidx+1, data,sum, check | (1<<i));
		}
		
	}
	
}
//End