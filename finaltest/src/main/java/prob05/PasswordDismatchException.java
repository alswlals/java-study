package prob05;

@SuppressWarnings("serial")
public class PasswordDismatchException extends RuntimeException{
	public PasswordDismatchException() {
		super("비밀번호가 틀렸습니다.");
	}
}
