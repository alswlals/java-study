package execption;

import java.io.IOException;

public class MyClass {
	
	public void danger() throws IOException, MyException {
		System.out.println("some cod1...");
		System.out.println("some cod2...");
		
		if (3 - 3 == 0) {
			throw new MyException();
		}
		if (5 - 5 == 0) {
			throw new IOException();
		}
		System.out.println("some cod3...");
		System.out.println("some cod4...");
	}
}
