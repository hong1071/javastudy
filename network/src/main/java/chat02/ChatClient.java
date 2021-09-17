package chat02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	
	private static final String SERVER_IP = "192.168.0.83";
	private static final int SERVER_PORT = ChatServer.PORT;
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = null;
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		// TODO Auto-generated method stub
			try {
			//1. 키보드 연결
				scanner = new Scanner(System.in);
				
			//2. socket 생성
			socket = new Socket();
			
			//3. 연결
				socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
				log("connected");
				
			//4. reader/writer 생성
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				
			//5. join ㅡㅍ로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			pw.flush();
			if("".equals(nickname)) {
				log("닉네임을 다시 입력하세요");
				
			}
			
			//6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();
			
			//7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				if("".equals(input)) {
					continue;
				}
				if("quit".equals(input) == true) {
					//8.프로토콜 처리
					pw.println("quit:" + nickname + "님이 퇴장하셨습니다.");
					break;
				}
				else {
					// 9. 메시지 처리
					pw.println("message:" + input);
//					String data = br.readLine();
//					if(data == null) {
//						log("closed by server");
//						break;
//					}
//					System.out.println("<" + data);
				}
			}
			
		} finally {
			//10.자원정리
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}

	private static void log(String string) {
		System.out.println("[client] " + string);
		
	}
}
