package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ChatClientReceiveThread extends Thread{
	
	private Socket socket = null;
	private BufferedReader bufferedReader;
	
	public ChatClientReceiveThread(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		
		/* message 처리 */
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			//?????
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			try {
				String msg = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
