package com.ssafy.swea.m3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_2930_힙_PriorityQueue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tnum = Integer.parseInt(br.readLine());

		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
			bw.write("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());
			for (int nc = 1; nc <= N; nc++) {

				String input = br.readLine();
				int order = 0;
				int toInsert = 0;
				if (input.length() == 1) {
					order = Integer.parseInt(input);
				} else {
					String[] inputS = input.split(" ");
					order = Integer.parseInt(inputS[0]);
					toInsert = Integer.parseInt(inputS[1]);
				}

				switch (order) {
				// Insert
				case 1:
					pQ.add(toInsert);
					break;
				// delete
				case 2:
					if(pQ.size()==0) {
						bw.write(-1+" ");
						break;
					}
					bw.write(pQ.poll()+" ");
					break;
				}
			}
			bw.write("\n");
			// 출력
			bw.flush();
		}
	}
}
//End