package petStoreEndtoEnd;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Utilities.AssertionsUtilities;
import Utilities.URL;
import Utilities.Utilities_jsonPath_asString;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Delete_PetStore_Method {

	public static Logger log = LogManager.getLogger(Delete_PetStore_Method.class.getName());
	
	@Test(priority=3)
	public static void DeletePetStoreMethod()
	{
		//Creating object to access variable in Post_PetStore_Method class
		Post_PetStore_Method petStore = new Post_PetStore_Method();
		petStore.postMthodPetStore();
		Response response;
		
		String DeleteUrl = URL.postEndpoint("/v2/pet/"+petStore.First_id);
		response = RestAssured_given_when.deletePetStore(DeleteUrl);
		String strDeleteResponse = Utilities_jsonPath_asString.getStrResponse(response);
		JsonPath Delete_PetStore_Response = Utilities_jsonPath_asString.jsonDeleteParser(strDeleteResponse);
		log.info(Delete_PetStore_Response);
		log.info("***** End Get TC********");
		AssertionsUtilities.verifyStatusCode(response, 200);
		AssertionsUtilities.verifyStatusLine(response, "HTTP/1.1 200 OK");
		
	}
}
