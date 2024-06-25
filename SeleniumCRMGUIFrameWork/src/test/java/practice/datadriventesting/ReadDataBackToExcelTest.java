package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {
public static void main(String[] args) throws Throwable{
	
	FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TestScriptData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("Sheet2");
	Row row=sh.getRow(10);
	Cell cel=row.createCell(4);
	cel.setCellType(CellType.STRING);
	cel.setCellValue("PASS");
	
	FileOutputStream fos=new FileOutputStream("C:\\Users\\Pavan\\Desktop\\data\\TestScriptData.xlsx");
	wb.write(fos);
	wb.close();
	System.err.println("====Executed====");
}
}
