import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUsingTestNG {
	//Setup Firefox driver    	
	WebDriver driver = new FirefoxDriver();
	String baseUrl = "https://www.google.com/";


	@Test
	public void verifyGooglePageTitle() {
	  
		System.out.println("Launching FireFox Browser");
    	// launch Firefox and direct it to the Base URL
    	driver.get(baseUrl);
    	String expectedTitle = "Google";
    	String actualTitle = driver.getTitle();
    	Assert.assertEquals(actualTitle, expectedTitle);
    	driver.close();
	  
  }
}
