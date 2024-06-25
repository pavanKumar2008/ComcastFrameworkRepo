package practice.basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenerateRandomNumber {
public static void main(String[] args) throws IOException {
	Random random=new Random();
	int intrandom=random.nextInt(100);//set upperlimit
	System.out.println(intrandom);
}
}
