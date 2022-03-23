package com.ssafy.live;

public class LinkedStackMain {

	public static void main(String[] args) {
		LinkedStack LS = new LinkedStack();
		LS.printList();
		LS.push("KING");
		LS.printList();
		LS.push("JACK");
		LS.printList();
		LS.push("KONG");
		LS.printList();
		LS.push("DANIEL");
		LS.printList();
		for (int tIdx = 1; tIdx <= 5; tIdx++) {
		LS.pop();
		LS.printList();
		}

	}

}
//End