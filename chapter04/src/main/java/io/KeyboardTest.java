package io;

import java.io.*;

public class KeyboardTest {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		try {
			// 1. 기반 스트림 설정(표준입력, stdin, System.in)
		
		
			// 2. 보조 스트림1(byte | byte | byte -> char)
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
		 
			// 3. 보조 스트림2(char1 | char2 | char3 | char4 | \n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					System.out.println("끝");
					break;
				}
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error : " + e);
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
