package chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class MainThread {
	
	private static final int PORT = 5000;

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();
		
		try {
			//1. 서버 소켓 객체 생성
			serverSocket = new ServerSocket();
			
			//2. 소켓을 호스트의 포트와 binding
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" + hostAddress + ":" + PORT);
			
			Socket socket = serverSocket.accept();
			//3.클라이언트로부터 연결 요청이 올 때까지 대기
//			while(true) {
//				socket = serverSocket.accept();
//				new ChatServerThread(socket).start();
//			}
			
			//4. 연결요청이 오면 연결이 되었다는 메세지 출력
			InetSocketAddress remoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostName = remoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = remoteSocketAddress.getPort();
			log("주소: " + remoteHostName + ", port: " + remoteHostPort);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	private static void log(String string) {
		System.out.println(string);
	}

}
