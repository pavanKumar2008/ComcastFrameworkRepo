package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MergePropertyAndExcelSheet {
public static void main(String[] args) throws IOException {
	//read from property file and load all the element
	FileInputStream fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TaskData.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	
	//read from excel and control over row and cell
	fis=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TaskData.xlsx");
	Workbook ws=WorkbookFactory.create(fis);
	Sheet sh=ws.getSheet("Sheet1");
	int lrow=sh.getLastRowNum();
	Row row=null;Cell cel=null;
	
	//To store value of property file and excel
	ArrayList <String> al=new ArrayList();
	
	//print from properties
	String r="";
	int size=pObj.keySet().size();
	for(int i=0;i<=size-1;i++) {
	r=pObj.getProperty("Key"+i);
	row=sh.getRow(i);
	System.out.println(r);
	al.add(r);//add properties element to Arraylist
	}
	
	//print from excel
	for(int i=0;i<=lrow;i++) {
	row=sh.getRow(i);
	cel=row.getCell(0);
	String data=cel.getStringCellValue();
	System.out.println(data);
	al.add(data);
	}
	ws.close();
	write(al); //method calling statement
 }

public static void write(ArrayList<String> al) throws EncryptedDocumentException, IOException {
	//write data back to excel
		System.out.println(al+" size "+al.size());
		for(int i = 0; i< al.size(); i++ ) {
		FileInputStream fis1=new FileInputStream("C:\\Users\\Pavan\\Desktop\\data\\TaskData.xlsx");
		Workbook ws1=WorkbookFactory.create(fis1);
		Sheet sh1=ws1.getSheet("result");
		Row row1=sh1.createRow(i);
		Cell cel1=row1.createCell(0);
		cel1.setCellType(CellType.STRING);
		String ss=al.get(i);
		cel1.setCellValue(ss);
		System.out.println(ss);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Pavan\\Desktop\\data\\TaskData.xlsx");
		ws1.write(fos);
		ws1.close();
		}
		System.out.println("=======>Executed<========");
}
}