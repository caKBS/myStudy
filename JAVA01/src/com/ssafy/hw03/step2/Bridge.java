package com.ssafy.hw03.step2;

import java.util.Scanner;

public class Bridge {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int max = 0;

		// 입력으로 2차원 배열 생성
		int[][] geo = new int[num + 1][num + 1];
		for (int i = 1; i < num + 1; i++) {
			for (int j = 1; j < num + 1; j++) {
				geo[i][j] = sc.nextInt();
			}
		}

		// 행에 대해 첫열부터 마지막 직전 열까지 스캔
		for (int i = 1; i < num; i++) {
			int count = 0;
			boolean cntOn = false;
			boolean findEnd = false;
			for (int j = 1; j < num; j++) {
				// 본인 1, 다음 0을 가지면 다리의 시작로 판단하고 count를 On한다.
				// findEnd는 다리의 끝을 찾았을때 On 된다.
				if ((geo[i][j] == 1) && (geo[i][j + 1] == 0)) {
					cntOn = true;
					findEnd = false;
				}
				// 본인 0, 다음 1을 가지면 다리의 끝으로 판단하고 count를 Off한다.
				// 다리의 끝을 찾았으므로 findEnd를 On한다.
				if ((geo[i][j] == 0) && (geo[i][j + 1] == 1)) {
					cntOn = false;
					findEnd = true;
				}
				// Count를 On하면 Count가 하나씩 커진다.
				if (cntOn) {
					count++;
				}
				// 다리의 끝을 발견했고 Count가 기존 최대치보다 크면 최대치(max)를 업데이트한다.
				if (findEnd && (count > max)) {
					max = count;
				}
				// count를 0으로 초기화하고 다음 행에 대해 똑같은 프로세스를 반복한다.
				if (!cntOn) {
					count = 0;
				}
			}
		}

		// 열에 대해 첫행부터 마지막 직전 행까지 스캔 (위와 프로세스 동일)
		for (int i = 1; i < num; i++) {
			int count = 0;
			boolean cntOn = false;
			boolean findEnd = false;
			for (int j = 1; j < num; j++) {
				if ((geo[j][i] == 1) && (geo[j + 1][i] == 0)) {
					cntOn = true;
					findEnd = false;
				}
				if ((geo[j][i] == 0) && (geo[j + 1][i] == 1)) {
					cntOn = false;
					findEnd = true;
				}
				if (cntOn) {
					count++;
				}
				if ((count > max) && findEnd) {
					max = count;
				}
				if (!cntOn) {
					count = 0;
				}
			}

		}

		// 본 코드가 센건 0의 개수이고 다리의 길이는 0의 개수+1개 이므로 max에 +1을 한다.
		System.out.println((max + 1));

	}

}
//End
