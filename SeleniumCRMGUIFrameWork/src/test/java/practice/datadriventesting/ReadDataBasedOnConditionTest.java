package practice.datadriventesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest {
public static void main(String[] args) throws Throwable {
	
	String expectedData="TC_02";
	boolean flag=true;
	FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TestScriptData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("Sheet2");
	
	for(int i=0;i<=sh.getLastRowNum();i++) {
		String data="";
		try {
		data=sh.getRow(i).getCell(0).toString();
		if(data.equals(expectedData)) {
			flag=false;
			for(int j=1;j<sh.getRow(i).getLastCellNum();j++) {
			data=sh.getRow(i).getCell(j).toString();
			System.out.println(data);
		}
		}
		}catch (Exception e) {}
	}
	if(flag) {
		System.out.println(expectedData+" data is not available");
}
}
}
