package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class 약수_1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력받기
		int num = sc.nextInt();
		int[] Arr = new int[num];
		for (int i = 0; i < num; i++) {
			Arr[i] = sc.nextInt();
		}
		sc.close();

		// 오름차순 정렬
		int buf = 0;
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < num - 1; i++) {
				if (Arr[i] > Arr[i + 1]) {
					buf = Arr[i];
					Arr[i] = Arr[i + 1];
					Arr[i + 1] = buf;
					flag = true;
				}
			}
		}
		
		//출력, 어떤 수의 약수의 배열은 곱셈에 대해 대칭적이다.
		//예를 들어 6의 약수는 1,2,3,6 이고 1*6=2*3=6이다.
		//이를 이용하면, 진짜 약수가 홀수개이면 가운데 있는 약수의 제곱이 원래 수이고
		//진짜 약수가 짝수개이면 가운데의 양옆의 곱이 원래 수이다.
		if (num % 2 == 1) {
			System.out.println(Arr[num / 2] * Arr[num / 2]);
		} else {
			System.out.println(Arr[num / 2 - 1] * Arr[num / 2]);
		}

	}

}
// End
