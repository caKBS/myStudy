package com.ssafy.swea;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// testCase 횟수
		for (int tIdx = 1; tIdx <= 10; tIdx++) {
			Stack<Character> charStack = new Stack();
			int caseNum = sc.nextInt();
			String testCase = sc.next();
			char[] caseChar = testCase.toCharArray();

			for (int caseIdx = 0; caseIdx < caseChar.length; caseIdx++) {
				// 스택 최상단과 새로운 입력이 세트면 둘다 날린다.
				if ((!charStack.isEmpty()) && ((charStack.peek() == '(' && caseChar[caseIdx] == ')')
						|| (charStack.peek() == '{' && caseChar[caseIdx] == '}')
						|| (charStack.peek() == '<' && caseChar[caseIdx] == '>')
						|| (charStack.peek() == '[' && caseChar[caseIdx] == ']'))) {
					charStack.pop();
				} else {
					charStack.push(caseChar[caseIdx]);
				}
			}
			if (charStack.isEmpty()) {
				System.out.printf("#%d %d\n", tIdx, 1);
			} else {
				System.out.printf("#%d %d\n", tIdx, 0);
			}
		}
	}
}
//End