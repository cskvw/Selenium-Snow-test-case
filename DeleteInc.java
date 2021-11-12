package serviceNow;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class DeleteInc extends BaseClass {

	@Test
	public void deleteInc() throws InterruptedException {
		
		

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));

		driver.switchTo().frame(frame);


		driver.findElement(By.xpath("//input[contains(@class,'list_header_search ')] [1]")).sendKeys("INC0010069",Keys.ENTER);
		
		driver.findElement(By.xpath(" //a[text()='INC0010069']")).click();
		
		
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
        driver.findElement(By.xpath("//button[@id='ok_button']")).click();
        Thread.sleep(2000L);
       driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC0010069", Keys.ENTER);
        String text =driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
       
        if (text.contains("No record")) {
            System.out.println("Incident deleted");
        } else {
            System.out.println("Incident not deleted");
        }

	}

}
