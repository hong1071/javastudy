package echo02;

import java.io.*;
import java.net.*;

public class EchoServer {

	private static final int PORT = 6000;
	
	public static void main(String[] args) {
	
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("start...[port:" + PORT  + "]");
			
			while(true) {
				Socket socket = serverSocket.accept();		//blocking
				new EchoServerReceiveThread(socket).start();
			}
		} catch (IOException e) {
			log("error" + e);
		} finally {
			try {
				if(serverSocket!= null && serverSocket.isClosed() == false) {
				serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}

}
