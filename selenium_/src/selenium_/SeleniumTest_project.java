package selenium_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTest_project {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// Get in the Site
		driver.get("https://etk.srail.kr/cmc/01/selectLoginForm.do?pageId=TK0701000000");
		
		// Input ID
		WebElement idInput = driver.findElement(
				By.cssSelector("#srchDvNm01"));
	    idInput.sendKeys("2182567582");
	    
	    // Input PW
	    WebElement pwInput = driver.findElement(
				By.cssSelector("#hmpgPwdCphd01"));
	    pwInput.sendKeys("ssafy220114!");

		// Press login
		driver.findElement(By.cssSelector
				("#login-form > fieldset > div.input-area.loginpage.clear > div.fl_l > div.con.srchDvCd1 > div > div.fl_r > input")).click();
		
		//departure
		Select departure = new Select(driver.findElement(By.name("dptRsStnCd")));
        departure.selectByVisibleText("나주");
        
        //arrival
        Select arrival = new Select(driver.findElement(By.name("arvRsStnCd")));
        arrival.selectByValue("0551");
	    
        //search
	    driver.findElement(By.cssSelector("#search-form > fieldset > a")).click();
	    
	    

	    // press reservation
	 	driver.findElement(By.cssSelector
		 	("#result-form > fieldset > div.tbl_wrap.th_thead > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
	}
}

//
