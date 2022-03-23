package com.ssafy.live;

public class LinkedStack {

	private Node top; 
	private int size; 

	public LinkedStack() {
		super();
		this.top = null; 
		this.size = 0; 
	}

	public void push(String data) {
		Node newNode = new Node(data);
		if(top==null) {
			top = newNode;
		}else {
			newNode.link = top;
			top = newNode;
		}
		size++;
	}
	public void pop() {
		if(top==null) {
			System.out.println("EmptyStackException");
		}else {
			top = top.link;
			size--;
		}
		
	}
	public void printList() {
		if(top==null) {
			System.out.printf("EmptyStack Now (size : %d)\n",size);
		}else {
			Node cur = top;
			while(cur!=null) {
				System.out.print(cur.data+"->");
				cur = cur.link;
			}
			System.out.printf(" (size : %d)\n",size);
		}
	}
}
//End