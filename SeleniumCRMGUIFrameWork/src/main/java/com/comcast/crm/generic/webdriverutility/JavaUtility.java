package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;
/**
 * @author Pavan Kumar Rajbhar
 * 2.	Java utility consists of few generic methods such as generating a random number when data is required unique and 
 * capturing the system date which will be used in the test scripts
 * 
 */
public class JavaUtility {
	
	public int getRandomNumber() {
		Random ranDom=new Random();
		int ranDomNumber=ranDom.nextInt(5000);
		return ranDomNumber;
	}
	
	public String getSystemDateyyyyMMdd() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(d);
		return date;
	}
	 
	public String getRequiredDateyyyyMMdd(int days) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal= Calendar.getInstance();
		cal.getTime();
		String startDate=sdf.format(d);
		cal.add(cal.DAY_OF_MONTH, days);
		String reqDate=sdf.format(cal.getTime());
		return reqDate;
	}
}
