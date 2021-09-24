package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 6000;
	private static List<PrintWriter> listWriters = new ArrayList<PrintWriter>();
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
	
		try {
			//1. 소켓 생성
			serverSocket = new ServerSocket();
			
			//2. ip주소 설정 후 포트 번호와 함께 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림 " + hostAddress + " : " + PORT);
			
			//3. 소켓 accept처리, 서버스레드 생성
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static void log(String string) {
		System.out.println("[server] " + string);
	}

}
