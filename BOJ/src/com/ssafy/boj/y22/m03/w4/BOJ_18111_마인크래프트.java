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
		
		int [][] playGnd = new int[N][M];
		int [] freq = new int[257];
		// 형변환에의한 손실을 막기 위해
		// 나눌목적의 sum은 double로 해줘야한다.
		// 고로 그냥 sum은 무조건 double로 하자.
		double sumVal=0;
		for(int nc=0; nc<N;nc++) {
			String [] aLine =  br.readLine().split(" ");
			for(int mc=0; mc<M;mc++) {
				// 해당 좌표의 높이 추출
				playGnd[nc][mc] = Integer.parseInt(aLine[mc]);
				// 높이값 누적
				sumVal+=playGnd[nc][mc];
				// 높이값 빈도 계산
				freq[playGnd[nc][mc]]++;
			}
		}
		// 빼기는 바로 인벤으로 가고 쌓기는 인벤에서만 가져오니
		// 빼기와 쌓기는 서로 독립적이다.
		// 초기인벤값은 원하는 높이로 평탄화를 할 수 있냐 없냐만 결정.
		// 목표점은 시간비율이 쌓기:제거 = 1:2 이므로
		// 높이값 총합을 2:1비율로 나눈 곳이다.
		int target = (int)(Math.round(sumVal/area));

		
		// 목표점이 불가능하면
		// target*area는 목표점으로 평탄화하는데 필요한 총 블록 개수
		// sumVal+B 는 사용할 수 있는 총 블록 개수
		if(target*area > sumVal+B) {
			// ( (총합+초기인벤토리량) / 총 개수 ) 의 버림
			target = (int)((sumVal+B)/area);
		}
		// 목표점 미만은 쌓기만, 목표점 초과는 제거만
		// (목표점과 나의 차이값) * 나의 빈도 * 작업 시간
		int totalTime = 0;
		for(int bc=0; bc<target;bc++) {
			totalTime+=(target-bc)*freq[bc]*1;
		}
		for(int ad=target+1; ad<=256;ad++) {
			totalTime+=(ad-target)*freq[ad]*2;
		}

		
		// 디버깅
//		for(int nc=0; nc<N;nc++) {
//			for(int mc=0; mc<M;mc++) {
//				System.out.print(playGnd[nc][mc]+" ");
//			}
//			System.out.println();
//		}
		
		bw.write(totalTime+" "+target);
		
		
		// 출력
		bw.flush();
	}

}
// End
