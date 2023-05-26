package week4.day2.assignments.jquery;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JQueryUISortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();

		Actions action = new Actions(driver);
		driver.switchTo().frame(0);

		// Reorder elements in a list or grid using the mouse.

		// Default Functionality
		action.sendKeys(Keys.PAGE_UP).perform();
		WebElement end = driver.findElement(By.xpath("//li[contains(text(),'Item 7')]"));
		driver.executeScript("arguments[0].scrollIntoView();", end);
		WebElement start = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
		driver.executeScript("arguments[0].scrollIntoView();", start);
		List<WebElement> reorder = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		System.out.println("Reorder Size: " + reorder.size());
		WebElement lastElement = driver.findElement(By.xpath("//li[text()='Item " + reorder.size() + "']"));
		for (int i = 1; i <= reorder.size() - 1; i++) {
			WebElement elementToDrag = driver.findElement(By.xpath("//li[text()='Item " + i + "']"));
			action.clickAndHold(elementToDrag).dragAndDrop(elementToDrag, lastElement).build().perform();
			Thread.sleep(1000);
		}

		System.out.println("Reordered..");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		// Connect Lists
		WebElement scrollTo2 = driver.findElement(By.xpath("//p[contains(text(),'Reorder elements')]"));
		driver.executeScript("arguments[0].scrollIntoView();", scrollTo2);
		driver.findElement(By.xpath("//a[contains(text(),'Connect lists')]")).click();
		driver.switchTo().frame(0);

		List<WebElement> totalList1 = driver.findElements(By.xpath("//ul[@id='sortable1']/li"));
		List<WebElement> totalList2 = driver.findElements(By.xpath("//ul[@id='sortable2']/li"));
		System.out.println("List 1: " + totalList1.size() + " **** List 2: " + totalList2.size());
		int count = 1;
		for (int i = 1; i <= 1; i++) {
			for (int j = 1; j <= totalList2.size(); j++) {
				Thread.sleep(1000);
				WebElement addList1 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[" + i + "]"));
				WebElement drop = driver.findElement(By.xpath("//ul[@id='sortable2']/li[" + count + "]"));
				count = count + 2;
				System.out.println("Count: " + count + "i: " + i);
				while (count <= 11) {
					action.dragAndDrop(addList1, drop).perform();
					break;
				}

			}
		}

		// Display as grid
		System.out.println("Reordered..");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Display as grid')]")).click();
		driver.switchTo().frame(0);

		List<WebElement> reorderGrid = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		System.out.println("Grid Size: " + reorderGrid.size());
		// WebElement lastElementGrid =
		// driver.findElement(By.xpath("//li[contains(text(),'12')]"));

		Random rand = new Random();
		for (int i = 1; i <= reorderGrid.size(); i++) {
			Thread.sleep(1000);
			int r = rand.nextInt(12) + 1;
			WebElement src = driver.findElement(By.xpath("//li[contains(text(),'" + i + "')]"));
			WebElement dest = driver.findElement(By.xpath("//li[contains(text(),'" + r + "')]"));
			System.out.println("r: " + r + "** i: " + i);
			while (count <= 12) {
				action.click(src).dragAndDrop(src, dest).build().perform();
				Thread.sleep(1000);
				break;
			}
		}

		System.out.println("URL: " + driver.getCurrentUrl());
	}

}
