package week4.day2.assignments.leafground;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragLeafGround {

	public static void main(String[] args) {
		//
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();

		Actions action = new Actions(driver);

		// Drag
		WebElement dragAndDrop = driver.findElement(By.xpath("//span[contains(text(),'Drag and Drop')]"));
		action.click(dragAndDrop).perform();
		action.dragAndDropBy(dragAndDrop, 200, 200).perform();

		// Drag and Drop into destination
		WebElement target = driver.findElement(By.xpath("//p[contains(text(),'Drag to target')]"));
		WebElement droppable = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		action.click(target).perform();
		action.dragAndDrop(target, droppable).perform();

		// Draggable Rows
		WebElement draggableTableRow = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper']/table)[2]"));

		List<WebElement> rows = draggableTableRow.findElements(By.tagName("tr"));
		System.out.println("Draggable Row: No. of Rows: " + rows.size());
		List<WebElement> cols = draggableTableRow.findElements(By.tagName("td"));
		System.out.println("Draggable Row: No. of Columns: " + cols.size());

		//action.sendKeys(Keys.PAGE_UP).perform();
		WebElement end = driver.findElement(By.xpath("//h5[contains(text(),'Progress Bar')]"));
		driver.executeScript("arguments[0].scrollIntoView();", end);
		WebElement start = driver.findElement(By.xpath("//h5[contains(text(),'Draggable Rows')]"));
		driver.executeScript("arguments[0].scrollIntoView();", start);
		//
		
		driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper']/table)[1]//tr[1]//td"));

		WebElement s = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper'])[2]/table/tbody/tr[2]"));
		WebElement d = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper'])[2]/table/tbody/tr[4]"));
		action.clickAndHold(s).moveToElement(d).dragAndDrop(s, d).perform();
		
		WebElement row = driver.findElement(By.xpath("(//div[@class='ui-datatable-tablewrapper'])[2]/table/tbody/tr[2]"));
		System.out.println(row.getText());
		//WebElement rowMoved = driver.findElement(By.xpath("//span[@class='ui-growl-title']//following::p"));
		//System.out.println("Row Moved: "+rowMoved.getText());
	}

}
