package serviceNow;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Snow extends BaseClass {

	@Test
	public void createInc() throws InterruptedException, IOException {


		//Creating INC
		
		driver.switchTo().frame("gsft_main");

		
         driver.findElement(By.xpath("//button[text()='New']")).click();
		

        
	
        
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@role='button'])[2]")).click();

		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Vigneshwaran",Keys.ENTER);
		driver.findElement(By.linkText("Vigneshwaran CSK")).click();

		Thread.sleep(2000);

		driver.switchTo().window(allhandles.get(0));

		driver.switchTo().frame(0);

		driver.findElement(By.id("incident.short_description")).sendKeys("Creating INC via Selenium");

		String text = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The incident number is" + text);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text, Keys.ENTER);
		
		TakesScreenshot ts =((TakesScreenshot)driver);

		File src1=ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src1, new File("D:\\MavenProject\\src\\main\\java\\screenShots\\snow45.png"));

		Thread.sleep(2000);



		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);

		Thread.sleep(2000);










	}

}
