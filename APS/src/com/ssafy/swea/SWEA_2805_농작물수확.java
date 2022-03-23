package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_2805_농작물수확 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {
			// 첫 행에서부터 한 행씩 처리할 것이고
			// 중앙 열축을 기준으로 행에 따라 반지름을 달리하여
			// 범위를 설정할 것이다.
		    int N = sc.nextInt();
		    int centerCol = N/2;
		    int sum=0;
		    char [] rowArr;
		    for (int row=0; row<N; row++) {
		    	// 하나의 행
		    	rowArr= sc.next().toCharArray();
		    	// 하나의 행에서 반지름이 어느 정도인지는 다음과 같다.
		    	int radius;
		    	if(row<=N/2) {
		    		radius = row;
		    	}else {
		    		radius = N-1-row;
		    	}
		    	// 중심 열축을 기준으로 반지름 내에 있는
		    	// 대상에 대해 sum 진행.
		    	for (int col=0; col<N; col++) {
		    		if( centerCol-radius <= col && col<= centerCol+radius ) {
		    			sum+=rowArr[col]-'0';
		    		}
		    	}
		    }
		    System.out.printf("#%d %d\n", tIdx, sum);	
		}
	}
}
//End