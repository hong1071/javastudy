package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ChatServerThread extends Thread{
	
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	BufferedReader bufferedReader = null;
	PrintWriter printWriter = null;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
			
			while(true) {
				
				String request = bufferedReader.readLine();
				if(request == null) {
					log("클라이언트로부터 연결 끊김");
					doQuit(printWriter);
					break;
				}
				
				String[] tokens = request.split(" ");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				}
				else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				else if("quit".equals(tokens[0])) {
					doQuit(printWriter);
				}
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		/* writer pool에 저장*/
		addWriter(writer);
		
		printWriter.println("join:ok");
		printWriter.flush();
	}
	
	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void broadcast(String data) {
		synchronized (listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
	private void doMessage(String message) {
		broadcast(this.nickname + ":"+ message);
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}
	
	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}
	
	private void log(String string) {
		System.out.println(string);
	}
	
}
