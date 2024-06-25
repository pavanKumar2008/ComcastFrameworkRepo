package practise.testNG;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
@Test(dataProvider = "getData")
public void createContactTest(String firstName,String lastname, long phonenumber) {
	System.out.println("FirstName : "+firstName+", LastName: "+ lastname+", phoneNumber: "+phonenumber);
}
	
@DataProvider
		public Object[][] getData(){
		
		Object [][] objArr=new Object[3][3];
		objArr[0][0]="Pavan";
		objArr[0][1]="HR";
		objArr[0][2]=8698574785l;		
		objArr[1][0]="Sam";
		objArr[1][1]="sp";
		objArr[1][2]=8796574125l;
		
		objArr[2][0]="Jhon";
		objArr[2][1]="Smith";
		objArr[2][2]=7841236985l;
		
		return objArr;
	}
	
	
}
