package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=0; i<99; i++) {
			String a = Integer.toString(i);
			if(a.matches(".*[3,6,9].*")) {
				String jjak = "짝";
				System.out.println(a + " " + jjak);
			}
		}
	}
}
