package com.ssafy.live;

public class LinkedQueueMain {

	public static void main(String[] args) {
		LinkedQueue LQ = new LinkedQueue();
		LQ.printList();
		LQ.enQueue("KING");
		LQ.printList();
		LQ.enQueue("JACK");
		LQ.printList();
		LQ.enQueue("KONG");
		LQ.printList();
		LQ.enQueue("DANIEL");
		LQ.printList();
		System.out.println("Empty? : "+LQ.isEmpty());
		
		for (int tIdx = 1; tIdx <= 5; tIdx++) {
		LQ.deQueue();
		LQ.printList();
		}
		System.out.println("Empty? : "+LQ.isEmpty());
	}
}
//End