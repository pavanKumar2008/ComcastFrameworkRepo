package practise.testNG;

import org.testng.annotations.Test;

public class CreateContactTest {
@Test(priority = 10)
public static void loginTest() {
	System.out.println("1");
	System.out.println("hillo");
	System.out.println("bi");
	System.out.println("nug");
	
}
@Test(priority = -020/1000)
public void createContactTest() {
	System.out.println("2");
	System.out.println("hillo");
	System.out.println("bi");
	System.out.println("nug");
	
}
@Test(priority =0)
public void CreateOrgTest() {
	System.out.println("3");
	System.out.println("hillo");
	System.out.println("bi");
	System.out.println("nug");
	
}
public static void main(String[] args) {
	System.out.println("from main");
}
}
