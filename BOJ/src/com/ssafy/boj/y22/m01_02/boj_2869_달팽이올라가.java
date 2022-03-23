package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2869_달팽이올라가 {
	public static void main(String[] args) throws IOException {
		// 규칙 : 무조건 상승을 하강보다 1회 더한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inNum = br.readLine();
		String[] Arr = inNum.split(" ");

		int A = Integer.parseInt(Arr[0]);
		int B = Integer.parseInt(Arr[1]);
		int V = Integer.parseInt(Arr[2]);

		// 막타를 full로 상승한다고 가정하고 1회 선반영
		int result = 1;
		int V1 = V - A;

		// (A-B)로 얼마나 갈 수 있나.
		// (V-A) / (A - B)는 최소의 상하강 동일 횟수
		result += V1 / (A - B);
		// (V-A) % (A - B)==0일때는 나머지가 없고 막타가 full
		// (V-A) % (A - B)!=0는 나머지가 있고 막타가 full이 아니므로
		// 나머지를 한 세트(A,B) 더 실행함으로써 보상하기 위해
		// (나머지+막타에 필요한 만큼 끌어온 양)을 한 세트로 처리
		if (V1 % (A - B) != 0) {
			result += 1;
		}

		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
}
// End
