package practice$;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasicsDate {
public static void main(String[] args) {
	//capture System Date
	Date d=new Date();
	System.out.println(d.toString());
	
	//change format
	SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
	String actDate=sd.format(d);
	System.out.println("Actual: "+actDate);
	
	//have userdefined date
	SimpleDateFormat sd1=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal=sd.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,+30);
	String dateRequired=sd1.format(cal.getTime());
	System.out.println("Required: "+dateRequired);
	
}
}
