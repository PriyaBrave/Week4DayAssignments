package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForceApp {

	public static void main(String[] args) throws InterruptedException {
		// 
ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.getWindowHandle();
		//Entering UserName & Password
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Leaf@1234");
		driver.findElement(By.xpath("//input[@id=\"Login\"]")).click();
		System.out.println(driver.getTitle());
		
		//Mobile Publisher
		driver.findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> winlist = new ArrayList<String>(windows);
		//Switching to another window
		driver.switchTo().window(winlist.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		System.out.println("Title of New Window: "+driver.getTitle());
		
		//Back to Parent Window
		driver.switchTo().defaultContent();
		driver.switchTo().window(winlist.get(0));
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
