package prob3;

public class Duck extends Bird {
	public String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sing() {
    	System.out.println("오리("+name+")가 소리내어 웁니다.");
    }

    public void fly() {
    	System.out.println("오리("+name+")가 날아 다닙니다.");
    }
    
    public void showName() {
    	System.out.println("오리의 이름은 "+name+"입니다.");
    }
}
