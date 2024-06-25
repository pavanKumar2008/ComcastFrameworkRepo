package practice.basics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	
	//step 1 : parse Json Physical file into Java Object using JsonParse class
	JSONParser parser = new JSONParser();
	Object obj=parser.parse(new FileReader("C:\\Users\\Pavan\\Desktop\\data\\appCommonData.json"));
	
	//step 2 : Convert Object java into JSONObject using downcasting
	JSONObject map = (JSONObject) obj;
	
	//step3 : Get the value from JSON file using key/;
	System.out.println(map.get("url"));
	System.out.println(map.get("browser"));
	System.out.println(map.get("username"));
	System.out.println(map.get("password"));
	
}
}
