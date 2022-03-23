package com.ssafy.live;

public class SinglyLinkedList {

	private Node head; // 노드의 시작점.
	private int size; // 메서드가 아니라 멤버변수로 저장할래.

	public SinglyLinkedList() {
		// 아래의 작업이 그냥 알아서 됨.
		this.head = null; // head.data나 head.link와 달린 얘는 어디에 저장되는거?ㅁㅁㅁㅁㅁㅁㅁ
		this.size = 0; // ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	}

	// 특정 위치(idx번째)의 노드를 반환하는 메서드
	public Node search(int idx) {
		// 이러한 상황에서는 예외를 발생시켜 알려주거나.. 기타등등의 작업을 해야할것 같음.
		if (idx < 0 || idx >= size)
			return null;

		Node curr = head;

		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		return curr;
	}

	// 연결리스트 첫번째 원소로 노드를 삽입
	public void addFirst(String data) {
		// 노드를 생성했다.
		Node newNode = new Node(data);

		newNode.link = head; // 새로만든 노드의 링크를 head로 변경

		head = newNode; // head가 가리키는 노드는 새 노드로 변경

		size++;
	}

	// 연결리스트 마지막 원소로 노드를 삽입
	public void addLast(String data) {
		Node newNode = new Node(data);

		if (size == 0) { // head == null
			addFirst(data);
			return;
		}

		// 마지막 노드를 찾아야해

		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = newNode;
		size++;
	}

	// 연결리스트 특정 위치에 원소로 삽입
	public void add(int idx, String data) {
		if (idx < 0 || idx > size) {
			return; // 인덱스를 잘못넣었을때
		}
		// 관대하게 범위를 설정할 수 있음.
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size) {
			addLast(data);
			return;
		}

		Node pre = search(idx - 1);

		Node newNode = new Node(data);

		newNode.link = pre.link;
		pre.link = newNode;

		size++;

	}

	// 연결리스트 첫번쨰 원소 삭제
	public String remove() {
		if (head == null) {
			return "삭제할거 없어"; // 예외 발생시켜도 가능
		}
		String data = head.data;

		head = head.link;
		size--;

		return data;
	}

	// 연결리스트 특정위치 노드 삭제
	public String remove(int idx) {
		if (size == 0) {
			return "삭제할거 없어"; // 예외 발생시켜도 가능
		// 첫 원소면
		} else if (idx == 0) {
			String data = head.data;
			head = head.link;
			size--;
			return data;
		} else {
			String data = search(idx).data;
			// 마지막 원소면
			if (idx == size - 1) {
				search(idx - 1).link = null;
			} else {
				search(idx - 1).link = search(idx).link;
			}
			size--;
			return data;
		}
	}

	// 연결리스트 내용 출력
	public void printList() {
		Node curr = head;
		if (head == null) {
			System.out.println("공백 리스트야 미안");
			return;
		}
		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.link;
		}
		System.out.println();
	}
}