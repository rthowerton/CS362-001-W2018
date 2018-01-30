package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		CalDay day = new CalDay();
		assertFalse(day.isValid());
	 }
	 @Test
	  public void test02()  throws Throwable  {
	 	//get the user's current day info
	 	int thisYear;
	 	int thisMonth;
	 	int thisDay;
		//get today's date
	 	Calendar rightnow = Calendar.getInstance();
		thisMonth = 2;
		thisYear = 2018;
		thisDay = 19;
		//make appointments list
		LinkedList<Appt> appts = new LinkedList<Appt>();
		//birthday appt!
		int startHour=19;
		int startMinute=00;
		int startDay=thisDay;
		int startMonth=thisMonth;
		int startYear=thisYear;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour,
			 startMinute ,
			 startDay ,
			 startMonth ,
			 startYear ,
			 title,
			 description);
		//create CalDay
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay day = new CalDay(today);
		//test get methods
		assertEquals(2, day.getMonth());
		assertEquals(2018, day.getYear());
		assertEquals(19, day.getDay());
		assertNull(day.getAppts());
		//add appt to list
		day.addAppt(appt);
		assertEquals(1, day.getSizeAppts());
		assertEquals("\t --- 2/19/2018 --- \n --- -------- Appointments ------------ --- \n", day.toString());











		//GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		//tomorrow.add(Calendar.DAY_OF_MONTH,1);
	 }
//add more unit tests as you needed	
}
