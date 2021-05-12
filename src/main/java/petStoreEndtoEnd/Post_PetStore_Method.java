package petStoreEndtoEnd;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import Utilities.AssertionsUtilities;
import Utilities.URL;
import Utilities.Utilities_jsonPath_asString;
import Utilities.filePathConvertor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post_PetStore_Method 
{

	public static String Top_id,First_id;
	public static Logger log = LogManager.getLogger(Post_PetStore_Method.class.getName());
	
	@Test(priority=1)
	public static void postMthodPetStore()
	{
		Response response;
		String fileName = filePathConvertor.createJsonFile("Createpet.json");
		log.info("First method: Creating post method");
		String postUrl = URL.postEndpoint("/v2/pet");
		response = RestAssured_given_when.createPetStore(postUrl, fileName);
		String strPostResponse = Utilities_jsonPath_asString.getStrResponse(response);
		JsonPath json_post_response = Utilities_jsonPath_asString.jsonPostParser(strPostResponse);
		log.debug(json_post_response);
		Top_id = json_post_response.getString("id");
		log.info("Top id: - "+ Top_id);
		First_id = json_post_response.getString("category.id");
		log.info("First id:-" + First_id);
		log.info("***** End Post TC********");
		AssertionsUtilities.verifyStatusCode(response, 200);
		AssertionsUtilities.verifyStatusLine(response, "HTTP/1.1 200 OK");
	}

}
