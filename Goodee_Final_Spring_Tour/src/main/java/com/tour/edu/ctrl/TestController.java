package com.tour.edu.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Controller
public class TestController {

	private String serviceKey = "gC62T5W6tO1vyBVJ33oddkChTc6fTjq3CqWQmow%2FOxYMmNKtM3uY3ffEarYZfa5%2BSwZzJEnFT8HpKRV41FCQNw%3D%3D";
	private String mobileOS = "ETC";
	private String mobileApp = "AppTest";
	private String numOfRows = "30";
	private String type = "json";


	@GetMapping("/getAjaxMain.do")
	@ResponseBody
	public JSONArray getMainCode() throws IOException, ParseException {

		Map<String, Object> result = new HashMap<String, Object>();

		String apiURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?ServiceKey=" + serviceKey
				+ "&_type=json";
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("MobileOS", mobileOS);
		con.setRequestProperty("MobileApp", mobileApp);
		con.setRequestProperty("numOfRows", numOfRows);
		// con.setRequestProperty("pageNo", pageNo);

		int responseCode = con.getResponseCode();

		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();

		JSONParser jParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jParser.parse(response.toString());
		System.out.println(jsonObj);

		JSONObject jsonResp = (JSONObject) jsonObj.get("response");
		System.out.println(jsonResp);

		JSONObject jsonBody = (JSONObject) jsonResp.get("body");
		System.out.println(jsonBody);

		JSONObject jsonItems = (JSONObject) jsonBody.get("items");
		System.out.println(jsonItems);

		JSONArray jArr = (JSONArray) jsonItems.get("item");
		System.out.println(jArr);

		return jArr;
	}

	@GetMapping("/getAjaxSub.do")
	@ResponseBody
	public JSONArray getSubCode(HttpServletRequest req) throws IOException, ParseException {

		String apiURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?ServiceKey=" + serviceKey
				+ "&_type=json&areaCode=" + req.getParameter("areaCode");
		URL url = new URL(apiURL);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("MobileOS", mobileOS);
		con.setRequestProperty("MobileApp", mobileApp);
		con.setRequestProperty("numOfRows", numOfRows);
		// con.setRequestProperty("pageNo", pageNo);

		int responseCode = con.getResponseCode();

		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();

		JSONParser jParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jParser.parse(response.toString());
		// System.out.println(jsonObj);

		JSONObject jsonResp = (JSONObject) jsonObj.get("response");
		// System.out.println(jsonResp);

		JSONObject jsonBody = (JSONObject) jsonResp.get("body");
		// System.out.println(jsonBody);

		JSONObject jsonItems = (JSONObject) jsonBody.get("items");
		// System.out.println(jsonItems);

		JSONArray jArr = (JSONArray) jsonItems.get("item");
		// System.out.println(jArr);

		// int n= spotService.insertSpot(vo);

		return jArr;
	}

