package Utilities;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class filePathConvertor 
{

	public static Logger log = LogManager.getLogger(filePathConvertor.class.getName());
	
	public static String createJsonFile(String fileName)
	{
		String filePath = System.getProperty("user.dir")+"\\JsonPayloads\\"+fileName;
		log.info("Inside the file fn: ");
		try
		{
		return new String(Files.readAllBytes(Paths.get(filePath)));
		}
		catch(Exception e)
		{
			log.error(e);
			return null;
		}
		
	}
	
}
