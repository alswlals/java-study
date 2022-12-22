package prob05;
//여기에다가 모두 하기 base에는 고치지 않기
//오버라이드
public class MyBase extends Base {
	private String middle;

	public void service(String state){
		if( state.equals( "낮" ) ) {
			day();
		} else if( state.equals( "밤" ) ) {
			night();
		} else {
			middle();
		}
	}

	@Override
	public void day() {
		super.day();
		System.out.println("낮에는 열심히 일하자!");
	} 
//	
//	@Override
//	public void night() {
//		super.night();
//		System.out.println("night");
//	}

	
	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	} 
	 
	public void middle() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");	
	}
	
//	
}
