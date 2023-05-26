package week4.day2.assignments.jquery;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JQueryUISelectable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.getWindowHandle();
		Actions action = new Actions(driver);
		driver.switchTo().frame(0);

		// Multiple Select
		action.sendKeys(Keys.PAGE_UP).perform();
		WebElement e = driver.findElement(By.xpath("//li[contains(text(),'Item 7')]"));
		driver.executeScript("arguments[0].scrollIntoView();", e);
		WebElement s = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
		driver.executeScript("arguments[0].scrollIntoView();", s);

		List<WebElement> allList = driver.findElements(By.xpath("//ol[@class='ui-selectable']/li"));
		System.out.println("List Size: " + allList.size());

		Actions multipleSelect = action.click(s).keyDown(Keys.ENTER).dragAndDrop(s, e);
		multipleSelect.perform();
		Thread.sleep(1000);

		driver.switchTo().defaultContent();

		// Display as grid
		WebElement scrollTo2 = driver.findElement(By.xpath("//p[contains(text(),'Use the mouse')]"));
		driver.executeScript("arguments[0].scrollIntoView();", scrollTo2);
		driver.findElement(By.xpath("//a[contains(text(),'Display as grid')]")).click();

		driver.switchTo().frame(0);

		List<WebElement> allGrid = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println("Grid Size: " + allGrid.size());

		Thread.sleep(1000);
		WebElement src = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		System.out.println(src.getText());
		Thread.sleep(1000);
		WebElement dest = driver.findElement(By.xpath("//ol[@id='selectable']/li[12]"));
		System.out.println(dest.getText());
		action.click(src).moveToElement(dest).dragAndDrop(src, dest).perform();
		Thread.sleep(1000);

		driver.switchTo().defaultContent();

		// Serialize
		WebElement scrollTo21 = driver.findElement(By.xpath("//p[contains(text(),'Use the mouse')]"));
		driver.executeScript("arguments[0].scrollIntoView();", scrollTo21);
		driver.findElement(By.xpath("//a[contains(text(),'Serialize')]")).click();

		driver.switchTo().frame(0);

		//action.sendKeys(Keys.PAGE_UP).perform();
		WebElement end1 = driver.findElement(By.xpath("//ol[@id='selectable']/li[4]"));
		driver.executeScript("arguments[0].scrollIntoView();", end1);
		WebElement start1 = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		driver.executeScript("arguments[0].scrollIntoView();", start1);

		List<WebElement> allList1 = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		System.out.println("List Size: " + allList1.size());
		System.out.println("Start: "+start1.getText());
		System.out.println("End: "+end1.getText());
		action.dragAndDrop(start1, end1).perform();
		Thread.sleep(1000);

	}

}
