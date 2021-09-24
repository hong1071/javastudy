package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ChatClientThread extends Thread{
	private BufferedReader bufferedReader;
	Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			//메시지를 송신하여 출력
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			while(true) {
				String msg = bufferedReader.readLine();
				System.out.println(">" + msg);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[client] 연결이 끊어졌습니다.");
		}
	}
	
	
}
