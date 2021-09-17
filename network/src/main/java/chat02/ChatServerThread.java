package chat02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

import echo.EchoServer;

public class ChatServerThread extends Thread{

	private String nickname;
	private Socket socket;
	BufferedReader bufferedReader = null;
	PrintWriter printWriter = null;
	List<PrintWriter> listWriters = null;
	
	
	public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		
		
		// 1. remote Host INfomation
		InetSocketAddress inetRemoteSocketaddress =  (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketaddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketaddress.getPort();	
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostPort+ "]");

		//2. 스트림 얻기
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
			
			//3. 요청처리
			while(true) {
				String request = bufferedReader.readLine();
				if(request == null) {
					log(nickname + "(으)로부터 연결끊김");
					break;
					
				}

				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					if(tokens.length < 2) {
						continue;
					}
					doJoin(tokens[1], printWriter);
					log(tokens[1] + "님이 참여하였습니다.");
					
				}
				else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}
				else if("quit".equals(tokens[0])) {
					doQuit(printWriter);
				}
				else {
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	         if (socket != null && socket.isClosed() == false) {
	             try {
	                socket.close();
	             } catch (IOException e) {
	                e.printStackTrace();
	             }
	          }
	     }
	}

	private void log(String string) {
		System.out.println("[server] " + string);
		
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for(PrintWriter writer : listWriters) {
				writer.println(data);
				writer.flush();
			}
		}
	}
	
	private void doJoin(String nickName, PrintWriter writer) {
		this.nickname = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		/* writer pool에 저장 */
		addWriter(writer);
		
		//ack
		printWriter.println("join:ok");
		printWriter.flush();
		
	}
	
	private void addWriter(PrintWriter writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void doMessage(String message) {
		/* 잘 구현 해보기 */
		broadcast(this.nickname + ":" + message);

	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}
	
	private void removeWriter(Writer writer) {
		/* 잘 구현 해보기*/
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}
	
}
