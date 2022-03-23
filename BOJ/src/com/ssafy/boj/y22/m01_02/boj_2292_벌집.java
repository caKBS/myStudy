package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_2292_벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//1로 부터 거리가 같은 애들을 한 묶음이 되도록.
		//N을 -2하면 '6의 배수 누적 직전' 수까지가 한 묶음이 된다.
		//ex) 1/2~7/8~19 -> -1/0~5/6~17
		int tmpN =N-2;
		
		int distance=0;
		while(tmpN>=0) {
			tmpN = tmpN-6*(++distance);
		}
		System.out.println(distance+1); 
	}
}
// End
