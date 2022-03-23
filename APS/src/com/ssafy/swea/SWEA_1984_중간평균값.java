package com.ssafy.swea;

import java.util.Scanner;

public class SWEA_1984_중간평균값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnum = sc.nextInt();
		int caseLen = 10;

		// 테스트케이스 10개
		for (int tIdx = 1; tIdx <= tnum; tIdx++) {

			// 첫값을 max이자 min으로 설정, 첫값을 먼저 sum에 넣어줌.
			int val_1st = sc.nextInt();
			int max = val_1st;
			int min = val_1st;
			int sum = val_1st;
			// 받은 값들을 모두 sum에 넣어주면서 max,min만 따로 저장
			for (int cIdx = 1; cIdx <= caseLen-1; cIdx++) {
				int newNum = sc.nextInt();
				sum += newNum;
				if (newNum > max) {
					max = newNum;
				} else if (newNum < min) {
					min = newNum;
				}
			}
			// sum에서 max,min 빼고 8나눠서 중간평균값 계산
			// *오답노트 :
			// double midAvg = (sum - max - min) / 8; 을 하면
			// "(sum - max - min) / 8"의 결과는 int로서
			// 일단 소수점 아래가 제거되고
			// 그후 double로 형변환되서 midAvg에 저장되기 때문에
			// 반올림을 할 수 없는 상태가 된다.
			// 고로 (double)로 먼저 형변환 해주어서
			// "(sum - max - min) / 8"의 결과가 double로서
			// 소수점 아래까지 모두 살아있게 하자.
			double midAvg = (double)(sum - max - min) / 8;

			// 소수점 첫째 자리에서 반올림한 정수를 출력
			System.out.printf("#%d %d\n", tIdx, (int)(midAvg+0.5));
		}
	}
}
//End