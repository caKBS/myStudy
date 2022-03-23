package com.ssafy.swea;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> code = new LinkedList<Integer>();
		System.out.println(code);
		code.add(0, 999);
		System.out.println(code);
		code.add(-1);  //idx0
		code.add(234); //idx1
		code.add(124); //idx2
		code.add(634); //idx3
		code.add(754); //idx4
		code.add(6, 841);
		System.out.println(code);
	}
}
//End