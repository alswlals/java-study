package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	private Long i = 111111111L; // 길면 에러 나기 때문에 L을 붙여줘 Long이라는 걸 명시
	private float discountrate = 0.5f;  //f붙이는 이유가 double이 아닌 float라는 걸 명시하기 위해
	
	public float getDiscountPrice() {
		// protected는 자식에서 접근할 수 있다.
		return discountrate*price;
	}
}
