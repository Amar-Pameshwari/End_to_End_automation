package FindBusStopLocation;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonObject_TestUtils 
{
	public static String getValueByJPath(JSONObject responsejson, String Jpath)
	{
		Object obj = responsejson;
		for(String s:Jpath.split("/"))
			if(!s.isEmpty())
				if(!(s.contains("[")||s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if(s.contains("[")||s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
			return obj.toString();
	}
}