	@GetMapping("/ajaxSearch.do")
	@ResponseBody
	public JSONArray getSearchData(HttpServletRequest req) throws IOException, ParseException {

		String areaCode = req.getParameter("areaCode");
		String sigunguCode = req.getParameter("sigunguCode");

		System.out.println(areaCode + ", " + sigunguCode);

		String apiURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey="
				+ serviceKey + "&_type=json&areaCode=" + areaCode + "&sigunguCode=" + sigunguCode + "&numOfRows=100";
		URL url = new URL(apiURL);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("MobileOS", mobileOS);
		con.setRequestProperty("MobileApp", mobileApp);

		int responseCode = con.getResponseCode();

		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();

		JSONParser jParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jParser.parse(response.toString());
		System.out.println(jsonObj);

		JSONObject jsonResp = (JSONObject) jsonObj.get("response");
		System.out.println(jsonResp);

		JSONObject jsonBody = (JSONObject) jsonResp.get("body");
		System.out.println(jsonBody);

		JSONObject jsonItems = (JSONObject) jsonBody.get("items");
		System.out.println(jsonItems);

		JSONArray jArr = (JSONArray) jsonItems.get("item");
		
		return jArr;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/myTourDataDetail.do")
	public String myTourDataDetail(Model model, HttpServletRequest req) throws IOException, ParseException {

		String contentId = req.getParameter("contentId");
		System.out.println(contentId);
		String apiURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="
				+ serviceKey + "&_type=json&contentId=" + contentId + "&defaultYN=Y"
				+ "&firstImageYN=Y&areacodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y" + "&numOfRows=10&pageNo=1";
		URL url = new URL(apiURL);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("MobileOS", mobileOS);
		con.setRequestProperty("MobileApp", mobileApp);

		int responseCode = con.getResponseCode();

		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();

		JSONParser jParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jParser.parse(response.toString());
		System.out.println(jsonObj);

		JSONObject jsonResp = (JSONObject) jsonObj.get("response");
		System.out.println(jsonResp);

		JSONObject jsonBody = (JSONObject) jsonResp.get("body");
		System.out.println(jsonBody);

		JSONObject jsonItems = (JSONObject) jsonBody.get("items");
		System.out.println(jsonItems);

		JSONObject jArr = (JSONObject) jsonItems.get("item");
		Map<String, Object> map = null;
		try {
			map = new ObjectMapper().readValue(jArr.toString(), Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(map.get("modifiedtime"));
		model.addAttribute("modifiedtime", map.get("modifiedtime"));

		model.addAttribute("TourData", map);

		return "service/myTourDataDetail";
	}

	@GetMapping("/ajaxSearchTourData.do")
	@ResponseBody
	public JSONArray getSearchTourData(HttpServletRequest req) throws IOException, ParseException {

		String contentId = req.getParameter("contentId");
		String apiURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="
				+ serviceKey + "&_type=json&contentId=" + contentId;
		URL url = new URL(apiURL);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("MobileOS", mobileOS);
		con.setRequestProperty("MobileApp", mobileApp);

		int responseCode = con.getResponseCode();

		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();

		JSONParser jParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jParser.parse(response.toString());
		System.out.println(jsonObj);

		JSONObject jsonResp = (JSONObject) jsonObj.get("response");
		System.out.println(jsonResp);

		JSONObject jsonBody = (JSONObject) jsonResp.get("body");
		System.out.println(jsonBody);

		JSONObject jsonItems = (JSONObject) jsonBody.get("items");
		System.out.println(jsonItems);

		JSONArray jArr = (JSONArray) jsonItems.get("item");
		// System.out.println(jArr.get(0));
		String jsonObj1 = response.toString();
		JsonParser parse = new JsonParser();

		JsonElement element = parse.parse(jsonObj1);

		JsonElement ele = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject()
				.get("items").getAsJsonObject().get("item");
		System.out.println(ele.toString());
		return jArr;
	}

	@PostMapping(value = "/ajaxSearchTourDataList.do")
	@ResponseBody
	public List<JSONObject> getSearchTourDataList(HttpServletRequest req, 
			 @RequestParam(value="contentId[]") List<String> contentId) throws IOException, ParseException {
		List<JSONObject> arrayJson = new ArrayList<JSONObject>();
		
		for (String string : contentId) {
			String id = string;
			System.out.println(id);
			String apiURL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey="
					+ serviceKey + "&_type=json&contentId=" + id + "&defaultYN=Y"
					+ "&firstImageYN=Y&areacodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y" + "&numOfRows=10&pageNo=1";
			URL url = new URL(apiURL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("MobileOS", mobileOS);
			con.setRequestProperty("MobileApp", mobileApp);

			int responseCode = con.getResponseCode();

			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			JSONParser jParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jParser.parse(response.toString());
			System.out.println(jsonObj);

			JSONObject jsonResp = (JSONObject) jsonObj.get("response");
			System.out.println(jsonResp);

			JSONObject jsonBody = (JSONObject) jsonResp.get("body");
			System.out.println(jsonBody);

			JSONObject jsonItems = (JSONObject) jsonBody.get("items");
			System.out.println(jsonItems);

			JSONObject jsonItem = (JSONObject) jsonItems.get("item");
			arrayJson.add(jsonItem);
		}
		
		return arrayJson;

	}
}
