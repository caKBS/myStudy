package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_5099_피자굽기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			int pizIdx = 0;
			int chzIdx = 1;
			int N = sc.nextInt();
			int M = sc.nextInt();

			// [피자번호, 치즈양]
			int[][] whaduk = new int[N][2];
			// waitIdx++을 위해 여유공간
			int[][] wait = new int[M - N + 1][2];
			// 화덕에 가능한 가득 넣고 나머지는 대기열에 저장
			for (int nIdx = 0; nIdx < M; nIdx++) {
				if (nIdx < N) {
					whaduk[nIdx][pizIdx] = nIdx + 1;
					whaduk[nIdx][chzIdx] = sc.nextInt();
				} else {
					wait[nIdx - N][pizIdx] = nIdx + 1;
					wait[nIdx - N][chzIdx] = sc.nextInt();
				}
			}
			int whadukIdx = 0;
			int waitIdx = 0;
			int zeroCnt = 0;
			int ansIdx = 0;
			// 화덕의 크기만큼 연속으로 zero가 나오면 끝난거다.
			while (zeroCnt != N) {
				// 꺼낼때 나누기2 된다고 생각해도 등가
				whaduk[whadukIdx][chzIdx] /= 2;
				// zero인 애들의 개수를 센다.
				if (whaduk[whadukIdx][chzIdx] == 0) {
					zeroCnt++;
					// zeroCnt를 증가시킬때 Idx를 정답Idx에 넣는다.
					// 마지막 iteration에서 여기서 답을 얻었는데 뒤에서
					// (whadukIdx + 1) % N를 하기 때문에 미리 저장해둠.
					ansIdx = whadukIdx;
					// 연속인 zero의 개수가 필요하니 연속이 아닐땐 리셋
				} else {
					zeroCnt = 0;
				}
				// 피자 새로 투입
				// wait의 맨끝 여유공간에 도착하면 하지않음->더이상 투입할 피자가 없다.
				if (waitIdx != M - N && whaduk[whadukIdx][chzIdx] == 0) {
					whaduk[whadukIdx] = wait[waitIdx++];
					zeroCnt = 0;
				} else {
					whadukIdx = (whadukIdx + 1) % N;
				}
			}
			System.out.printf("#%d %d\n", tIdx, whaduk[ansIdx][pizIdx]);
		}
	}
}
//End