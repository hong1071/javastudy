package prob04;

public class Person {
	public static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	/* 코드 작성 */
	public Person(String name) {
		this.age = 12;
		this.name = name;
		numberOfPerson += 1;
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson += 1;
	}
	
	public void selfIntroduce() {
		System.out.println("내 이름은 " + this.name + "이며, 나이는 " + this.age + "살입니다.");
	}
	
	public static int getPopulation() {
		return numberOfPerson;
	}
}
