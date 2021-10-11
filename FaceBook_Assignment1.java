package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook_Assignment1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); // configure Browser

		ChromeDriver driver = new ChromeDriver(); // Launch Browser

		driver.manage().window().maximize(); // Max browser

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // implicit wait

		driver.get("https://en-gb.facebook.com/"); // Launching url

		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();

		driver.findElement(By.name("firstname")).sendKeys("Aswin"); // Enter the first name

		driver.findElement(By.name("lastname")).sendKeys("Kumar"); //Enter Last name

		driver.findElement(By.name("reg_email__")).sendKeys("aswinravi5@gmail.com"); //Enter email

		driver.findElement(By.name("reg_passwd__")).sendKeys("Aswin@2233"); //Enter Password
		
		//Handling DropDown - DOB using Value,Index and Visible Text

		WebElement day = (driver.findElement(By.id("day")));

		Select dayDD = new Select(day);

		dayDD.selectByVisibleText("22");

		WebElement mnth = (driver.findElement(By.id("month")));

		Select mnthDD = new Select(mnth);

		mnthDD.selectByIndex(3);

		WebElement year = (driver.findElement(By.id("year")));

		Select yearDD = new Select(year);

		yearDD.selectByValue("1994");
		
		//Handling Radio button
		
		driver.findElement(By.xpath("//input[@value='2']")).click();

		//Close Browser
		
		driver.close();

	}

}
