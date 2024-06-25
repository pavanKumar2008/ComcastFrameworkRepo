package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MergePropertyAndExcelOptimize {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//step 1 create object for property class
	FileInputStream fis =new FileInputStream("J:\\JAVA SELENIUM\\TekPyramid\\SeleniumCRMGUIFrameWork\\Data\\task.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	Set<Object> keys=pobj.keySet();
	int ksize=keys.size();
	
	//Step 2 Create Excel Workbook
	FileInputStream fis1=new FileInputStream("J:\\JAVA SELENIUM\\TekPyramid\\SeleniumCRMGUIFrameWork\\Data\\task.xlsx");
	Workbook ws=WorkbookFactory.create(fis1);
	Sheet sh1=ws.getSheet("Sheet1");
	Sheet sh2=ws.createSheet("result");
	
	//Read from porperty file and write into result
	int i=0;
	for(Object key:keys) {
		sh2.createRow(i++).createCell(0).setCellValue(pobj.getProperty(key.toString()));
	}
	
	//Read from sheet1 and write into sheet2
	for(int j=ksize,k=0;j<=ksize+sh1.getLastRowNum();j++) {
		sh2.createRow(j).createCell(0).setCellValue(sh1.getRow(k++).getCell(0).getStringCellValue());
	}
	FileOutputStream fos= new FileOutputStream("J:\\JAVA SELENIUM\\TekPyramid\\SeleniumCRMGUIFrameWork\\Data\\task.xlsx");
	ws.write(fos);
	ws.close();
	System.out.println("Data inserted succefully");
	
}
}
