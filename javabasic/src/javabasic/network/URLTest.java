package javabasic.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

// 항상 정해진 순서대로 연결함
// URI객체 생성 -> URI를 URL로 변경 -> URLConnection 생성
// InputStream로 읽어오고 BufferedReader로 변경해서 표기

public class URLTest {

	public static void main(String[] args) {

		// URI객체 생성
		URI uri = null;
		try {
			uri = new URI("https://www.google.com");
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		}

		// URI를 URL로 변경
		URL url = null;
		try {
			url = uri.toURL();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		}

		// URLConnection 생성
		URLConnection conn = null;
		try {
			conn = url.openConnection();
			if (conn != null) {
				System.out.println(url + "에 연결객체 생성!");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// 데이터 가져오기 위해서 InputStream 생성
		InputStream is = null;
		try {
			is = conn.getInputStream();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// InputStream을 BufferedReader로 변환
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String totalLine = "";
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				totalLine += line;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// 실습) 가져온 데이터를 D:\\embededk\\files\\google.txt 파일에 저장
		File file = new File("D:\\embededk\\files\\google.txt");
		Writer w = null;

		try {
			w = new FileWriter(file);
			w.write(totalLine);
			w.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
