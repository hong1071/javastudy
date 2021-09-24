package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		
		Set<String> s = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		System.out.println(s.size());
		s.add("마이콜");
		System.out.println(s.size());
		s.add("또치");
		
		System.out.println(s.size());
		System.out.println(s.contains("둘리"));
		
		//순회1
		for(String str : s) {
			System.out.println(str);
		}

	}

}
