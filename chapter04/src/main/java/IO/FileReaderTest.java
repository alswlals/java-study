package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
	
	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		
		try {
			in = new FileReader("test.txt");
			
			int count = 0;
			int data = -1;
			while((data = in.read()) != -1) {
				System.out.println((char)data);
				count++;
			}
			
			System.out.println("");
			System.out.println("count: " +count);
			System.out.println("========================");
			
			count = 0;
			data = -1;
			is = new FileInputStream("test.txt");
//			/*굳이 안해도 되는 이유: fileReader라서*/
//			byte[] code = new byte[3];
			while((data = is.read()) != -1) {
				System.out.print((char)data);
				count++;
//				
//				if(count % 3 == 0) {
//					new String();
//				}
			}
			System.out.println("");
			System.out.println("count: " +count);			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found:" + e);
		} catch (IOException e) {
			System.out.println("Error:" + e);
		} finally{
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
	}
}
