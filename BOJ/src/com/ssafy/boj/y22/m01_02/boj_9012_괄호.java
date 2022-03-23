package com.ssafy.boj.y22.m01_02;

import java.util.Scanner;
import java.util.Stack;

public class boj_9012_괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();

		// testCase 횟수
		for (int tIdx = 1; tIdx <= tNum; tIdx++) {
			Stack<Character> charStack = new Stack();
			String testCase = sc.next();
			char[] caseChar = testCase.toCharArray();

			for (int caseIdx = 0; caseIdx < caseChar.length; caseIdx++) {
				// 스택 최상단과 새로운 입력이 세트면 둘다 날린다.
				if ( !charStack.isEmpty() && charStack.peek() == '(' && caseChar[caseIdx] == ')' ) {
					charStack.pop();
				} else {
					charStack.push(caseChar[caseIdx]);
				}
			}
			if (charStack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
// End
