package com.ssafy.boj.y22.m06.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class BOJ_1789_수들의합 {

	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		long N = Long.parseLong(br.readLine());
		int a = 0;
		// S를 구성하는 숫자는
		// 1부터 연속적으로 모든 숫자를 다 더하다가
		// 마지막 숫자만 연속적이지 않은 수이다.
		// 그럼 연속적인 수가 어디까지 이어지냐를 확인하기 위해
		// 누적을 사용하면 특정 수까지 누적보다 크고 (특정 수+1)까지 누적보다 작으면
		// 연속적인 수는 특정 수까지이다.
		// 예를 들면 S=200일때,
		// 19까지의 누적은 190이고 20까지의 누적은 210이다.
		// 그럼 우리가 S=200을 문제조건에 따라 구성하기 위해선
		// 1+2+...+18+19 +10인데 여기서 마지막에 더해지는 비연속적 수는
		// 무조건 다음 차례인 20보다 작다.-> 이미 한번 사용된 수이다.
		// 그러면 다음 연속 숫자를 사용해 중복을 제거하기 위해
		// 비연속 숫자 10을 사용해 다음 연속 숫자 20을 만들 수 있는 누군가를 하나 픽한다.
		// 여기선 연속숫자 중 10이 비연속숫자 10과 합쳐져 20이되고 계산이 완료된다.
		// 이때 총개수는 비연속 숫자와 무조건 같다!!
		while (N > 0) {
			a++;
			N -= a;
		}

		if (N == 0) {
			System.out.println(a);
		}
		if (N < 0) {
			System.out.println(a - 1);
		}

	}

}
//End