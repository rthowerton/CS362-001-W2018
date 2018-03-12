package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 200; /* Timeout at 15 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	@Test
	public void randomCalDayTest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{
			Calendar rightNow = Calendar.getInstance();
			int thisMonth = rightNow.get(Calendar.MONTH) + 1;
			int thisDay = rightNow.get(Calendar.DAY_OF_MONTH);
			int thisYear = rightNow.get(Calendar.YEAR);
			GregorianCalendar day = new GregorianCalendar(thisYear, thisMonth, thisDay);

			CalDay cal = new CalDay(day);
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.getRandomIntBetween(random, -1, 24);
				int startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 60);
				String title = ValuesGenerator.getString(random);
				String description = ValuesGenerator.getString(random);

				Appt appt = new Appt(startHour,
						startMinute,
						thisDay,
						thisMonth,
						thisYear,
						title,
						description);

				cal.addAppt(appt);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}



}