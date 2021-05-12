package Utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Utilities_jsonPath_asString 
{

	public static Logger log = LogManager.getLogger(Utilities_jsonPath_asString.class.getName());
	
	
	public static String getStrResponse(Response response)
	{
		log.info("*** Converting Json Response in String *********");
		String strResponse = response.getBody().asString();
		return strResponse;
	}
	
	public static JSONObject jsonObjectParser(String getResponse)
	{
		log.info("Converting all String response in JSonObject");
		JSONObject jsonObj = new JSONObject(getResponse);
		return jsonObj;
	}
	
	public static JsonPath jsonGetParser(String getResponse)
	{
		log.info("Get: Json response for get conversion");
		JsonPath get_jsonpathResponse = new JsonPath(getResponse);
		return get_jsonpathResponse;
	}
	
	public static JsonPath jsonPostParser(String postResponse)
	{
		log.info("Post: Json response for Post conversion");
		JsonPath post_jsonpathResponse = new JsonPath(postResponse);
		return post_jsonpathResponse;
	}
	
	public static JsonPath jsonDeleteParser(String deleteResponse)
	{
		log.info("Delete: Json response for Delete conversion");
		JsonPath delete_jsonpathResponse = new JsonPath(deleteResponse);
		return delete_jsonpathResponse;
	}
	
	// XML Parser
	public static XmlPath xmlParser(String xmlResponse)
	{
		log.info("Start XML parser");
		XmlPath xmlPathResponse = new XmlPath(xmlResponse);
		return xmlPathResponse;
	}
	
	//Creating Method for status Code
	public static int StatusCode(Response response)
	{
		log.info("Creating status code method");
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	
	//Creating Method for status message
	public static String statusMessage(Response response)
	{
		log.info("Creating status message method");
		String statusMessage = response.getStatusLine();
		return statusMessage;
	}
}
