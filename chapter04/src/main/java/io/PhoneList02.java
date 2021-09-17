package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		Scanner scanner = null;
		try {
			
			File f = new File("phone.txt");
			
			if(!f.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("===== 파일 정보 =====");
			System.out.println(f.getAbsolutePath());
			System.out.println(f.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(f.lastModified())));
			
			System.out.println("===== 전화번호 =====");
			
			scanner = new Scanner(f);
			
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();
				
				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);
			}
			
		} catch(FileNotFoundException e){
			System.out.println("file not found : ");
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
	}

}
