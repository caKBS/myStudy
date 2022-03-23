package selenium_;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naver.com/");
		WebElement financeBtn = driver.findElement(
				By.cssSelector("#NM_FAVORITE > div.group_nav > ul.list_nav.NM_FAVORITE_LIST > li:nth-child(3) > a"));
	    financeBtn.click();
	    
	    WebElement searchInput = driver.findElement(
				By.cssSelector("#stock_items"));
	    searchInput.sendKeys("삼성전자");
	    searchInput.sendKeys(Keys.ENTER);

	}
}

