package com.ssafy.live;

public class SLLmain {

	public static void main(String[] args) {
		SinglyLinkedList SLL = new SinglyLinkedList();
		SLL.printList();
		SLL.addFirst("king");
		SLL.printList();
		SLL.addFirst("JACK");
		SLL.printList();
		SLL.addFirst("KONG");
		SLL.printList();
		SLL.addFirst("DANIEL");
		SLL.printList();
		SLL.remove(0);
		SLL.printList();
		SLL.remove(2);
		SLL.printList();
		SLL.addLast("Kim");
		SLL.printList();
		SLL.remove(0);
		SLL.printList();
		System.out.println("remove : " +SLL.remove(0));
		SLL.printList();
		System.out.println("remove : " +SLL.remove(0));
		SLL.printList();
		System.out.println(SLL.remove(0));
		SLL.printList();
		

	}

}
