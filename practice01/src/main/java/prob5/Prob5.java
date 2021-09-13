package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for(int i=0; i<99; i++) {
			String strNum = Integer.toString(i);
			if(strNum.matches(".*[3,6,9].*")) {
				String[] number = new String[3];
				number[0] = "3";
				number[1] = "6";
				number[2] = "9";
				int numLength = strNum.replace(String.valueOf(number), "").length();
				
				String jjak = "짝";
				System.out.println(strNum + " " + jjak + " " + numLength);
			}
		}
		
		String str = "01011";
		System.out.println(str.indexOf("11"));
	}
}
