package prob04;

public class StringUtil {
    public static String concatenate(String[] str) {
        //문자열을 결합하여 리턴 하는 메소드 구현
//    	for(String string1 : str) {
//    		string1 += str;
//    	}
//    	return string1;
    	
    	String addStr = "";
    	for(int i=0;i<str.length;i++) {
    		addStr += str[i];
    	}
    	return addStr;
    }
}

