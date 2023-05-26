package week4.day2.assignments.leafground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGroundMenu {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();
		
		//Menu Bar
		//1. Customers
		driver.findElement(By.xpath("(//span[contains(text(),'Customers')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'New')])[1]")).click();
		
		Thread.sleep(2000);
		//Tab Menu
		driver.findElement(By.xpath("//span[contains(text(),'Sales')]")).click();
		
		Thread.sleep(2000);
		//Panel Menu
		driver.findElement(By.xpath("//a[contains(text(),'Customers')]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'New')])[2]")).click();
		
		Thread.sleep(2000);
		//Slide Menu
		driver.findElement(By.xpath("(//span[contains(text(),'Customers')])[2]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'New')])[3]")).click();
		
		Thread.sleep(2000);
		//Menu Button
		driver.findElement(By.xpath("//span[contains(text(),'Options')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		
		Thread.sleep(2000);
		//Context Menu
		WebElement contextClick = driver.findElement(By.xpath("(//div[@class='card']/h5)[6]"));
		Actions action = new Actions(driver);
		action.contextClick(contextClick).perform();
		WebElement menu = driver.findElement(By.xpath("(//span[contains(text(),'Save')])[2]"));
		menu.click();
		
		Thread.sleep(2000);
		//)
	}

}
