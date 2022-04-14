package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class SWEA_4012_요리사 {
	public static int N;
	public static int minDiff;
	public static  int [][] S;
	
	public static class sum{
		int store = 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			N = Integer.parseInt(br.readLine());

			// 좌, 상에 크기1짜리 패딩
			S = new int[N+1][N+1];

			
			// 입력받기
			for (int row = 1; row < N+1; row++) {
				String[] sInfo = br.readLine().split(" ");
				for (int col = 0; col < N; col++) {
					S[row][col+1] = Integer.parseInt(sInfo[col]);
				}
			}
			
			int [] dish1 = new int [N/2]; 
			// 재료 반반 나눌때 사용하는 체크 배열
			boolean [] check = new boolean [N+1];
			// 테스트케이스 마다 최소차이 초기화
			minDiff=Integer.MAX_VALUE;
			// N/2사이즈 요리 두개로 나누기
			comb(1,0,dish1,check);
			
			// 출력
			bw.write("#" + tc + " " + minDiff + "\n");
			bw.flush();
		}
	}
	
	// 재료를 반반으로 나눠서 2가지 요리 구성.
	public static void comb(int idx, int sidx, int [] dish1,boolean [] check) {
		if(sidx == N/2) {
			List<Integer> dish2List = new LinkedList<>(); 
			for(int i =1; i<=N; i++) {
				// dish1에 담기지 않은 애들을 dish2에 담는다.
				if(!check[i]) {
					dish2List.add(i);
				}
			}
			// LinkedList를 Array로 바꿔준다.(combS 파라미터 타입에 맞추기 위해)
			int [] dish2 = new int [N/2];
			for(int i=0; i<N/2;i++) {
				dish2[i] = dish2List.get(i);
			}
			//// dish1, dish2 생성 완료////
			// sum값을 객체로 해서 combS메서드 안에서 추가한 값이 여기 sumN에 반영될 수 있도록 했다.
			sum sum1 = new sum();
			sum sum2 = new sum();
			// 가능한 시너지를 모두 sumN에 더한다.
			combS(0,0,dish1,new int[2],sum1);
			combS(0,0,dish2,new int[2],sum2);
			// 최소 차이이면 갱신
			int dif = Math.abs(sum1.store-sum2.store);
			minDiff = Math.min(minDiff, dif);
			////////////////////////
			return;
		}else if(idx==N+1) {
			return;
		}
		
		dish1[sidx] = idx;
		// 현재꺼 선택
		check[idx]=true;
		comb(idx+1,sidx+1,dish1,check);
		check[idx]=false;
		
		// 현재꺼 선택x
		comb(idx+1,sidx,dish1,check);
	}
	
	// 하나의 요리안에서 시너지를 계산할 2개 재료를 뽑고 해당 요리 시너지sum에 반영
	public static void combS(int idx, int sidx, int [] ingre, int [] synergy, sum sumN) {
		if(sidx==2) {
			// synergy[2] 생성 완료
			sumN.store += S[synergy[0]][synergy[1]];
			sumN.store += S[synergy[1]][synergy[0]];
			///////////////////////
			return;
		}else if(idx==N/2) {
			return;
		}
		
		synergy[sidx]=ingre[idx];
		// 현재거 선택
		combS(idx+1,sidx+1,ingre,synergy,sumN);
		//현재거 선택x
		combS(idx+1,sidx,ingre,synergy,sumN);
		
	}
}
//End