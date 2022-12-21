package prob01;

public class Member {
//	public static void main(String[] args) {
		private String id;
		private String name;
		private int point;	
	
		public void setId(String id) {
			this.id = id;
		}
		
		String getId() {
			return id;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		String getName() {
			return name;
		}
		
		public void setPoint(int point) {
			this.point = point;
		}
		
		int getPoint() {
			return point;
		}
		
		public void show() {
			System.out.println(getId() + getName() + getPoint());
		
		}
//	//정의만하기
//	private String id;
//	private String name;
//	private int point;	
//	
//	public Member(String id, String name, int point) {
//		this(id, name, point);
//	}
//	
//	public void show() {
//		System.out.println(id + " " + name + " " + point);
//	
//	}
}