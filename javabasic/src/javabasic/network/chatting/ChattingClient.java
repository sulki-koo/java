package javabasic.network.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.function.Consumer;

public class ChattingClient {
   
   // 서버와 송수신하기 위한 클라이언트 소켓
   private Socket clientSocket;
   
   // 서버에서 문자를 수신하는 스트림
   private BufferedReader in;
   
   // 서버에 문자를 송신하는 스트림
   private PrintWriter out;
   
   // 함수형 인터페이스 : 메소드의 파라미터들을 받아서 기능을 수행하고 반환하지 않음
   private Consumer<String> onMessageReceived;
   
   // 클라이언트 생성자
   // 파라미터 : 서버IP, 서버PORT, Consumer
   public ChattingClient(String serverIP, int serverPort, 
         Consumer<String> onMessageReceived) {
      
      try {
         
         // 클라이언트 소켓 생성
         this.clientSocket = new Socket(serverIP, serverPort);
         
         // 클라이언트 입력스트림 (서버 -> 클라이언트)
         this.in = new BufferedReader(
               new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
         
         // 클라이언트 출력스트림 (클라이언트 -> 서버), 오토플러시
         this.out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
         
         // Consumer
         this.onMessageReceived = onMessageReceived;
         
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }
      
   } // constructor
   
   // 클라이언트에서 서버로 문자열 전송 메소드
   public void sendMessage(String msg) {
	   if(msg != "") {
		   out.println(msg);
	   }
   }
   
   // 서버에서 클라이언트에 전송하는 문자열을 수신하는 스레드를 포함하는 메소드
   // 스레드의 역할 : 서버에서 지속적으로 오는 문자열들을 클라이언트의 콘솔에 출력
   public void startClient() {
      new Thread(
            () -> {
               try {
                  // 문자열 한줄 저장할 변수
                  String line;
                  // 서버에서 전송된 문자열이 있는 동안 반복
                  while ((line=in.readLine()) != null) {
                     // 문자열이 있으면 문자열을 onMessgeReceived Consumer에 전달
                     // onMessageReceived를 line을 주고 수행시킨다.
                     onMessageReceived.accept(line);
                  }
               } catch (IOException ioe) {
                  ioe.printStackTrace();
               }
            }
      ).start();
   }
   
   public static void main(String[] args) {
      
      // ChattingClient 객체 생성
      ChattingClient chattingClient = new ChattingClient(
         "192.168.8.22",
         5000,
         message -> {   // 람다(Lambda)메서드 : 일회용 이름없는 메소드
            //System.out.println("서버로부터 받은 문자열 : " + message);
        	 System.out.println(message);
         }
      );
      
      // 채팅클라이언트 시작
      chattingClient.startClient();
      Scanner scanner = new Scanner(System.in);
      SimpleDateFormat adf = new SimpleDateFormat("[ kk: mm: ss ] ");
      
      //System.out.println("아이디를 입력하세요!");
      //String id = scanner.next();
     // System.out.println(id + "님 입장하셨습니다!");
      
      System.out.println("클라이언트 시작됨! 메세지를 입력해 주세요! 종료(exit)");
      
      while (true) {
         String inputStr = scanner.nextLine();
         String inputTime = adf.format(System.currentTimeMillis());
         if (inputStr.equalsIgnoreCase("exit")) {
            System.out.println("채팅을 종료합니다!");
            System.exit(0);;
         }
        // 서버에 입력받을 문자열을 전송
        //chattingClient.sendMessage(inputTime + id + " : "+  inputStr);
        chattingClient.sendMessage(inputTime + " : "+  inputStr);
      }
      
   } // main

} // class
