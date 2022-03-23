package com.ssafy.swea;

import java.util.Scanner;

public class patternSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sentence = sc.next();
		
		String pattern = sc.next();

		int sIdx = 0;
		int pIdx = 0;
		// 같을때 s와p가 같이 가다가 다르면 s는 같이 온만큼 후퇴하고
		// p는 같이 온 만큼-1 만큼 후퇴
		// 같을 때 사용하는 sIdx += 1; pIdx += 1;를 함께 사용하기 위해
		// 후퇴를  s보다 p를 1칸 더 하는 것. s는 후퇴 후 다음 라운드를 위해
		// 이전 라운드보다 한칸 더 앞으로 가야하므로.
		while (pIdx < pattern.length() && sIdx < sentence.length()) {
			if (pattern.charAt(pIdx) != sentence.charAt(sIdx)) {
				sIdx = sIdx-pIdx;
				pIdx = -1;
			}
			sIdx += 1;
			pIdx += 1;
		}

		if (pIdx == pattern.length()) {
			System.out.println(sIdx - pattern.length());
		} else {
			System.out.println(-1);
		}
	}
}
//End