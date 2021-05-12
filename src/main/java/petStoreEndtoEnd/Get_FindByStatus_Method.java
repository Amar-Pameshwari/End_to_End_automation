package petStoreEndtoEnd;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Utilities.AssertionsUtilities;
import Utilities.URL;
import Utilities.Utilities_jsonPath_asString;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_FindByStatus_Method 
{

	public static Logger log = LogManager.getLogger(Get_FindByStatus_Method.class.getName());
	
	@Test
	public static void getMethodFindByStatus()
	{
		Response response;
		
		String getUrl = URL.postEndpoint("/v2/pet/findByStatus");
		response = RestAssured_given_when.getMethodFindByMethod(getUrl);
		String strResponse = Utilities_jsonPath_asString.getStrResponse(response);
		JsonPath jsonGetResponse = Utilities_jsonPath_asString.jsonGetParser(strResponse);
		log.info(jsonGetResponse);
		log.info("**** TC COmplete********");
		AssertionsUtilities.verifyStatusCode(response, 200);
		AssertionsUtilities.verifyStatusLine(response, "HTTP/1.1 200 OK");
	}
}
