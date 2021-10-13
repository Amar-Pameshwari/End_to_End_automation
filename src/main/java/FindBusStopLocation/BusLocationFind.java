package FindBusStopLocation;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.testng.annotations.Test;

import Utilities.AssertionsUtilities;
import Utilities.URL;
import Utilities.Utilities_jsonPath_asString;
import io.restassured.response.Response;
import petStoreEndtoEnd.RestAssured_given_when;

public class BusLocationFind {

	public static Logger log = LogManager.getLogger(BusLocationFind.class.getName());
	public static String resourceURl = "/api/where/stops-for-location.json";
	public static JSONObject jsonObjectResponse;
	public static Response response;

	@Test(description = "Getting response", enabled = true)
	public static void BusStopLocationFind() {

		String BusLocationURl = URL.FindBusStopLocation(resourceURl);
		response = RestAssured_given_when.findbusLocation(BusLocationURl);
		String getStringResponse = Utilities_jsonPath_asString.getStrResponse(response);
		jsonObjectResponse = Utilities_jsonPath_asString.jsonObjectParser(getStringResponse);
		// Utilities_jsonPath_asString.jsonGetParser(getStringResponse);
		// log.info("Json Response: " + jsonObjectResponse);
		// log.info("Json Response: " + jsonObjectResponse.getDouble("routes/lon"));
		AssertionsUtilities.verifyStatusCode(response, 200);
		AssertionsUtilities.verifyStatusLine(response, "HTTP/1.1 200 200");
	}

	@Test(description = "Response Valiation", enabled = true)
	public static void ResponseValidation() {
		// Validating all response for Stops[0]
		log.info("************Start the validation for Stops[0]*************");
		String currentTime = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse, "/currentTime");
		log.info("currentTime : " + currentTime);
		String wheelchairBoarding = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse,
				"/data/stops[0]/wheelchairBoarding");
		log.info("Stops[0]-wheelchairBoarding : " + wheelchairBoarding);
		String Stops0_code = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse, "/data/stops[0]/code");
		log.info("Stops[0]- Code : " + Stops0_code);
		AssertionsUtilities.verifyActualExpeactedResult(Stops0_code, "400323");
		String Stops0_direction = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse, "/data/stops[0]/direction");
		log.info("Stops[0]- Direction : " + Stops0_direction);
		String Stops0_id = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse, "/data/stops[0]/id");
		log.info("Stops[0]- id : " + Stops0_id);
		String Stops0_lat = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse, "/data/stops[0]/lat");
		log.info("Stops[0]- Latitude : " + Stops0_lat);
		String Stops0_locationType = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse,
				"/data/stops[0]/locationType");
		log.info("Stops[0]- Location Type : " + Stops0_locationType);
		String Stops0_lon = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse, "/data/stops[0]/lon");
		log.info("Stops[0]- Longitude : " + Stops0_lon);
		String Stops0_name = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse, "/data/stops[0]/name");
		log.info("Stops[0]- Name : " + Stops0_name);
		log.info("************End the validation for Stops[0]*************");

		log.info("************Start the validation for Routes[0]*************");
		String Stops0_agency_id = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse,
				"/data/stops[0]/routes[0]/agency/id");
		log.info("Stops[0]-routes[0]_ agency_id : " + Stops0_agency_id);

		String Stops0_routes0_id = JsonObject_TestUtils.getValueByJPath(jsonObjectResponse,
				"/data/stops[0]/routes[0]/id");
		log.info("Stops[0]-routes[0]_id : " + Stops0_routes0_id);
		log.info("************End the validation for Routes[0]*************");

	}

}
