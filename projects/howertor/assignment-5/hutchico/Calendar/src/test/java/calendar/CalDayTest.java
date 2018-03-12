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
	  public void testDefaultConstructor()  throws Throwable  {
		CalDay day = new CalDay();
		assertFalse(day.isValid());

		//null iterator
		assertNull(day.iterator());
	 }
	 @Test
	  public void testNullList()  throws Throwable  {
	 	//get the user's current day info
	 	int thisYear;
	 	int thisMonth;
	 	int thisDay;
		//get today's date
	 	Calendar rightnow = Calendar.getInstance();
		thisMonth = 2;
		thisYear = 2018;
		thisDay = 19;
		LinkedList<Appt> appts;
		GregorianCalendar badDay = new GregorianCalendar(thisYear, thisMonth, thisDay);
		CalDay day = new CalDay(badDay);
		assertEquals(0, day.getSizeAppts());
		assertNotNull(day.iterator());
	 }

	 @Test
	  public void testFullList () throws Throwable {
		 //get the user's current day info
		 int thisYear;
		 int thisMonth;
		 int thisDay;
		 //get today's date
		 Calendar rightnow = Calendar.getInstance();
		 thisMonth = 2;
		 thisYear = 2018;
		 thisDay = 19;
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
		 assertNotNull(day.getAppts());
		 //add appt to list
		 day.addAppt(appt);
		 assertEquals(1, day.getSizeAppts());

		 //add new appt to list
		 thisMonth = 2;
		 thisYear = 2018;
		 thisDay = 19;
		 //club appt!
		 startHour=18;
		 startMinute=00;
		 startDay=thisDay;
		 startMonth=thisMonth;
		 startYear=thisYear;
		 title="Club meeting";
		 description="Club meets at this time.";
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 //add appt to list
		 day.addAppt(appt);
		 assertEquals(2, day.getSizeAppts());
	 }

	 @Test
	  public void testToString(){
		 //get the user's current day info
		 int thisYear;
		 int thisMonth;
		 int thisDay;
		 //get today's date
		 Calendar rightnow = Calendar.getInstance();
		 thisMonth = 2;
		 thisYear = 2018;
		 thisDay = 19;
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
		 //add appt to list
		 day.addAppt(appt);
		 assertEquals(1, day.getSizeAppts());

		 //add new appt to list
		 thisMonth = 2;
		 thisYear = 2018;
		 thisDay = 19;
		 //club appt!
		 startHour=18;
		 startMinute=00;
		 startDay=thisDay;
		 startMonth=thisMonth;
		 startYear=thisYear;
		 title="Club meeting";
		 description="Club meets at this time.";
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 //add appt to list
		 day.addAppt(appt);
		 assertEquals("\t --- 2/19/2018 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\t2/19/2018 at 6:0pm ,Club meeting, Club meets at this time.\n" +
				 " \t2/19/2018 at 7:0pm ,Birthday Party, This is my birthday party.\n" +
				 " \n", day.toString());
	 }
//add more unit tests as you needed	
}
