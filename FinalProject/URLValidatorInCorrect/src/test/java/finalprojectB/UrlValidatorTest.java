
package finalprojectB;


import junit.framework.TestCase;
import java.util.Random;
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
      assertTrue(urlVal.isValid("https://www.google.com/"));
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
      UrlValidator urlVal = new UrlValidator();
	  //You can use this function for programming based testing
      //You can use this function for programming based testing
      long randomseed = System.currentTimeMillis();
      Random random = new Random (randomseed);
      String toTest = "";
      int inner, outer, choice, toggle;
      boolean result;
      boolean testType;
      //String preArr[] = {"http://","https://","ftp://"};
      ResultPair[] preArr = {new ResultPair("https://",true),new ResultPair("http://",true),new ResultPair("ftp://",true),new ResultPair("fgp://",false),new ResultPair("afl://",false)};
      //String midArr[] = {"google","yahoo","oregon"};
      ResultPair[] midArr = {new ResultPair("www.google.com",true),new ResultPair("google.com",true),new ResultPair("yahoo.com",true),new ResultPair("asdgasdg",false),new ResultPair("wrtfhum",false)};
      //String postArr[] = {".com",".org",".gov"};
      ResultPair[] postArr = {new ResultPair(":80",true),new ResultPair(":35",true),new ResultPair(":0",true),new ResultPair("-1",false),new ResultPair("-3608",false)};
      //String pathArr[] = {"/test","/file","/123"};
      ResultPair[] pathArr = {new ResultPair("/test",true),new ResultPair("/address",true),new ResultPair("/try/this/",true),new ResultPair("This shouldn't work",false),new ResultPair("~/totallysafe path",false)};



      for(outer = 0; outer < 10; outer++){
         choice = random.nextInt(2);
         if(choice == 1)
            testType = false;
         else
            testType = true;
         toggle = 0;
         while(toggle == 0){
            choice = random.nextInt(5);
            if(preArr[choice].valid == testType){
               toTest = preArr[choice].item;
               toggle = 1;
            }
         }
         toggle = 0;
         while(toggle == 0){
            choice = random.nextInt(5);
            if(midArr[choice].valid == testType){
               toTest = toTest + midArr[choice].item;
               toggle = 1;
            }
         }
         toggle = 0;
         while(toggle == 0){
            choice = random.nextInt(5);
            if(postArr[choice].valid == testType){
               toTest = toTest + postArr[choice].item;
               toggle = 1;
            }
         }
         toggle = 0;
         while(toggle == 0){
            choice = random.nextInt(5);
            if(pathArr[choice].valid == testType){
               toTest = toTest + pathArr[choice].item;
               toggle = 1;
            }
         }
         System.out.println(toTest);
         result = urlVal.isValid(toTest);
         System.out.println(result);
         //assertEquals(testType,result);
      }
   }
}
