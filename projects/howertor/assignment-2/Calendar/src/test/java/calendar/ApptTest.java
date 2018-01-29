package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	  public void test02()  throws Throwable  {
		 int startHour=15;
		 int startMinute=00;
		 int startDay=01;
		 int startMonth=02;
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
		 //assertions
		 assertTrue(appt.getValid());
		 appt.setStartHour(14);
		 assertEquals(14, appt.getStartHour());
		 appt.setStartMinute(30);
		 assertEquals(30, appt.getStartMinute());
		 appt.setStartDay(03);
		 assertEquals(03, appt.getStartDay());
		 appt.setStartMonth(03);
		 assertEquals(03, appt.getStartMonth());
		 appt.setStartYear(2018);
		 assertEquals(2018, appt.getStartYear());
		 appt.setTitle("Weekly Standup");
		 assertEquals("Weekly Standup", appt.getTitle());
		 appt.setDescription("This is the weekly standup meeting.");
		 assertEquals("This is the weekly standup meeting.", appt.getDescription());
		 //int[] recurDays = new int[7];
		 appt.setRecurrence(null, Appt.RECUR_BY_WEEKLY, 1, Appt.RECUR_NUMBER_FOREVER);
		 assertTrue(appt.isRecurring());
		 assertArrayEquals(new int[0], appt.getRecurDays());
		 assertEquals(Appt.RECUR_BY_WEEKLY, appt.getRecurBy());
		 assertEquals(1, appt.getRecurIncrement());
		 assertEquals(Appt.RECUR_NUMBER_FOREVER, appt.getRecurNumber());
		 assertEquals("\t3/3/2018 at 2:30pm ,Weekly Standup, This is the weekly standup meeting.\n", appt.toString());
	 }
//add more unit tests as you needed
	
}
