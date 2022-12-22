package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s1 = new Student();
		
		Person p1 = s1;  //upcasting   (Implicity, 암시적)
		Student s2 = (Student)p1; //downcasting (Explicity, 명시적)

	}

}
