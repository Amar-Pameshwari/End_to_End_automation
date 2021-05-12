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

public class Get_PetStore_Method {

	public static Logger log  = LogManager.getLogger(Get_PetStore_Method.class.getName());
	
	@Test(priority=2)
	public static void GetpetStoreMethod()
	{
		Post_PetStore_Method petStore = new Post_PetStore_Method();
		petStore.postMthodPetStore();
		Response response;
		//String id = Post_PetStore_Method.First_id;
		String getUrl = URL.postEndpoint("/v2/pet/"+petStore.Top_id);
		response = RestAssured_given_when.getPetStoreList(getUrl);
		String getStrResponse = Utilities_jsonPath_asString.getStrResponse(response);
		JsonPath json_Get_Response = Utilities_jsonPath_asString.jsonGetParser(getStrResponse);
		log.info(json_Get_Response);
		log.info("***** End Get TC********");
		AssertionsUtilities.verifyStatusCode(response, 200);
		AssertionsUtilities.verifyStatusLine(response, "HTTP/1.1 200 OK");
		
	}
}
