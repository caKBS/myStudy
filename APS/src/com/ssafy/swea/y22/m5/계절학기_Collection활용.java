package com.ssafy.swea.y22.m5;

import java.time.LocalDate;

public class 계절학기_Collection활용 {
	
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		int day  = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		
		boolean isY = (year%4==0 && year%100!=0 || year%400 == 0);
		int add = (isY)?1:0;
		int [] days = {31,28+add,31,30,31,30,31,31,30,31,30,31};
		
		System.out.println(days[month-1] + " days for "+year+"-"+month);
	}

}
