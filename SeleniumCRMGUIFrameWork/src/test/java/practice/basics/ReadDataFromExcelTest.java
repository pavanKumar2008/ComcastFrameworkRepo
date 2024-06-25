package practice.basics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	// Step 1:Get the Excel path location & java Object of the physical Excel file.
	FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TestScriptData.xlsx");
	
	// Step 2:open the data in read mode
	Workbook wb=WorkbookFactory.create(fis);
	
	// Step 3: get the control of the "org" sheet
	Sheet sh=wb.getSheet("org");
	
	//Step 4: get the control of the first row
	Row row=sh.getRow(1);
	
	//Step 5: get the control of the "2nd" cell and read the String data
	String cell=row.getCell(3).getStringCellValue();
//	String data=cell.getStringCellValue();
	System.out.println(cell);
	
	//Step 6: close the WorkBook
	wb.close();
	
}
}
