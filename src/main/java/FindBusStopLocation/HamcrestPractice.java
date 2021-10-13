package FindBusStopLocation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import Utilities.AssertionsUtilities;
import Utilities.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import petStoreEndtoEnd.RestAssured_given_when;

public class HamcrestPractice {
	public static Logger log = LogManager.getLogger(BusLocationFind.class.getName());
	public static String resourceURl = "/api/where/stops-for-location.json";
	public static String code, name, timezone, id;
	public static float lon;

	@Test(description = "Bus-Location", enabled = true)
	public static void BusStopLocationFind() {

		try {
			Response response;
			String BusLocationURl = URL.FindBusStopLocation(resourceURl);
			response = RestAssured_given_when.findbusLocation(BusLocationURl);
			code = JsonPath.from(response.getBody().asString()).get("data.stops[0].code");
			lon = JsonPath.from(response.getBody().asString()).get("data.stops[0].lon");
			name = JsonPath.from(response.getBody().asString()).get("data.stops[0].name");
			id = JsonPath.from(response.getBody().asString()).get("data.stops[0].id");
			timezone = JsonPath.from(response.getBody().asString()).get("data.stops[0].routes[0].agency.timezone");

			assertThat((new Object[] { code, lon, name, id, timezone }),
					is(new Object[] { "400323", -73.98392F, "5 AV/W 35 ST", "MTA_400323", "America/New_York" }));

			AssertionsUtilities.verifyStatusCode(response, 200);
			AssertionsUtilities.verifyStatusLine(response, "HTTP.1.1 200 200");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
