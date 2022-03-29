package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1233_사칙연산유효성 {
	public static int N;
	public static String [] alphabet;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tnum = 10;
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc);

			N = Integer.parseInt(br.readLine());
			int result=1;
			// leaf에는 숫자만, 이외에는 연산자만
			for (int nc = 1; nc <= N; nc++) {
				String [] input = br.readLine().split(" ");
				// leaf이외에 숫자가 있는 경우
				if(input.length >=3 && !input[1].equals("+") && !input[1].equals("-")
						&& !input[1].equals("*") && !input[1].equals("/")) {
					result=0;
				}
				// leaf에 연산자가 있는 경우
				if(input.length < 3 && (input[1].equals("+")|| input[1].equals("-")
						|| input[1].equals("*") || input[1].equals("/"))) {
					result=0;
				}
						
			}

			sb.append(" "+result+"\n");
			// 출력
			bw.write(sb.toString());
			bw.flush();
		}
	}

}
//End