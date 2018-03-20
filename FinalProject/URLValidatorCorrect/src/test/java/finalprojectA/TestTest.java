package finalprojectA;

import junit.framework.TestCase;

public class TestTest extends TestCase {
    public void testManualTest()
    {
    //You can use this function to implement your manual testing
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("https://www.google.com"));
        assertFalse(urlVal.isValid("www.google.com"));
        assertTrue(urlVal.isValid("https://mail.google.com"));
        assertTrue(urlVal.isValid("https://google.com"));
        assertTrue(urlVal.isValid("https://www.google.com:80"));
        assertFalse(urlVal.isValid("http://localhost:8080"));
        assertTrue(urlVal.isValid("http://100.64.14.174"));
        assertTrue(urlVal.isValid("http://100.64.14.174:80"));
        assertTrue(urlVal.isValid("http://127.0.0.1"));
        assertTrue(urlVal.isValid("http://na.op.gg"));
        assertTrue(urlVal.isValid("http://itslegalinfrance.fr"));
        assertTrue(urlVal.isValid("http://whiskeytangofoxtrot.wtf"));
        assertTrue(urlVal.isValid("https://governmentoftheunitedstatesofamerica.gov/getgoverned"));
        assertTrue(urlVal.isValid("http://www.whypotatoes.net/Incident_of_1876"));
        assertTrue(urlVal.isValid("ftp://TheOfflineUsersGuideToTheInternet.com"));
        //assertTrue(urlVal.isValid("h3t://whatevenish3t.net"));
        assertTrue(urlVal.isValid("http://itspicturetime.com/pictures/mfw.jpg"));
        assertTrue(urlVal.isValid("http://hypertextmarkuplanguage.com/index.html"));
        assertTrue(urlVal.isValid("http://whousesphp.com/projects/page.php"));
        assertFalse(urlVal.isValid(""));
        assertFalse(urlVal.isValid(null));
    }
}
