package chat02;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 6000;
	private static List<PrintWriter> listWriters = new ArrayList<PrintWriter>();
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
	
		try {
			serverSocket = new ServerSocket();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림" + hostAddress + " : " + PORT);
			
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
