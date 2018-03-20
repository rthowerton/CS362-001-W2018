
package finalprojectB;

import junit.framework.TestCase;

import java.net.URL;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
      UrlValidator urlVal = new UrlValidator();
      assertTrue(urlVal.isValid("https://www.google.com/~howertor"));
      assertFalse(urlVal.isValid("www.google.com"));
      assertTrue(urlVal.isValid("https://mail.google.com"));
      assertTrue(urlVal.isValid("https://google.com"));
      assertTrue(urlVal.isValid("https://www.google.com:80"));
      assertFalse(urlVal.isValid("http://localhost:8080"));
      assertTrue(urlVal.isValid("http://110.64.14.174"));
      assertTrue(urlVal.isValid("http://110.64.14.174:80"));
      assertTrue(urlVal.isValid("http://127.0.0.1"));
      assertTrue(urlVal.isValid("http://na.op.gg"));
      assertTrue(urlVal.isValid("http://itslegalinfrance.fr"));
      assertTrue(urlVal.isValid("http://whiskeytangofoxtrot.wtf"));
      assertTrue(urlVal.isValid("https://governmentoftheunitedstatesofamerica.gov/getgoverned"));
      assertTrue(urlVal.isValid("http://www.whypotatoes.net/Incident_of_1876"));
      assertTrue(urlVal.isValid("ftp://TheOfflineUsersGuideToTheInternet.com"));
      assertFalse(urlVal.isValid("h3t://whatevenish3t.net"));
      assertTrue(urlVal.isValid("http://itspicturetime.com/pictures/mfw.jpg"));
      assertTrue(urlVal.isValid("http://hypertextmarkuplanguage.com/index.html"));
      assertTrue(urlVal.isValid("http://whousesphp.com/projects/page.php"));
      assertFalse(urlVal.isValid(""));
      assertFalse(urlVal.isValid(null));
   }
   
   
   public void testSchemePartition()
   {
      UrlValidator urlVal = new UrlValidator();
	 //You can use this function to implement your First Partition testing	   
      assertFalse(urlVal.isValid("www.google.com:80/path"));
      assertTrue(urlVal.isValid("http://www.google.com:80/path"));
      assertFalse(urlVal.isValid("wxyz://www.google.com:80/path"));
   }
   
   public void testDomainPartition()
   {
      UrlValidator urlVal = new UrlValidator();
      //You can use this function to implement your Second Partition testing
      assertFalse(urlVal.isValid("http://:80/path"));
      assertTrue(urlVal.isValid("http://www.google.com:80/path"));
      assertTrue(urlVal.isValid("http://na.op.gg:80/path"));
      assertTrue(urlVal.isValid("http://127.0.0.1:80/path"));
      assertFalse(urlVal.isValid("http://localhost:80/path"));
   }
   //You need to create more test cases for your Partitions if you need to
   public void testPortPartition()
   {
      UrlValidator urlVal = new UrlValidator();
      assertTrue(urlVal.isValid("http://www.google.com/path"));
      assertFalse(urlVal.isValid("http://www.google.com:-1/path"));
      assertTrue(urlVal.isValid("http://www.google.com:80/path"));
      assertTrue(urlVal.isValid("http://www.google.com:65535/path"));
      assertFalse(urlVal.isValid("http://www.google.com:65536/path"));
   }

   public void testOptionsPartition()
   {
      UrlValidator urlVal = new UrlValidator();
      assertTrue(urlVal.isValid("http://www.google.com:80"));
      assertTrue(urlVal.isValid("http://www.google.com:80/path"));
      assertFalse(urlVal.isValid("http://www.google.com:80//path"));
      assertTrue(urlVal.isValid("http://www.google.com:80/path/index.html"));
   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
