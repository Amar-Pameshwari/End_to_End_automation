package Utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import io.restassured.response.Response;

public class AssertionsUtilities {
	
	public static Logger log = LogManager.getLogger(AssertionsUtilities.class.getName());
	
	//verifying True Method
	public static void verifyTrueFlag(boolean flag)
	{
		Assert.assertTrue(flag);
	}
	
	//verifying False Method
	public static void verifyFalseFlag(boolean flag)
	{
		Assert.assertFalse(flag);
	}

	//Assert status code with actual result
	public static void verifyStatusCode(Response response, int statusCode)
	{
		Assert.assertEquals(Utilities_jsonPath_asString.StatusCode(response), statusCode);
	}
	
	//Assert status code message with actual result
	public static void verifyStatusLine(Response response, String statusMessage)
	{
		Assert.assertEquals(Utilities_jsonPath_asString.statusMessage(response), statusMessage);
	}
	
	public static void verifyActualExpeactedResult(String Expected, String Actual)
	{
		Assert.assertEquals(Expected, Actual);
	}
}
