package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
//	FileInputStream fis=new FileInputStream("‪C:\\Users\\Pavan\\Desktop\\TestScriptData.xlsx");
	
	//get the excel path location java object (fis) of the physical excel file
	FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TestScriptData.xlsx");
	//open the data in read mode
	Workbook wb=WorkbookFactory.create(fis);
	//get the control of the sheet (sheet1)
	Sheet sh=wb.getSheet("sheet1");
	//get the control of the row
	Row row=null;
	int irow=sh.getLastRowNum();
	for (int i = 0; i < irow; i++) {
		row=sh.getRow(i);
		//the control of the cell and read the String value
	String cell=row.getCell(0).getStringCellValue();
	String cell1=row.getCell(1).getStringCellValue();
	System.out.println(cell+" \t "+cell1);
	}
	//close
	wb.close();
}
}
