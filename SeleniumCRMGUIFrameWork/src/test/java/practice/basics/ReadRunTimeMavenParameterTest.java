package practice.basics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {

	@Test
	public void runTimeParameterTest() {
		//url
		String url=System.getProperty("url");
		System.out.println("Env Data==>URL ====>"+url);
		//browser
		String browser=System.getProperty("browser");
		System.out.println("Browser Data==>Browser ====>"+browser);
		//username
		String username=System.getProperty("username");
		System.out.println("username Data==>username ====>"+username);
		//Password
		String password=System.getProperty("password");
		System.out.println("password Data==>password ====>"+password);
	}
}
