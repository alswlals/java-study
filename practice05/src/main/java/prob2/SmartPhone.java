package prob2;

public class SmartPhone extends MusicPhone {
	public void execute(String function) {
			if(function.equals("앱")) {
				playApp();
				return;
			}
			super.execute(function);
			System.out.println();
		}
	private void playApp() {
		System.out.print("앱 실행");
	}
	}

