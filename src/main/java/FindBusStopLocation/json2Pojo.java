package FindBusStopLocation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.collection.HasItemInArray;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.AnyOf;
import org.testng.annotations.Test;

import Utilities.AssertionsUtilities;
import Utilities.URL;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import petStoreEndtoEnd.RestAssured_given_when;
import pojoPractice.Agency;
import pojoPractice.BusLocation;
import pojoPractice.Data;
import pojoPractice.Route;
import pojoPractice.Stop;

public class json2Pojo {
	public static Logger log = LogManager.getLogger(BusLocationFind.class.getName());
	public static String resourceURl = "/api/where/stops-for-location.json";
	static Response response;
	static BusLocation buslocation;
	static Stop stops;
	static Data data;
	static Agency agency;

	@Test(description = "Getting Response", enabled = true)
	public static void BusStopLocationFind() {
		try {
			String BusLocationURl = URL.FindBusStopLocation(resourceURl);
			response = RestAssured_given_when.findbusLocation(BusLocationURl);

			AssertionsUtilities.verifyStatusCode(response, 200);
			AssertionsUtilities.verifyStatusLine(response, "HTTP/1.1 200 200");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(description = "Validating Response for Stops", enabled = true)
	public static void StopsResponseValidation() {
		try {
			buslocation = response.as(BusLocation.class, ObjectMapperType.GSON);
			Data data = buslocation.getData();
			List<Stop> stops = data.getStops();

			for (Stop stop_iterate : stops) {

				log.info(" Code:  " + stop_iterate.getCode().toString() + ", Direction: " + stop_iterate.getDirection()
						+ ", Id: " + stop_iterate.getId().toString() + ", lat: " + stop_iterate.getLat()
						+ ", locationType: " + stop_iterate.getLocationType() + ", lon: " + stop_iterate.getLon()
						+ ", name: " + stop_iterate.getName() + ", wheelchairBoarding: "
						+ stop_iterate.getWheelchairBoarding());

				assertThat(
						(new Object[] { stop_iterate.getCode(), stop_iterate.getDirection(), stop_iterate.getId(),
								stop_iterate.getLat().toString(), stop_iterate.getLocationType().toString(),
								stop_iterate.getLon().toString(), stop_iterate.getName(),
								stop_iterate.getWheelchairBoarding() }),
						is(new Object[] { "400324", "SW", "MTA_400324", "40.747494", "0", "-73.985338", "5 AV/W 33 ST",
								"UNKNOWN" }));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(description = "Routes Response Validation", enabled = true)
	public static void routesResponseValiatio() {
		log.info("*********************************************************************");
		try {
			Data data = buslocation.getData();
			List<Stop> stops = data.getStops();

			for (Stop stop_iterate : stops) {

				List<Route> route = stop_iterate.getRoutes();

				for (Route route_iterate : route) {
					log.info(" Color: " + route_iterate.getColor() + " ,description: " + route_iterate.getDescription()
							+ " ,id: " + route_iterate.getId() + " ,longName: " + route_iterate.getLongName()
							+ " ,shortName: " + route_iterate.getShortName() + " ,textColor: "
							+ route_iterate.getTextColor() + " ,type: " + route_iterate.getType().toString() + " ,url: "
							+ route_iterate.getUrl());

					assertThat(
							(new Object[] { route_iterate.getColor(), route_iterate.getDescription(),
									route_iterate.getId(), route_iterate.getLongName(), route_iterate.getShortName(),
									route_iterate.getTextColor(), route_iterate.getType().toString(), route_iterate.getUrl() }),
							is(new Object[] { "EE352E", "via 5th Av / Madison Av", "MTA NYCT_M1",
									"Harlem - East Village", "M1", "FFFFFF", "3","" }));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(description = "Agency Response Validation", enabled = true)
	public static void agencyResponseValiatio() {

		log.info("*********************************************************************");
		try {
			Data data = buslocation.getData();
			List<Stop> stops = data.getStops();

			for (Stop stop_iterate : stops) {

				List<Route> route = stop_iterate.getRoutes();

				for (Route route_iterate : route) {
					agency = route_iterate.getAgency();
					
					Hash<String,Object> firstBookDetails = agency.getDisclaimer();

					/*log.info(" Disclaimer: " + agency.getDisclaimer() + " ,id: " + agency.getDisclaimer() + " ,lang: "
							+ agency.getLang() + " ,name: " + agency.getName() + " ,phone: " + agency.getPhone()
							+ " ,privateService: " + agency.getPrivateService() + " ,timezone: " + agency.getTimezone()
							+ " ,url: " + agency.getUrl());
				*/
				}
				/*assertThat(
						(new Object[] { agency.getDisclaimer(), agency.getDisclaimer(), agency.getLang(),
								agency.getName(), agency.getPhone(), agency.getPrivateService().toString(), agency.getTimezone(),
								agency.getUrl() }),
						is(new Object[] { "", "", "en", "MTA New York City Transit", "718-330-1234", "false",
								"America/New_York", "http://www.mta.info" }));
*/
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
