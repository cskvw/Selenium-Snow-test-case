package serviceNow;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



public class Assign extends BaseClass {
	

    @Test
	public void assignInc() throws InterruptedException {

		
		
		
		
        driver.findElement(By.xpath("//a[@data-original-title='Your history']")).click();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//a[@data-original-title='Incidents | Active = true']")).click();
        
        driver.switchTo().frame("gsft_main");
		
        driver.findElement(By.xpath("//b[text()='All']")).click();
        
		Thread.sleep(2000);
		
	
		
		

		driver.findElement(By.id("incident_table_header_search_control")).sendKeys("INC0010069",Keys.ENTER);
		
		driver.findElement(By.xpath(" //a[text()='INC0010069']")).click();
		
		
		
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		
		Set<String> handle1 = driver.getWindowHandles();
		List<String> listHandle1 = new ArrayList<String>(handle1);


		driver.switchTo().window((String)listHandle1.get(1));
		driver.findElement(By.xpath("(//button[@name='vcr_next'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window((String)listHandle1.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Updating via selenium script");
		driver.findElement(By.id("sysverb_update")).click();
		
	}
}
