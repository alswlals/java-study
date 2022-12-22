package prob02;
//굿즈참조배열 이름 가격 개수, 
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			String info = scanner.nextLine();
			String[] infos = info.split(" ");
			goods[i] = new Goods(infos[0], Integer.parseInt(infos[1]), Integer.parseInt(infos[2]));
		}
		// 상품 출력
		for(int i = 0; i < COUNT_GOODS; i++) {
			goods[i].info();
		}
//		System.out.println(infos[0] + "(가격: " + infos[1] + ")이 " + infos[2] + "개 입고 되었습니다.");
		// 자원정리
		scanner.close();
	}
}
