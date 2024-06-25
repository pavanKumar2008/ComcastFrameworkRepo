package practise.testNG;

import java.util.Random;

import org.testng.annotations.Test;

public class OrderTest {
@Test(priority = -4,invocationCount = 4)
public void createOrderTest() {
	Random r=new Random();
	int rand=r.nextInt(200);
	System.out.println("Execute createOrderTest===>"+rand);
//	String str=null;
//	System.out.println(str.equals("123"));
}

@Test(priority = 2,enabled=true )
public void billingOrderTest() {
	System.out.println("Execute billingAnOrderTest===>123");
}
}
