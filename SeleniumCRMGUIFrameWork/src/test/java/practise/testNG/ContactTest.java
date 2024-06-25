package practise.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest {
@Test(priority = 0)
public void wcreateContact() {
	System.out.println("execute createContact with --->HDFC");
}

@Test(priority = 0,dependsOnMethods ="wcreateContact")
public void amodifyContact() {
	System.out.println("execute ModifyContact--->HDFC->ICICI");
}


@Test(priority = 0,dependsOnMethods = "amodifyContact")
public void ideleteContact() {
	System.out.println("deletecontact---->ICICI");
	
}

@Test(priority =0)
public void tZ() {
	System.out.println("Atact");
}

@Test(priority = '$',enabled = false)
public void $() {
	System.out.println("SC act");
}

}
