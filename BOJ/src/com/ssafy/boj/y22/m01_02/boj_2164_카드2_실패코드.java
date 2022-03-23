package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;

public class boj_2164_카드2_실패코드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] Arr = new int[N + 1];
		int div = 1;
		for (int nIdx = 1; nIdx <= N; nIdx++) {
			if(N%2==0) {
			Arr[nIdx] = nIdx;
			}else {
				Arr[nIdx] = N-nIdx+1;
			}
		}
		do {
			for (int nIdx = 1; nIdx <= N / div; nIdx++) {
				if (nIdx % 2 == 0) {
					Arr[nIdx / 2] = Arr[nIdx];
				}
			}
			div *= 2;
			if ((N / div) % 2 == 1) {
				for (int nIdx = 1; nIdx <= (N / div) / 2; nIdx++) {
					int tmp = Arr[nIdx];
					Arr[nIdx] = Arr[N / div - nIdx + 1];
					Arr[N / div - nIdx + 1] = tmp;
				}
			}
		} while (N / div >= 1);
		System.out.println(Arr[1]);
	}
}
// End
