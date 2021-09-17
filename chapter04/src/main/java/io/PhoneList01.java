package io;

import java.io.*;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			
			File f = new File("phone.txt");
			
			if(!f.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("===== 파일 정보 =====");
			System.out.println(f.getAbsolutePath());
			System.out.println(f.length());
			System.out.println(f.lastModified());
			
			System.out.println("===== 전화번호 =====");
			
			
			// 1. 기반 스트림 설정(표준입력, stdin, System.in)
			FileInputStream fis = new FileInputStream(f);
			
		
			// 2. 보조 스트림1(byte | byte | byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		 
			// 3. 보조 스트림2(char1 | char2 | char3 | char4 | \n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				//tokenizer
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(index == 0) {	// 이름
						System.out.print(token + ":");
					} else if(index == 1) {	// 전화번호1
						System.out.print(token + "-");
					} else if(index == 2) {	// 전화번호2
						System.out.print(token + "-");
					} else {	// 전화번호 3
						System.out.print(token);
					}
					
				}
				
				System.out.println("");
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
