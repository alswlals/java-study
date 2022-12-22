package prob04;

public class Employee {
	private String name;
	private int salary;

	public Employee() {
	}

	Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void getInformation() {
		System.out.println( "이름:" + name + "연봉:" + salary );
	}
}

class Depart extends Employee{
	String department;
	
	Depart(String name, int salary, String department){
		super(name, salary);
		this.department = department;
	}
	
	@Override
	public void getInformation() {
		System.out.printf("이름:%s 연봉:%d 부서:%s\n",getName(),getSalary(),department);
	}
}