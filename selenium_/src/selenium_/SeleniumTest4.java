package selenium_;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest4 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etk.srail.kr/main.do");
		
		Select departure = new Select(driver.findElement(By.name("dptRsStnCd")));
        departure.selectByVisibleText("광주송정");
        
        Select arrival = new Select(driver.findElement(By.name("arvRsStnCd")));
        arrival.selectByValue("0551");
	    	
	    driver.findElement(By.cssSelector("#search-form > fieldset > a")).click();
	    
	}
}
