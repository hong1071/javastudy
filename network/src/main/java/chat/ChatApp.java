package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class ChatApp {
	
	private static final String SERVER_IP = "61.83.118.69";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		String nickname = null;
		
		//1. 키보드 연결
		Scanner scanner = new Scanner(System.in);
		
		//2. join 프로토콜
		System.out.println("닉네임을 입력하세요.");
		System.out.println(">");
		nickname = scanner.nextLine();
		
		//3.socket생성
		Socket socket = new Socket();
        try {
            socket.connect( new InetSocketAddress(SERVER_IP, SERVER_PORT) );
            Log("채팅방에 입장하였습니다.");

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
            String request = "join:" + nickname + "\r\n";
            pw.println(request);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    	//4. 연결
	
  		//5. reader/writer 생성
  		
  		//6. CahrClientReceiveThread 시작
  		
  		//7. 키보드 입력 처리
  		
  		//8. 프로토콜 처리
  		
  		//9. 메시지처리
  		
  		//10. 자원정리
      	

      		
      		

	}
		
		

	private static void Log(String string) {
		System.out.println(string);
		
	}

}
