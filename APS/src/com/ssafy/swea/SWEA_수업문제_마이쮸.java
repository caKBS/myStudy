package com.ssafy.swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_수업문제_마이쮸 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int numIdx = 0;
		int cntIdx = 1;
		Queue<List<Integer>> myJ = new LinkedList();
		List<Integer> set1 = new ArrayList();

		int num=1;
		set1.add(num);
		set1.add(1);
		myJ.offer(set1);
		System.out.println("#"+N+" : "+ myJ);

		int winner=0;
		while(N>0) {
		// 매번 새로 List<Integer> 생성안해주면 위에서 만든
		// set1이 계속 재사용되면서 꼬인다.
		List<Integer> setCirc = new ArrayList();
		List<Integer> pollThing = myJ.poll();
		N-=pollThing.get(cntIdx);
		setCirc.add(pollThing.get(numIdx));
		setCirc.add(pollThing.get(cntIdx)+1);
		myJ.offer(setCirc);
		
		List<Integer> setNew = new ArrayList();
		setNew.add(++num);
		setNew.add(1);
		myJ.offer(setNew);
		winner = setCirc.get(numIdx);
		System.out.println("#"+N+" : "+ myJ);
		}
		System.out.println("Winner : "+ winner);
	}
}
//End