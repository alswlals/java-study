package com.douzone.paint.collection;

import com.douzone.paint.shape.Shape;

//Generic 사용
public class MyStack<T extends Shape> {
	private int top;
	private T[] buffer;
	
	@SuppressWarnings("unchecked")
	public MyStack(int i) {
		top = -1;
		buffer = (T[])new Object[i];
	}

	public void push(T t) {
		if(top == buffer.length - 1) {
			resize();
		}
		buffer[++top] = t;
		
	}

	public T pop() throws MyStackException {
		if(top == -1) {
			throw new MyStackException();
		}
		T s = buffer[top];
		top -= 1;
		return s;
	}

	public boolean isEmpty() {
		return top ==-1;
	}
	
	private void resize() {
		@SuppressWarnings("unchecked")
		T[] temp =(T[]) new Object[buffer.length *2];
		for(int i = 0; i <= top; i++) {
			temp[i] = buffer[i];
		}
		buffer = temp;
	}
	
	
}