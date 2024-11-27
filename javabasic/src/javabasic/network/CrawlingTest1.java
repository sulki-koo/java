package javabasic.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class CrawlingTest1 {

	public static void main(String[] args) {

		URI uri = null;
		URL url = null;
		URLConnection conn = null;
		BufferedReader br = null;

		try {

			uri = new URI("https://news.naver.com/opinion/home");
			url = uri.toURL();
			conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			// 한 줄 읽어온 데이터 저장할 변수
			String line = "";
			// 시작, 끝 문자
			String startStr = "<p class=\"article_text\">";
			String endStr = "</p>";
			// 한 줄씩 읽어서
			while ((line = br.readLine()) != null) {
				// 크롤링할 제목을 저장할 변수
				String subject = "";
				// 한 줄 문자열의 앞뒤공백문자를 제거하고
				// 한 줄이 크롤링할 문자열의 앞 문자열로 시작하면
				if (line.trim().startsWith(startStr)) {
					// 크롤링할 제목의 시작인덱스
					int startIdx = line.indexOf(startStr) + startStr.length();
					// 크롤링할 제목의 끝인덱스
					int endIdx = line.indexOf(endStr, startIdx);  // startIdx부터 endStr가 나오는데 까지
					// 제목
					subject = line.substring(startIdx, endIdx);
					System.out.println(subject);
				}
				//System.out.println(line);
			}

		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
