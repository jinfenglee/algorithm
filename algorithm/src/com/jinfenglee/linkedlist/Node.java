package com.jinfenglee.linkedlist;

public class Node {
	public Node() {
		
	}
	
	public Node(int data) {
		super();
		this.data = data;
	}

	private int data; // 数据域
	private Node next; // 指针

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
