package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_15829_Hashing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		char [] eng = br.readLine().toCharArray();
		long sumVal=0;
		for(int ec=0; ec<L;ec++) {
			sumVal+=(eng[ec]-'a'+1)*Math.pow(31, ec);
		}
		bw.write(String.valueOf(sumVal%1234567891));
		
		// 출력
		bw.flush();
	}

}
// End
