package petStoreEndtoEnd;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_given_when {

	public static Logger log = LogManager.getLogger(RestAssured_given_when.class.getName());

	public static double lat = 40.748433, lon = -73.985656, latSpan = 0.005, lonSpan = 0.005;
	public static String key = "44639744-f9c3-43e6-810f-51d4547d8b0a";
	public static String status = "available"; // Pending, Sold

// Method to find Bus stop Location
	public static Response findbusLocation(String URl) {
		RequestSpecification requestSpecification = RestAssured.given().queryParam("lat", lat).queryParam("lon", lon)
				.queryParam("latSpan", latSpan).queryParam("lonSpan", lonSpan).queryParam("key", key);
		Response response = requestSpecification.get(URl);
		log.info(requestSpecification.log().all());
		return response;
	}

// Create Get Method for Rest Assured
	public static Response getPetStoreList(String uRI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.headers("Content-Type", "application/json");
		Response response = requestSpecification.get(uRI);
		log.info(requestSpecification.log().all());
		return response;
	}

	public static Response getMethodFindByMethod(String uRI) {
		RequestSpecification requestSpecification = RestAssured.given().queryParam("status", status);
		requestSpecification.headers("Content-Type", "application/json");
		Response response = requestSpecification.get(uRI);
		log.info(requestSpecification.log().all());
		return response;
	}

// Create Post Method for Rest Assured
	public static Response createPetStore(String uRI, String strJson) {
		RequestSpecification requestSpecification = RestAssured.given().body(strJson);
		requestSpecification.headers("Content-Type", "application/json");
		Response response = requestSpecification.post(uRI);
		log.info(requestSpecification.log().all());
		return response;
	}

// Delete the created pet
	public static Response deletePetStore(String uRI) {
		RequestSpecification requestSpeicification = RestAssured.given();
		requestSpeicification.headers("Content-Type", "application/json");
		Response response = requestSpeicification.delete(uRI);
		log.info(requestSpeicification.log().all());
		return response;
	}

}
