package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			boolean palin = true;
			char[] inArr = br.readLine().toCharArray();
			// 탈출조건
			if (inArr[0] == '0') {
				break;
			}
			
			int len = inArr.length;
			for(int idx=0; idx<=(len-1)/2; idx++) {
				if(inArr[idx]!=inArr[len-1-idx]) {
					palin=false;
					break;
				}
			}
			
			if(palin) {
				bw.write("yes\n");
			}else {
				bw.write("no\n");
			}
		}

		// 출력
		bw.flush();
	}

}
// End
