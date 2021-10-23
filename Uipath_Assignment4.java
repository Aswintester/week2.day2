package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uipath_Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://acme-test.uipath.com/login");
		
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
		driver.findElement(By.xpath("//button[contains (text() , 'Login')]")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		Thread.sleep(2000);
		
		driver.close();
		

	}

}
