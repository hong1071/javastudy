package echo02;

import java.io.*;
import java.net.*;

public class EchoServerReceiveThread extends Thread{

	private Socket socket;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		InetSocketAddress inetRemoteSocketaddress =  (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketaddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketaddress.getPort();	
		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort+ "]");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			while(true) {
				String data = br.readLine();
				if(data == null) {
					EchoServer.log("closed by client");
					break;
				}
				EchoServer.log("recieved:" + data);
				pw.println(data);
			}
		} catch (IOException e) {
			EchoServer.log("error" + e);
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
				socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
