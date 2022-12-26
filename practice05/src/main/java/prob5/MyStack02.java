package prob5;
//String으로 구현 
public class MyStack02 {

	private Object[] buffer;
	private int top;
	
	public MyStack02(int i) {
		buffer = new String[i];
		top = -1;
	}

	public void push(Object string) {
		if(top == buffer.length - 1) {
			resize();
		}
		buffer[++top] = string;
//		top += 1;
//		buffer[top] = string;
//		System.out.println(buffer[arr]);
		
	}

	public Object pop() throws MyStackException {
		if(top == -1) {
			throw new MyStackException();
		}
		Object s = buffer[top];
		top -= 1;
		return s;
	}

	public boolean isEmpty() {
		return top ==-1;
	}
	
	private void resize() {
		Object[] temp = new Object[buffer.length *2];
		for(int i = 0; i <= top; i++) {
			temp[i] = buffer[i];
		}
		buffer = temp;
	}
	
	
}