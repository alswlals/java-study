package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		
//		int a = 0;
//		while(a<=20) {
//			alert(a);
//			a++;
//		}
//		
//		int count=0;
//		int lineCount=0;
//		for(int i = 1; i < 20 ; i++ ) {
//			count++;
//			if(lineCount==10) {
//				System.out.println();
//				lineCount=0;
//			}
//			System.out.println(i);
//			lineCount++;
//			}
		for(int i=1 ; i<10 ; i++) {
	          for(int j=i; j<=(i+9) ; j++){
	              System.out.print(j+" ");
	          }
	          System.out.println();
	       }		
		}
	}

