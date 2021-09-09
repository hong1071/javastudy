package chapter03;

public class StudentTest {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.setGrade(1);
		s1.setMajor("cs");
		
		
		Person p1 = s1;			
		p1.setName("둘리");		//upcasting(암시적, Implicity), s1.setName("")와 같음
		
		Student s2 = (Student)p1;
		s2.setMajor("cs");		//downcasting(명시적, explicity), ((Student)p1).setMajor("cs")와 같음
	}

}
