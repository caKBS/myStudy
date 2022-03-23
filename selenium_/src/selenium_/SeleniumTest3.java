package selenium_;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest3 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.letskorail.com/");
		
	    System.out.println(driver.getWindowHandles());
        
	    String mainPage = driver.getWindowHandle();
	    
	    for (String handle : driver.getWindowHandles()) {
	    	if(!handle.equals(mainPage)) {
	    		driver.switchTo().window(handle).close();
	    	}
	    }
	    
	    driver.switchTo().window(mainPage);
	    	
	    
	    
	}
}
