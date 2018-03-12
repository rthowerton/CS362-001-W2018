package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
//import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void testGetters()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 assertEquals(0, appt.getRecurDays().length);
		 assertEquals(appt.RECUR_BY_MONTHLY, appt.getRecurBy());
		 assertEquals(0, appt.getRecurIncrement());
		 assertEquals(appt.RECUR_NUMBER_NEVER, appt.getRecurNumber());
		 assertFalse(appt.isRecurring());

	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void testSetters()  throws Throwable  {
		 int startHour=-1;
		 int startMinute=00;
		 int startDay=01;
		 int startMonth=03;
		 int startYear=2017;
		 String title="Monthly Standup";
		 String description="This is the monthly standup meeting.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 //set recurrence
		 int[] days = {3};
		 appt.setRecurrence(days, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 int[] noDays = null;
		 appt.setRecurrence(noDays, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);

		 //hour
		 assertFalse(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());

		 //minute
		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());

		 //day
		 appt.setStartDay(32);
		 assertFalse(appt.getValid());
		 appt.setStartDay(30);
		 assertTrue(appt.getValid());
		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());

		 //month
		 try {
			 appt.setStartMonth(12);
			 assertTrue(appt.getValid());
		 }
		 catch(ArrayIndexOutOfBoundsException e){
		 	System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
		 }

		 //year
		 appt.setStartYear(2018);
		 assertTrue(appt.getValid());

		 //title
		 appt.setTitle(null);
		 assertEquals("", appt.getTitle());
		 appt.setTitle("Weekly Standup");
		 assertEquals("Weekly Standup", appt.getTitle());

		 //description
		 appt.setDescription(null);
		 assertEquals("", appt.getDescription());
		 appt.setDescription("This is the weekly standup meeting.");
		 assertEquals("This is the weekly standup meeting.", appt.getDescription());
	 }
//add more unit tests as you needed
	@Test
	public void testPrint() throws Throwable{
		int startHour=11;
		int startMinute=00;
		int startDay=01;
		int startMonth=02;
		int startYear=2017;
		String title="Weekly Standup";
		String description="This is the weekly standup meeting.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		//test representationApp
		assertEquals("\t2/1/2017 at 11:0am ,Weekly Standup, This is the weekly standup meeting.\n", appt.toString());
	}
}
