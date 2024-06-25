package practise.testNG;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.comcast.crm.generic.fileutility.ExcelUtility;

public class Task1DataProvider extends ExcelUtility{
	
	@Test(dataProvider = "getData")
	public void main1(String BrandName, String Productname,String platform,String BrandName1, String Productname2,String platform3) {
		System.out.println(BrandName+","+Productname+", "+platform);
		StringBuilder sb=new StringBuilder();
		
	}
	
@DataProvider
public Object[][] getData() throws IOException, Throwable {
	
	Object [][] objArr=new Object[getRowcount("Sheet1")][getColoumncount("Sheet1")];
	System.out.println(getRowcount("Sheet1")+" & "+getColoumncount("Sheet1"));
	for(int i=0;i<getRowcount("Sheet1");i++) {
		for(int j=0;j<getColoumncount("Sheet1");j++) {
				objArr[i][j]=getDataFromExcel("Sheet1", i+1, j);
		}
	}
	
	return objArr;
	
}

}
