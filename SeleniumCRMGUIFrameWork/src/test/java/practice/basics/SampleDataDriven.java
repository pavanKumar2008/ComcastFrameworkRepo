package practice.basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDriven {
public static void main(String[] args) throws IOException {
			//step 1: get the java object representation of the physical file
			FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\commondata.properties");
			
			//step 2: using property class load all the key
			Properties pobj=new Properties();
			pobj.load(fis);
			
			//step 3: get the value based on key
			System.out.println(pobj.getProperty("browser"));
		
}
}
