package com.ssafy.live;

public class LinkedQueue {

	private Node front; 
	private Node rear; 
	private int size; 

	public LinkedQueue() {
		super();
		this.front = null; 
		this.rear = null; 
		this.size = 0; 
	}

	public void enQueue(String data) {
		//공백이면
		if(front==null) {
			Node newNode = new Node(data);
			front= newNode;
			rear = newNode;
		}
		//공백이 아니면
		else {
			Node newNode = new Node(data);
			// rear.link == 기존 마지막 노드의 link
			// (rear가 지목했던 노드의 link)
			rear.link=newNode;
			rear=newNode;
		}
		size++;
	}
	public void deQueue() {
		// 공백이면
		if(front==null) {
			System.out.printf("EmptyQueueException\n");
		}
		// 공백이 아니면
		else {
			//하나이면(front와 rear가 null이 아닌값으로 같으면)
			if(front==rear) {
				rear = null;
			}
			front = front.link;
			size--;
		}		
	}
	
	public boolean isEmpty() {
		if(front==null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void printList() {
		if(front==null) {
			System.out.printf("EmptyQueue Now (size : %d)\n",size);
		}else {
			Node cur = front;
			while(cur!=null) {
				System.out.print(cur.data+"->");
				cur = cur.link;
			}
			System.out.printf(" (size : %d)\n",size);
		}
	}
}
//End