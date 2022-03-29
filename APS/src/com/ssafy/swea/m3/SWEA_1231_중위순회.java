package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1231_중위순회 {
	public static int N;
	public static String [] alphabet;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tnum = 10;
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");

			N = Integer.parseInt(br.readLine());
			// idx 1부터 사용
			alphabet = new String[N+1];
			for (int nc = 1; nc <= N; nc++) {
				// 저장을 string으로 하고
				// string으로 StringBuilder에 쌓고
				// 출력하면 편하다.
				String [] input = br.readLine().split(" ");
				alphabet[nc]= input[1];
			}
			// 탐색시작
			// idx는 내가 보고 있는 노드
			int nIdx=1;
			search(nIdx, sb);
			sb.append("\n");
			// 출력
			bw.write(sb.toString());
			bw.flush();
		}
	}
	public static void search(int nIdx, StringBuilder sb) throws IOException {
		//입력이 완전이진트리로 주어지므로 N초과의 노드는 존재하지 않는다.
		if(nIdx>N) {
			return;
		}
		//좌
		search(nIdx*2, sb);
		//중
		sb.append(alphabet[nIdx]);
		//우
		search(nIdx*2+1, sb);
	}
}
//End