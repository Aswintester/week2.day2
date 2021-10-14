package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalseForce_Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.name("UserFirstName")).sendKeys("Aswinkumar");

		driver.findElement(By.name("UserLastName")).sendKeys("R");

		driver.findElement(By.name("UserEmail")).sendKeys("aswinravi5@gmail.com");

		// Selecting Job Title dropdown

		WebElement jobTitle = driver.findElement(By.name("UserTitle"));

		Select jobTitleDD = new Select(jobTitle);

		jobTitleDD.selectByVisibleText("IT Manager");

		driver.findElement(By.name("CompanyName")).sendKeys("Infosys");

		driver.findElement(By.name("UserPhone")).sendKeys("9677779469");

		// Selecting Employees dropdown

		WebElement empyPop = driver.findElement(By.name("CompanyEmployees"));

		Select empyPopDD = new Select(empyPop);

		empyPopDD.selectByIndex(5);

		// Selecting Country dropdown

		WebElement country = driver.findElement(By.name("CompanyCountry"));

		Select countryDD = new Select(country);

		countryDD.selectByValue("IN");

		// Checkbox
		
		driver.findElement(By.xpath("//a[text()='Master Subscription Agreement']")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='checkbox-ui']")).click();
		
		//div[@class='field'])[3]/div[1]

		WebElement submitBtn = driver.findElement(By.xpath("//button[text()='start my free trial']"));

		if (submitBtn.isEnabled()) {

			System.out.print(true);

		} else {
			System.out.print(false);
		}

		driver.close();
	}

}
