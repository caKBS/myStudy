package com.ssafy.boj.y22.m01_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_1929_소수구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inNum = br.readLine();
		String[] Arr = inNum.split(" ");
		int M = Integer.parseInt(Arr[0]);
		int N = Integer.parseInt(Arr[1]);


		for (int num = M; num <= N; num++) {
			if (isPrime(num)) {
				bw.write(num + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

	public static boolean isPrime(int N) {
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0) {
				return false;
			}
		}
		if (N == 1) {
			return false;
		} else {
			return true;
		}
	}
}
// End
