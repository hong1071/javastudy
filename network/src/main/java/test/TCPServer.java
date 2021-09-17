package test;

import java.io.IOException;
import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1.서버소켓 생성
			serverSocket = new ServerSocket();
			
			//1-1. TIME_WAIT 상태에서도 소켓 포트 번호 할당이 가능 하도록 하기 위함
			serverSocket.setReuseAddress(true);
			
			//2.바인딩(binding)
			//  Socket에 InetSocketAddress(IPAddress + port)
			//  IPAddress(클라이언트의 IP주소 필요) : 0.0.0.0(특정 호스트 IP를 바인딩하지 않고 모든 IP로부터의 연결을 허용)
			serverSocket.bind(new InetSocketAddress(/*InetAddress.getLocalHost().getHostAddress()*/"0.0.0.0", 5000));
			
			//3.accept
			//  클라이언트로부터 연결요청을 기다림
			Socket socket = serverSocket.accept();		//blocking
			
			InetSocketAddress inetRemoteSocketaddress =  (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketaddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketaddress.getPort();	
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remoteHostPort+ "]");
			
			try {
			
				//4.IO Strean 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				
				while(true) {
					
					//5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);		// blocking
					if(readByteCount == -1) {		//클라이언트가 정상적으로 종료를 했다는 뜻(close() 호출)
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received : " + data);
					
					//6. 데이터 쓰기
					try {
						Thread.sleep(4000);
						os.write(data.getBytes("utf-8"));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch(SocketException e){
				System.out.println("[server] suddenly closed by client");
			} catch(IOException ex){
				System.out.println("[server] error:" + ex);
			} finally {
				try{
					if(socket!= null && socket.isClosed() == false) {
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			System.out.println("[server] error: " + e);
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

}
