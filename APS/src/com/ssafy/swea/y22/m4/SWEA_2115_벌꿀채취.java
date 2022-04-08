package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SWEA_2115_벌꿀채취 {
	public static int N;
	public static int M;
	public static int C;
	public static int[][] board;
	public static int[] setA;
	public static int[] combA;

	// * 한 세트의 크기는 원소들의 제곱합
	// 요구사항 : 붙어있지 않은 두 세트의 합이 최대
	// 목표 : 붙어있지 않은 두 세트를 어떻게 얻을 것인가
	// 해결방안 : 1등세트, 2등세트 공간을 만들고 처음부터 스캔하면서
	// - 1등세트, 2등세트 공간에 크기에 따라 넣는다.
	// - 여기서 중요한 점은 겹치는 원소 처리
	// 새로 들어오는 원소가 
	// 1등보다 클때 : 1.1등과 겹치면 새로 들어온게 일등, 원래거는 삭제
	//                2. 1등과 안겹치면 새로 들어온게 일등, 원래거는 2등으로
	// 1등보다 작, 2등보다 큼 : 1. 1등과 겹치면 새로 들어오는 거 버리기
	//                          2. 1등과 안겹치면 새로 들어온게 2등
	// - 가장 큰 원소가 무조건 1등에 오도록 하고
	// - 2등은 가장 큰 원소와 안겹치는 원소 중 가장 큰 원소가 오도록 한다.
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		int tnum = Integer.parseInt(br.readLine());
//		// testCase 횟수
//		for (int tc = 1; tc <= tnum; tc++) {
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		C = Integer.parseInt(data[2]);
		board = new int[N][N];

		// 입력받기
		for (int r = 0; r < N; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
			}
		}

		// 2세트 고르는 경우의 수
		for (int r = 0; r < N; r++) {
			for (int c = 0; c + M < N; c = c + M) {
				// A세트
				setA = new int[M];
				int sum = 0;
				for (int idxA = c; idxA < c + M; idxA++) {
					setA[idxA - c] = board[r][idxA];
					sum += board[r][idxA];
				}
				//합이 제한보다 크면
				if (sum > C) {
					// comb생성
					for (int i = M - 1; i > 0; i++) {
						combA = new int[i];
//						if (combSum(i) <= C) {
//							setA = combA;
//							break;
//						}
					}
				}
				// B세트

			}
		}

//			// 디버깅
//			for (int r = 0; r < N; r++) {
//			System.out.println(Arrays.toString(board[r]));
//			}
//			

//			// 출력
//			bw.write("#" + tc + " " + minVal + "\n");
//			bw.flush();
//		}
	}

	public static void comb(int idx, int sidx, int R) {
		if(sidx == R) {
			// 조합 생성
			int sum=0;
			for(int i=0; i<R; i++) {
				sum = combA[i];
			}
			
			
			
		}
		
		for(int i=idx; i<=N-R+sidx; i++) {
			combA[sidx] = setA[i];
			comb(idx+1,sidx+1,R);
		}
		

	}
}
//End