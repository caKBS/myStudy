package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1289_원재메모리복구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {
			int cnt = 0;
			char[] mem = sc.next().toCharArray();
			// 0->1,1->0으로 숫자가 전환될때마다 카운트한다.
			// 첫번째 숫자가 이전에 보이지 않는 0이 있다고 간주하고
			// 첫번째 숫자 1이면 한번 전환된 것으로 본다.
			if (mem[0] == '1') {
				cnt++;
			}
			// 숫자가 전환되면 카운트한다.
			for (int mIdx = 1; mIdx <= mem.length - 1; mIdx++) {
				if (mem[mIdx] != mem[mIdx - 1]) {
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", tIdx, cnt);
		}
	}
}
//End