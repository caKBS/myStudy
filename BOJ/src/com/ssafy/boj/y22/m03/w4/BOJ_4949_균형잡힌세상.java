package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			boolean balance = true;
			Stack<Character> stk = new Stack<>();
			char[] inArr = br.readLine().toCharArray();
			// 탈출조건
			if (inArr[0] == '.') {
				break;
			}
			// 스택으로 열림과 닫힘의 균형 판단
			// 균형의 조건 : 
			// - 열림괄호와 닫힘괄호의 "짝"과 "개수"가 맞아야한다.
			// - for문에서 짝을 판단하고 for직후 isEmpty로 개수를 판단한다.
			for (int idx = 0; balance == true && idx < inArr.length; idx++) {
				switch (inArr[idx]) {
				case '(':
					stk.add('(');
					break;
				case '[':
					stk.add('[');
					break;
				case ')':
					// 비어있거나 피크에 열림괄호가 있지 않으면 실패
					if (stk.size() == 0 || stk.peek() != '(') {
						balance = false;
						break;
					} else {
						stk.pop();
						break;
					}
				case ']':
					// 비어있거나 피크에 열림괄호가 있지 않으면 실패
					if (stk.size() == 0 || stk.peek() != '[') {
						balance = false;
						break;
					} else {
						stk.pop();
						break;
					}
				default:
					break;
				}
			}
			// for문을 끝내고 stack이 완전히 비어있어야 균형이다.
			if(balance==true && stk.isEmpty()) {
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
