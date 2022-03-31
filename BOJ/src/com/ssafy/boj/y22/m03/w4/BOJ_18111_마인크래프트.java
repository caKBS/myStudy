package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String [] NMB =  br.readLine().split(" ");
		int N = Integer.parseInt(NMB[0]);
		int M = Integer.parseInt(NMB[1]);
		int B = Integer.parseInt(NMB[2]);
		int area = N*M;
		
		int [] playGnd = new int[area];
		// 형변환에의한 손실을 막기 위해
		// 나눌목적의 sum은 double로 해줘야한다.
		// 고로 그냥 sum은 무조건 double로 하자.
		double sumVal=0;
		int maxH = -1;
		int minH = 257;
		for(int nc=0; nc<N;nc++) {
			String [] aLine =  br.readLine().split(" ");
			for(int mc=0; mc<M;mc++) {
				// 해당 좌표의 높이 추출
				playGnd[nc*M+mc] = Integer.parseInt(aLine[mc]);
				// 총합
				sumVal+= playGnd[nc*M+mc];
				// 최대최소
				maxH = Math.max(maxH, playGnd[nc*M+mc]);
				minH = Math.min(minH, playGnd[nc*M+mc]);
			}
		}
		Arrays.sort(playGnd);
		
		int timeMin = Integer.MAX_VALUE;
	    int targetHeight = -1;
		for(int targetH=minH; targetH<=maxH;targetH++) {
			// 빼기는 바로 인벤으로 가고 쌓기는 인벤에서만 가져오니
			// 빼기와 쌓기는 서로 독립적이다.
			// 초기인벤값은 원하는 높이로 평탄화를 할 수 있냐 없냐만 결정.
			// 목표점이 불가능하면
			// target*area는 목표점으로 평탄화하는데 필요한 총 블록 개수
			// sumVal+B 는 사용할 수 있는 총 블록 개수
			if(targetH*area > sumVal+B) {
				continue;
			}
			int time = 0;
			// 쌓기/파기 판단하고 시간계산
			for(int gndIdx=0; gndIdx < area;gndIdx++) {
				// 쌓기
				if(playGnd[gndIdx]< targetH) {
					time += (targetH-playGnd[gndIdx])*1 ;
				// 파기
				}else if(playGnd[gndIdx] > targetH){
					time += (playGnd[gndIdx]-targetH)*2 ;
				}
			}
			// 기존 최소이하이면 교체.
			// equal은 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력하기 위함.
			if( time <= timeMin) {
				timeMin =time;
				targetHeight = targetH;
			}
		}
		bw.write(timeMin+" "+targetHeight);

		// 출력
		bw.flush();
	}
}
// End
