package Utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class URL 
{
	public static Logger log = LogManager.getLogger(URL.class.getName());
	
	public static final String URL = "https://petstore.swagger.io";
	
	public static final String FindBusLocationURL = "http://bustime.mta.info";
	
	public static String getEndpoint()
	{
		log.info("PetStore get Link: " + URL);
		return URL;
	}
	
	public static String postEndpoint(String resources)
	{
		log.info("PetStore Get-Link: " + URL + resources);
		return URL + resources;
	}
	
	public static String Get_FindBusStopLocation()
	{
		log.info("Bus Stop Location URl: " + FindBusLocationURL);
		return FindBusLocationURL;
	}
	
	public static String FindBusStopLocation(String resources)
	{
		log.info("Bus Stop Location URl: " + FindBusLocationURL+resources);
		return FindBusLocationURL+resources;
	}

	public static String FindBusLocationURL(String resourceURl) {
		// TODO Auto-generated method stub
		return null;
	}
}
