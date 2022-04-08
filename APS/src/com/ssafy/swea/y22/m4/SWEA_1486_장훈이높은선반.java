package com.ssafy.swea.y22.m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1486_장훈이높은선반 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {
			String [] NB = br.readLine().split(" ");
			
			int N = Integer.parseInt(NB[0]);
			int B = Integer.parseInt(NB[1]);
			
			String [] sH = br.readLine().split(" ");
			int [] H = new int [N];
			for (int h = 0; h < N; h++) {
				H[h] = Integer.parseInt(sH[h]);
			}
			// 최소하나는 있어야하므로 1부터 시작함
			// i는 각 case를 나타내는 bitstream
			int minSumH = Integer.MAX_VALUE;
			for(int i=1; i< (1<<N); i++) {
				int sumH=0;
				// j는 비트자리수
				for(int j=0; j< N; j++) {
					if ((i & (1<<j) ) > 0){
						sumH+=H[j];
					}
				}
				if(sumH>=B && sumH < minSumH) {
					minSumH = sumH;
				}
			}
			
			// 출력
			bw.write("#" + tc + " " + (minSumH-B) + "\n");
			bw.flush();
		}
	}
}
//End