package serviceNow;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;


public class UpdatingInc extends BaseClass {

	
	
	@Test
	public void updateInc() throws InterruptedException {

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));

		driver.switchTo().frame(frame);


		driver.findElement(By.xpath("//input[contains(@class,'list_header_search ')] [1]")).sendKeys("INC0010069",Keys.ENTER);
		
		driver.findElement(By.xpath(" //a[text()='INC0010069']")).click();

		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select drop = new Select(urgency);

		drop.selectByValue("1");
		WebElement state =driver.findElement(By.id("incident.state"));
		Select drop1 = new Select(state);
		drop1.selectByValue("2");
		driver.findElement(By.xpath("(//button[@value='sysverb_update'])[1]")).click();
		
		driver.findElement(By.xpath(" //a[text()='INC0010069']")).click();

		
		WebElement status = driver.findElement(By.xpath("//span[text()='In Progress']"));

		String state1 = status.getText();

		if (state1.contains("In Progress")) {
			System.out.println("Status Verified");
		} else {
			System.out.println("Status is different");
		}

		WebElement priority = driver.findElement(By.xpath("//span[text()='3 - Moderate']"));
		String text2 = priority.getText();

		if (text2.contains("Moderate")) {
			System.out.println("Priority verified");
		} else {
			System.out.println("Not verified");
		}

	}

}
