package javabasic.exgson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// 개인실습 1)
// https://jsonplaceholder.typicode.com/posts 에서 JSON문자열을 수신하여
// List에 저장한 후 id값에 대해 내림차순 정렬해서 화면 출력

public class ExGson1 {

	public static void main(String[] args) {
		// URI객체 생성 -> URI를 URL로 변경 -> URLConnection 생성

		URI uri = null;
		URL url = null;
		URLConnection conn = null;

		try {
			uri = new URI("https://jsonplaceholder.typicode.com/posts");
			url = uri.toURL();
			conn = url.openConnection();

			InputStream is = null;

			is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String jsonStr = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				jsonStr += line;
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			List<Post> postList = gson.fromJson(jsonStr, new TypeToken<List<Post>>() {
			}.getType());

			Collections.sort(postList, new Comparator<Post>() {
				@Override
				public int compare(Post p1, Post p2) {
					return p2.getId() - p1.getId();
				}
			});
			int pls = postList.size();
			for (int i = 0; i < pls; i++) {
				System.out.println(postList.get(i));
			}

		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class
