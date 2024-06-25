package task;

import org.testng.annotations.Test;

public class Sample {
@Test(dependsOnMethods = "m2")
public void m1() {
	System.out.println("25");
}

}
