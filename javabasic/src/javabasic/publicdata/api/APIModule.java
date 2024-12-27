package javabasic.publicdata.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// 공공데이터 포털에서 JSON 데이터 가져오는 클래스
public class APIModule {

	private static final String API_URL = "https://api.odcloud.kr/api/15037829/v1/uddi:855d80d1-55fb-4d8b-83ae-8075729f7c7b?page=1&perPage=10&returnType=JSON&serviceKey=7o1kvyuEtRU80YCnNC1k%2FNQL%2BPaUaKO9cUESkXfBh5f6VhOH7wSOdpfAzmJntgcRpT%2FRdjqvTS2FeVMehLA4hg%3D%3D";

	private String getJsonStr() {
		try {
			URI uri = new URI(API_URL);
			URL url = uri.toURL();
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String jsonStr = "";
			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}
			return jsonStr;
		} catch (URISyntaxException urie) {
			urie.printStackTrace();
			return null;
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
			return null;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	} // getJsonStr

	public List<JsonElement> getSmokeMap() {
		JsonObject jsonObj = new GsonBuilder().create().fromJson(getJsonStr(), JsonObject.class);
		return jsonObj.get("data").getAsJsonArray().asList();
	}

} // class
