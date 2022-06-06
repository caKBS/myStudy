package com.ssafy.boj.y22.m06.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BOJ_9375_패션왕신해빈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			// 입력받기
			int N = Integer.parseInt(br.readLine());
			Map<String,Integer> cloth = new HashMap<>();
			for(int i=0; i<N;i++) {
				String [] aline = br.readLine().split(" ");
				String cate = aline[1];
				if(cloth.containsKey(cate)) {
					cloth.replace(cate, cloth.get(cate)+1);
				}else {
					cloth.put(cate, 1);
				}
			}
			// HashMap의 모든 entry 꺼내서 계산에 사용
			int result = 1;
			for(Entry<String, Integer> entry : cloth.entrySet()) {
				result *= (entry.getValue()+1);
			}
			
			// 알몸인 경우 제거
			System.out.println(result-1);
		}

	}

	

	
}
//End