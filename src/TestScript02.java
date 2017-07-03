/*
 * More adequate script
 * 1. Code Maintenance - All parameters saved in util.java file
 * 2. Setup method to launch webdriver code.
 */

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestScript02 {

	static WebDriver driver; 
    private static String baseUrl; 
    
 // This method will read data from class util.java
    public static void setUp() throws Exception {
    	
    	/*
		 * It tells selenium client library to connect with webDriver service using firefox.
		 *  In some PCs user hasnt installed firefox at default location.
		 *  In that case, we need to tell selenium where is firefox.exe
		 */
	
		File pathToBinary = new File(Util.FIREFOX_PATH);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);

		/*
		 * Creating Firefox profile for testing purpose only.
		 * REASON: If something goes wrong it doesn't affect your current bookmarks and imports.
		 */
		
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, firefoxProfile);

	baseUrl = Util.BASE_URL;
	// Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
	// Refer - http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html
	driver.manage().timeouts()
		.implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
	
	driver.get(baseUrl + "/V4/");
    }

      
   public static void main(String[] args) throws Exception {

     	
	
    String username, password;
	String actualTitle;
	String actualBoxtitle;

	    
	    //Setup Firefox driver
	    setUp();
	
	   
	    driver.findElement(By.name("uid")).clear(); 
	    driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);  // Enter username

	   
	    driver.findElement(By.name("password")).clear(); 
	    driver.findElement(By.name("password")).sendKeys(Util.PASSWD);  // Enter Password

	    // Click Login
	    driver.findElement(By.name("btnLogin")).click();

	  	actualTitle = driver.getTitle();
	  	System.out.println(actualTitle);
		if (actualTitle.contains(Util.EXPECT_TITLE)) {
				    System.out.println("Test case: Passed");
		} 
		else {
				    System.out.println("Test case : Failed");
		}
				
	    driver.close();
	    
	

    }

}

        

