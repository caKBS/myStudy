package com.ssafy.swea;

import java.util.Arrays;
import java.util.Scanner;

public class atoi_itoa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] charArr = { '5', '7', '1', '6' };

		int intArr = atoi(charArr);

		char[] newCharArr = new char[charArr.length];

		itoa(intArr, newCharArr);

		System.out.println("CharArr : " + Arrays.toString(charArr));
		System.out.println("intArr : " + intArr);
		System.out.println("newCharArr : " + Arrays.toString(newCharArr));
	}

	public static int atoi(char[] charArr) {
		int arrLen = charArr.length;
		int digit;
		int value = 0;

		for (int intIdx = 0; intIdx < arrLen; intIdx++) {
			if (charArr[intIdx] >= '0' && charArr[intIdx] <= '9') {
				digit = charArr[intIdx] - '0';
			} else {
				break;
			}
			value = 10 * value + digit;
		}
		return value;
	}

	public static void itoa(int intNum, char[] charArr) {
		int arrLen = charArr.length;
		for (int charIdx = arrLen - 1; charIdx >= 0; charIdx--) {
			// char는 int와 계산시에 큰놈인 int로 자동형변환.
			charArr[charIdx] = (char) (intNum % 10 + '0');
			intNum /= 10;
		}
	}

}

//End