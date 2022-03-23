package com.ssafy.live;

//데이터를 저장하고 다음링크를 가지고 있어야한다.
public class Node {
	// 데이터를 저장
	public String data;
	// 링크를 저장
	public Node link;
	
	//생성자를 정의하는 순간 얘는 안만들어줌.. 
	public Node() {
	}
	
	public Node(String data) {
		this.data = data;
		this.link = null;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
}
