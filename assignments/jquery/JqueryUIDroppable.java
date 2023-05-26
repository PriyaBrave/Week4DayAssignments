package week4.day2.assignments.jquery;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JqueryUIDroppable {

	public static void main(String[] args) {
		// 
		
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();

		Actions action = new Actions(driver);
		
		WebElement src = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement dest = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		action.click(src).perform();
		action.dragAndDrop(src, dest).perform();
		
	}

}
