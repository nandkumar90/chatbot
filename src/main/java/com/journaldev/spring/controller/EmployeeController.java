package com.journaldev.spring.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.journaldev.spring.discovery.Discovery;
//import com.google.gson.Gson;
import com.journaldev.spring.model.Employee;
import com.journaldev.spring.model.Inputtext;
import com.journaldev.spring.model.LangTransLation;
import com.journaldev.spring.model.Language;
import com.journaldev.spring.model.Output;
import com.journaldev.spring.model.RequestBodyText;
import com.journaldev.spring.model.RevResponse;
import com.journaldev.spring.model.Robot;
import com.journaldev.spring.model.Text;
import com.journaldev.spring.model.TransinalMessage;
import com.journaldev.spring.model.Translation;
import com.journaldev.spring.model.Translationresponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//Map to store employees, ideally we should use database
	Map<String, String> contextMap = new HashMap<String, String>();
	
	
	
	@RequestMapping(value = "watson/workspaceDetail", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> workSpaceDetail() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YjhkYTdhYjUtNTdhYy00MjQxLTk0YTktNmE1MDM0YmYyOWEzOndnTUZoeTZJVnl3aQ==");
		HttpEntity<String> request = new HttpEntity<String>(headers);
		RestTemplate restTemplate=new RestTemplate();
	    ResponseEntity<String> result = restTemplate.exchange("https://gateway.watsonplatform.net/conversation/api/v1/workspaces/5cc74062-e7ec-4057-a94d-4ae112ca6462?version=2017-05-06&include_count=false", HttpMethod.GET, request, String.class);
		
		return result;
	}	
	
	@RequestMapping(value = "watson/message", method = RequestMethod.POST)
	public @ResponseBody Robot messages(@RequestBody RequestBodyText bodyText) {
		
		
		 Robot robot=new Robot();
			String res=bodyText.getText();
            String isresponseCoded="No";
		
		if(res.contains("ram")) {
			isresponseCoded="yes";
			String[] intValues=res.split(" ");
			String intValue=intValues[1];
			contextMap.put("ram", intValue);
			robot.setMsg("ram recorded. now disk please");
			
	        robot.setSender("ROBOT");
	        robot.setConversation_id("100");
		}
		if(res.contains("disk")) {
			isresponseCoded="yes";
			String[] intValues=res.split(" ");
			String intValue=intValues[1];
			contextMap.put("disk", intValue);
			robot.setMsg("disk recorded. now cpu confugration");
			
	        robot.setSender("ROBOT");
	        robot.setConversation_id("100");
		}
		if(res.contains("cpu")) {
			isresponseCoded="yes";
			String[] intValues=res.split(" ");
			String intValue=intValues[1];
			contextMap.put("cpu", intValue);
			
			robot.setMsg("cpu recorded.should i now lock it");
			
	        robot.setSender("ROBOT");
	        robot.setConversation_id("100");
		}
		
		
		
		
		if(res.equals("done")) {
			/*RestTemplate restTemplate=new RestTemplate();
			MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();
	        headers.add("Accept", "application/json");
	        headers.add("Content-Type", "application/json");
			headers.add("Authorization", "Basic YjhkYTdhYjUtNTdhYy00MjQxLTk0YTktNmE1MDM0YmYyOWEzOndnTUZoeTZJVnl3aQ==");
	        
			HttpEntity request = new HttpEntity(body,headers);
		    String result = restTemplate.postForObject("https://gateway.watsonplatform.net/conversation/api/v1/workspaces/5cc74062-e7ec-4057-a94d-4ae112ca6462/message?version=2017-05-06&include_count=false", request, String.class);
		    robot.setMsg(result);
			
	        robot.setSender("ROBOT");
	        robot.setConversation_id("100");
			*/
			String val="";
			isresponseCoded="yes";
			 for (String value : contextMap.values()){
		            //iterate over values
		            System.out.println(value);
		            val+=" "+ value;
		            
		        }
			
			robot.setMsg(val);
			
	        robot.setSender("ROBOT");
	        robot.setConversation_id("100");
		}
		
		else {if(isresponseCoded.equalsIgnoreCase("no")) {
		        String Response=TransinalMessage.getResponse(bodyText.getText());
				
		        robot.setMsg(Response);
				
		        robot.setSender("ROBOT");
		        robot.setConversation_id("100");}
		}
       
		return robot; 
	}	
	
	//https://github.com/nandkumar90/watSonRomot_SpringMVC/blob/master/src/main/java/com/journaldev/spring/controller/EmployeeController.java
	@RequestMapping(value = "watson/mes", method = RequestMethod.POST)
	public HttpResponse<String> watsonMessage() throws UnirestException{
		HttpResponse<String> response = Unirest.post("https://gateway.watsonplatform.net/conversation/api/v1/workspaces/5cc74062-e7ec-4057-a94d-4ae112ca6462/message?version=2017-04-21")
				  .header("content-type", "application/json")
				  .header("authorization", "Basic YjhkYTdhYjUtNTdhYy00MjQxLTk0YTktNmE1MDM0YmYyOWEzOndnTUZoeTZJVnl3aQ==")
				  .header("cache-control", "no-cache")
				  .header("postman-token", "312f496a-5ef0-f449-5a33-d275df85bb3f")
				  .body("{\r\n  \"input\": {\r\n    \"text\": \"hello\"\r\n  },\r\n \"alternate_intents\": true\r\n}\r\n")
				  .asString();
		return response;
	}
	
	public static JSONObject objectToJSONObject(Object object){
	    Object json = null;
	    JSONObject jsonObject = null;
	    try {
	        json = new JSONTokener(object.toString()).nextValue();
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    if (json instanceof JSONObject) {
	        jsonObject = (JSONObject) json;
	    }
	    return jsonObject;
	}

	public static JSONArray objectToJSONArray(Object object){
	    Object json = null;
	    JSONArray jsonArray = null;
	    try {
	        json = new JSONTokener(object.toString()).nextValue();
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    if (json instanceof JSONArray) {
	        jsonArray = (JSONArray) json;
	    }
	    return jsonArray;
	}
	
	
}
