package collection;
//collection에 구현했기 때문에 구현 가능

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		s.add(s1);
//		s.add(s2);
		
		System.out.println(s.size());
		System.out.println(s.contains(s2)); //data 자료구조 
		
		// 순회 1
		for(String str : s) {
			System.out.println(str);
		}
		
	}

}

