package test;

import java.net.*;

public class LocalHost {

	public static void main(String[] args) {
		
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();		//localhost 정보
			String hostName = inetAddress.getHostName();		//hostName: 컴퓨터 이름
			String hostAddress = inetAddress.getHostAddress();	//hostAddress: ip주소
			
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				//System.out.println(address);
				System.out.print(address & 0x000000ff);
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
