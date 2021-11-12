package serviceNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ChromeDriver driver;
	

	
    @BeforeMethod
	public void snowBase() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://dev38231.service-now.com/");

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("cskvw");
		
		
		driver.findElement(By.id("user_password")).sendKeys("18#Hawlin@cskvw");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();

		Thread.sleep(2000);
		
         driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident",Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		
	}
	
	 @AfterMethod
	    public void afterMethod() {
	        this.driver.close();
	    }

}
