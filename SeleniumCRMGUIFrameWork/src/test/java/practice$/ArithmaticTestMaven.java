package practice$;

import org.testng.annotations.Test;

public class ArithmaticTestMaven {

	@Test(priority = 2)
	public void add() {
		System.out.println(4+5);
	}
	
	@Test(priority = 4)
	public void sub() {
		System.out.println(10-8);
	}
	@Test(priority = 3)
	public void multi() {
		System.out.println(4*4);
	}
	@Test(priority = -2)
	public void div() {
		System.out.println(10/2);
	}
}
