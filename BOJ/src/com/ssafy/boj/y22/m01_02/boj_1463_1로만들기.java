package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		// 마지막 iteration에서 3*(X-1)까지 idx를 사용함.
		// 각 숫자를 인덱스로 사용, 값은 그 숫자를 1로 만들기
		// 위한 횟수
		int [] depth = new int [3*X];
		// 숫자1은 0번의 횟수를 가짐.
		depth[1] = 0;
		
		// 현재 숫자의 +1인 수, *2인 수,*3인 수는
		// 현재 숫자와 1회의 최소 경로 횟수 차이를 가진다.
		// min(depth[xIdx+1], depth[xIdx]+1);에서
		// depth[xIdx+1]는 이전에 누군가가 만들어 놓은 최소 depth이다.
		for (int xIdx = 1; xIdx < X; xIdx++) {
			depth[xIdx+1] = min(depth[xIdx+1], depth[xIdx]+1);
			depth[xIdx*2] = min(depth[xIdx*2], depth[xIdx]+1);
			depth[xIdx*3] = min(depth[xIdx*3], depth[xIdx]+1);
		}

		System.out.println(depth[X]);
	}

	public static int min(int existVal, int newVal) {
		// 아직 초기화값 그대로인 애들은 최소계산에
		// 포함되지 않도록 한다.
		if(existVal==0) {
			return newVal;
		}
		else if ( existVal > newVal) {
			return newVal;
		} else {
			return existVal;
		}
	}

}
// End
