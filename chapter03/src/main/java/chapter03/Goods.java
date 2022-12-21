package chapter03;

public class Goods {
	
	public static int countOfGoods = 0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() {
		Goods.countOfGoods = Goods.countOfGoods + 1; //같은 클래스 안에서는 생략 가능
	}
	
	public int calcDiscountPrice(float discountRate) {
		
		return (int)(price*discountRate); //연산 먼저 하기 때문에 명시부터 한 담에 괄호로 묶어주기)
	}
	
	public void printInfo() {
		System.out.println(name + ":"+price+":"+countStock+":"+countSold);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
}
