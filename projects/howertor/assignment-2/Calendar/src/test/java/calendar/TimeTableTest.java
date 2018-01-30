package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void testConstructor()  throws Throwable  {
		 TimeTable timetable = new TimeTable();
		 assertNotNull(timetable);
	 }
	 @Test
	  public void testBadDates()  throws Throwable  {
	 	 /**setting up a new time table using CalendarMain as a template**/
		 TimeTable timeTable = new TimeTable();
		 //set of calendar days
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 //list of appointments
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 int thisMonth, thisYear, thisDay;

		 //get todays date
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 thisMonth = rightnow.get(Calendar.MONTH)+1;
		 thisYear = rightnow.get(Calendar.YEAR);
		 thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 /**create sample appointments**/
		 int startHour=15;
		 int startMinute=30;
		 int startDay=thisDay+1;
		 int startMonth=thisMonth;
		 int startYear=thisYear;
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
		 listAppts.add(appt);

		 startHour=14;
		 startMinute=30;
		 startDay=thisDay;
		 startMonth=thisMonth;
		 startYear=thisYear;
		 title="Class";
		 description="Rescheduled class.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);

		 startHour=13;
		 startMinute=30;
		 startDay=thisDay;
		 startMonth=thisMonth;
		 startYear=thisYear;
		 title="Visit";
		 description="Visit parents.";
		 //Construct a new Appointment object with the initial data
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 listAppts.add(appt);

		 //create two days, today and tomorrow
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
		 String todayDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		 String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

		 //get list of appointments in range today and tomorrow
		 try {
			 calDays = timeTable.getApptRange(listAppts, tomorrow, today);
			 assertNull(calDays);
		 }
		 catch(DateOutOfRangeException d){
		 	assertNotNull(d);
		 }
	 }
	@Test
	public void testGoodDates()  throws Throwable  {
		/**setting up a new time table using CalendarMain as a template**/
		TimeTable timeTable = new TimeTable();
		//set of calendar days
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		//list of appointments
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		int thisMonth, thisYear, thisDay;

		//get todays date
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today
		thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

		/**create sample appointments**/
		int startHour=15;
		int startMinute=30;
		int startDay=thisDay+1;
		int startMonth=thisMonth;
		int startYear=thisYear;
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
		int[] recurDays1 = {4};
		appt.setRecurrence(recurDays1, Appt.RECUR_BY_YEARLY, 1, Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt);

		startHour=14;
		startMinute=30;
		startDay=thisDay;
		startMonth=thisMonth;
		startYear=thisYear;
		title="Class";
		description="Rescheduled class.";
		//Construct a new Appointment object with the initial data
		appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		int[] recurDays2 = {1,3,5};
		appt.setRecurrence(recurDays2, Appt.RECUR_BY_WEEKLY, 1, 8);
		listAppts.add(appt);

		startHour=13;
		startMinute=30;
		startDay=thisDay;
		startMonth=thisMonth;
		startYear=thisYear;
		title="Visit";
		description="Visit parents.";
		//Construct a new Appointment object with the initial data
		appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		listAppts.add(appt);

		//create two days, today and tomorrow
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		String todayDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

		//get list of appointments in range today and tomorrow
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		assertNotNull(calDays);
		//test permutation
		int[] pv = {2, 0, 1};
		LinkedList<Appt> permuted=timeTable.permute(listAppts, pv);
		assertNotNull(permuted);
		//delete new appointment 2
		LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(1));
		assertNotNull(listDeletedAppts);
	}
}
