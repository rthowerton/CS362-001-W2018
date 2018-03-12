package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */
public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500; /* Timeout at 12 seconds */
	private static final int NUM_TESTS = 100;

	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	@Test
	public void randomTimeTableTest() throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try {
			// cal = new CalDay(day);
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				TimeTable timeTable = new TimeTable();
				LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				LinkedList<Appt> appts = new LinkedList<Appt>();

				Calendar rightNow = Calendar.getInstance();
				int thisMonth = rightNow.get(Calendar.MONTH) + 1;
				int thisYear = rightNow.get(Calendar.YEAR);
				int firstDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				int secondDay = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				GregorianCalendar day1 = new GregorianCalendar(thisYear, thisMonth, firstDay);
				GregorianCalendar day2 = new GregorianCalendar(thisYear, thisMonth, secondDay);

				for (int i = 0; i < 5; i++) {
					int startHour = ValuesGenerator.getRandomIntBetween(random, -1, 24);
					int startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 60);
					int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 29);
					String title = ValuesGenerator.getString(random);
					String description = ValuesGenerator.getString(random);

					Appt appt = new Appt(startHour,
							startMinute,
							startDay,
							thisMonth,
							thisYear,
							title,
							description);

					appts.add(appt);
				}

				try {
					calDays = timeTable.getApptRange(appts, day1, day2);
				}
				catch(DateOutOfRangeException d){
					continue;
				}

				LinkedList<Appt> deleted = new LinkedList<Appt>();
				int toRemove = ValuesGenerator.getRandomIntBetween(random, 0, 4);
				deleted = timeTable.deleteAppt(appts, appts.get(toRemove));
				deleted = timeTable.deleteAppt(null, null);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing...");
	}
}



