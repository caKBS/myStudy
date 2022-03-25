package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BOJ_11866_요세푸스문제0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int K = Integer.parseInt(inArr[1]);

		Queue<Integer> yoseQ = new LinkedList<Integer>();

		// 초기화 - 1~K 넣기
		for (int nc = 1; nc <= N; nc++) {
			yoseQ.add(nc);
		}

		bw.write("<");
		// K-1번 poll&add, 1번 poll
		while (true) {
			for(int kc=1; kc<=K-1;kc++) {
			yoseQ.add(yoseQ.poll());
			}
			// 무조건 여기 직후 Queue가 텅 빌 수 있다.
			// BufferedReader/Writer는 스트링만 취급한다.
			bw.write(String.valueOf(yoseQ.poll()));
			if (yoseQ.isEmpty()) {
				break;
			}
			bw.write(", ");
		}
		bw.write(">");
		
		// 출력
		bw.flush();
		bw.close();
	}
}
// End
