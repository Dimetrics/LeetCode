package com.leetCode;

public class MyQueue {
	//
	private int maxSize;
	private int[] queArray;
	private int front;
	private int rear;
	private int nItems;

	// -------------------------------------------------
	public MyQueue() {
		maxSize = 10;
		queArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// Push element x to the back of queue.
	public void push(int x) {
		if (rear == maxSize - 1)
			rear = -1;
		int temp = nItems + 1;
		if (temp == maxSize)
			resizeArray(2 * maxSize);
		queArray[++rear] = x;
		nItems++;
	}

	private void resizeArray(int size) {
		int[] newArray = new int[size];
		//
		int current = front;
		//
		for (int i = 0; i < nItems; i++) {
			newArray[i] = queArray[current];
			current = (current + 1) % nItems;
		}
		queArray = newArray;
		front = 0;
		rear = nItems - 1;
		maxSize = size;
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!empty()) {
			front++;
			if (front == maxSize)
				front = 0;
			nItems--;
		}

	}

	// Get the front element.
	public int peek() {
		return queArray[front];

	}

	// Return whether the queue is empty.
	public boolean empty() {
		return (nItems == 0);

	}

}
