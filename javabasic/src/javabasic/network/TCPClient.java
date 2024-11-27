package javabasic.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// TCP Client
public class TCPClient {

	public static void main(String[] args) {

		Socket clientSocket = null;
		PrintWriter pw = null;
		BufferedReader br = null;

		// 선생님 IP 192.168.8.254
		// 내 IP 192.168.8.22
		try {
			clientSocket = new Socket("192.168.8.22", 5000);
			
			// 서버에 문자열 송신 스트림
			pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
			pw.print("클라이언트가 보낸 메세지 : 하하핫");
			pw.close();
			
			clientSocket = new Socket("192.168.8.22", 5000);
			
			// 서버에서 수신 문자열 출력
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
			System.out.println(br.readLine());

			br.close();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
