package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead_Assignments3 {

	public static void main(String[] args) throws InterruptedException {
		
		//1	Launch the browser
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		//7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//9	Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("9677779469");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("91");
		
		//10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//11 Capture lead ID of First Resulting lead
		
		WebElement leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"));
		String iD = leadID.getText();
		System.out.println("1st leadID is :" +iD);
		
		//12 Click First Resulting lead
		
	     leadID.click();
	    
		
		//13 Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		//14 Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//15 Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(iD);
		
		//16 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		//17 Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement errMsg = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String errMsgg = errMsg.getText();
		String opMsg ="No records to display";
		System.out.println(errMsgg);
		if (errMsgg.equals(opMsg)) {
			System.out.println("ID deleted successfully");
		}
		else {
			System.out.println("ID not deleted successfully");
		}
		
		//18 Close the browser (Do not log out)
		Thread.sleep(3000);
		driver.close();

	}

}
