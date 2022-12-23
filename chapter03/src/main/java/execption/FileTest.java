package execption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;  //기존 try에 있을 때는 걔한테만 해당되기 때문에 전역변수 ? 그걸 위해 큰 데다가 넣어줌
		
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();		
			System.out.println((char)data);
		} catch (FileNotFoundException e) {
			System.out.println("error :" + e);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error :" + e);
		} finally {
			try {
				if(fis != null) {
				fis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
