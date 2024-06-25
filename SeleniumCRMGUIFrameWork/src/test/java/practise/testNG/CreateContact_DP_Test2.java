package practise.testNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {
@Test(dataProvider ="getData")
public void createContactTest(String firstName,String lastname) {
	System.out.println("FirstName : "+firstName+", LastName: "+ lastname);
}

	@DataProvider(name="getData")
		public Object[][] getData(){
		Object [][] objArr=new Object[3][2];
		objArr[0][0]="Pavan";
		objArr[0][1]="HR";
		
		objArr[1][0]="Sam";
		objArr[1][1]="sp";
		
		objArr[2][0]="Jhon";
		objArr[2][1]="Smith";
	
		return objArr;
	}
	
	@BeforeMethod
	public void metadata() {
		System.out.println("BM!");
	}
	
}
