package selenium_;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest2 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://finance.naver.com/news/");
		
	    List<WebElement> news = driver.findElements(By.cssSelector(".main_news > ul > li> a"));
	    
	    for (WebElement el : news) {
	    	System.out.println(el.getText());
	    }
	    
	}
}
