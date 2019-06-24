package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;


public class dateSelector {
	
	static Logger log = Logger.getLogger("devpinoyLogger");
	public static Date dateAcceptor(String date) throws ParseException
	{
		
		String[] datevalue = date.split(" ");
		String currentmonth = datevalue[1];
		String currentdate = datevalue[2];
		String currentyear = datevalue[3];
		String dateformat = currentdate+"-"+currentmonth+"-"+currentyear;
		String pattern = "dd-MMM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date d = simpleDateFormat.parse(dateformat);
		
		return d;
		
	}
	
	public static int dateDifference(Date dateCal1, Date dateCal2)
	{
		Calendar c1 = Calendar.getInstance();
		c1.setTime(dateCal1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(dateCal2);
				
		int diffYear = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		int diffMonth = diffYear*12 + (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH));
		return diffMonth;
	}
	
	public static int numberOfClicks(String date1, String date2) throws ParseException
	{
		int noclicks =0;
		Date dateaccept1 = dateAcceptor(date1);
		log.debug(dateaccept1);
		Date dateaccept2 = new SimpleDateFormat("dd-MMM-yyyy").parse(date2); 
		log.debug(dateaccept2);
		int n = dateDifference(dateaccept1, dateaccept2);
		log.debug(n);
		if(n>1)
		{
			noclicks = n-1;
			
		}
		
		return noclicks;
	}
	
	public static String convertDateToXpath(String date) throws ParseException
	{
		log.info(date);
		String pattern = "dd-MMM-yyyy";
		log.debug("String message defined in above step");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		log.debug("Simpledateformat defined");
		Date d = simpleDateFormat.parse(date);
		log.debug("Date for Xpath: "+d);
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEE MMM dd yyyy");
		String dateString = simpleDateFormat1.format(d);
		log.debug("Date String for Xpath: "+dateString);
		String dateXpath = "//*[@aria-label='"+dateString+"']";
		log.debug(dateXpath);
		return dateXpath;
		
	}
}

