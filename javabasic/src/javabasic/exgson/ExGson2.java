package javabasic.exgson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//개인실습 2)
//https://jsonplaceholder.typicode.com/users
//https://jsonplaceholder.typicode.com/todos
//사용자별 todo의 전체개수와 완료한 todo의 개수를 아래 형식으로 todocount.log 파일에 저장
//파일 출력 형식 : 사용자명 [전체todo수:00개, 완료한 todo수:00개]

public class ExGson2 {

	public static void main(String[] args) {

		String uriUsers = "https://jsonplaceholder.typicode.com/users";
		String uriTodos = "https://jsonplaceholder.typicode.com/todos";
		File file = new File("D:\\embededk\\files\\todocount.log");

		try {
			// users URLConnection 생성->읽음
			URL uriU = new URI(uriUsers).toURL(); // uri 생성후 url로 변환
			URLConnection connU = uriU.openConnection(); // URLConnection 생성
			BufferedReader brU = new BufferedReader(new InputStreamReader(connU.getInputStream()));

			String jsonUesr = "";
			String lineUser = "";
			while ((lineUser = brU.readLine()) != null) {
				jsonUesr += lineUser;
			}

			Gson gsonUser = new GsonBuilder().setPrettyPrinting().create();
			List<User> userList = gsonUser.fromJson(jsonUesr, new TypeToken<List<User>>() {
			}.getType());

			// todos URLConnection 생성->읽음
			URL uriT = new URI(uriTodos).toURL(); // uri 생성후 url로 변환
			URLConnection connT = uriT.openConnection(); // URLConnection 생성
			BufferedReader brT = new BufferedReader(new InputStreamReader(connT.getInputStream()));

			String jsonTodo = "";
			String lineTodo = "";
			while ((lineTodo = brT.readLine()) != null) {
				jsonTodo += lineTodo;
			}
			Gson gsonTodo = new GsonBuilder().setPrettyPrinting().create();
			List<Todo> todoList = gsonTodo.fromJson(jsonTodo, new TypeToken<List<Todo>>() {
			}.getType());

			PrintWriter bw = new PrintWriter(new FileWriter(file), true);
			Map<Integer, Integer> idtodoTotalMap = new HashMap<Integer, Integer>();
			Map<Integer, Integer> todoComMap = new HashMap<Integer, Integer>();

			int ulSize = userList.size();
			int tlSize = todoList.size();

			for (int id = 0; id < ulSize; id++) {
				int userTodoNum = 1;
				int todoComNum = 1;
				for (int i = 0; i < tlSize; i++) {
					if (userList.get(id).getId() == todoList.get(i).getUserId()) {
						idtodoTotalMap.put(userList.get(id).getId(), userTodoNum++);
						if (todoList.get(i).getCompleted() == "true") {
							todoComMap.put(userList.get(id).getId(), todoComNum++);
						}
					}
				}
				bw.write(userList.get(id).getName() + " [전체todo수:" + (userTodoNum - 1) + "개, 완료한 todo수:"
						+ (todoComNum - 1) + "개]");
				bw.println();
				bw.flush();
			}

			// 사용자명 [전체todo수:00개, 완료한 todo수:00개]
			System.out.println(idtodoTotalMap);
			System.out.println(todoComMap);

		} catch (MalformedURLException | URISyntaxException murie_urise) {
			murie_urise.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // main

} // class