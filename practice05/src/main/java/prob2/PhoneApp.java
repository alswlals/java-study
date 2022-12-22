package prob2;
//musicphone -> smartphone 만들기
//부분재구열? 
public class PhoneApp {

	public static void main(String[] args) {
		Phone phone = new SmartPhone();

		phone.execute("음악");
		phone.execute("통화");
		phone.execute("앱");
	}
}