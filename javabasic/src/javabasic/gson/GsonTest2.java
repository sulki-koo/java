package javabasic.gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest2 {

	public static void main(String[] args) {

		// 무료 JSON서버 : https://jsonplaceholder.typicode.com
		// JSON 데이터를 송수신할 수 있는 서버

		String uriStr = "https://jsonplaceholder.typicode.com/posts";

		try {
			URL url = new URI(uriStr).toURL();

			URLConnection conn = url.openConnection();

			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));

			String jsonStr = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			List<Post> postList = gson.fromJson(jsonStr, List.class);
			int postListSize = postList.size();
			for (int i = 0; i < postListSize; i++) {
				System.out.println(postList.get(i));
			}

		} catch (MalformedURLException | URISyntaxException mfeUrise) {
			mfeUrise.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
