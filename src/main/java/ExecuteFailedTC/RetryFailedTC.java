package ExecuteFailedTC;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTC implements IRetryAnalyzer
{
	int counter = 0 , retryCount = 3;

	public boolean retry(ITestResult result)
	{
		if(counter<retryCount)
		{
			counter++;
			return true;
		}
		return false;
	}
	
}
