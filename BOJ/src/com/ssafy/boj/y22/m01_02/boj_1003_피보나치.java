package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_1003_피보나치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//받은 테스트 케이스 중 가장 큰 값까지 전부 계산해놓고
		//원하는 테스트 케이스를 출력하기 위해 max를 도입
		//예를 들어, 테스트케이스가 3,5,18이면
		//0~18까지 모두 계산해놓고 3,5,18일때의 값을 출력.
		int num = sc.nextInt();
		int[] in = new int[num];
		int max = 0;
		for (int i = 0; i < num; i++) {
			in[i] = sc.nextInt();
			if (in[i] > max) {
				max = in[i];
			}
		}

		// 1차원 인덱스는 테스트 케이스 값을 의미하고 2차원인덱스는 출력되는 0,1을 의미
		// 저장된 값은 출력되는 횟수를 의미
		// 예를 들어, Arr[7][0]은 숫자7을 제시된 피보나치 코드에 돌릴때 출력되는 0의 횟수이고
		// Arr[7][1]는 같은 상황에서 출력되는 1의 횟수이다.
		int[][] Arr = new int[50][2];
		Arr[0][1] = 0;
		Arr[0][0] = 1;
		Arr[1][1] = 1;
		Arr[1][0] = 0;

		//현재 수의 1의 출력 개수는 이전 두수의 1의 출력개수의 합이다.(0도 마찬가지)
		//트리를 그려보면 직관적으로 알 수 있다.
		for (int i = 2; i <= max; i++) {
			Arr[i][1] = Arr[i - 1][1] + Arr[i - 2][1];
			Arr[i][0] = Arr[i - 1][0] + Arr[i - 2][0];
		}

		for (int i = 0; i < num; i++) {
			System.out.println(Arr[in[i]][0] + " " + Arr[in[i]][1]);
		}

	}
}
// End
