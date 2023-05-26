package week4.day2.assignments.leafground;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();
		
		//List<WebElement> tableHeading = driver.findElements(By.xpath("(//table[@role='grid'])[1]/thead/tr"));
		//for (WebElement heading : tableHeading) {
			//WebElement heading = driver.findElement(By.xpath("(//table[@role='grid'])[1]/thead/tr"));
			//System.out.print(heading.getText()+" | ");
		//} 
		
		List<WebElement> rows = driver.findElements(By.xpath("(//table[@role='grid'])[2]/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("(//table[@role='grid'])[2]/tbody/tr/td"));
		System.out.println("Rows: "+rows.size()+" Cols: "+cols.size());
		
		List<WebElement> pages = driver.findElements(By.xpath("//span[@class='ui-paginator-pages']/a"));
		int psize = pages.size();
		System.out.println("Pages Size: "+psize);
		
		//int page1 = Integer.parseInt(pages.get(0).getText());
		//int page5 = Integer.parseInt(pages.get(psize).getText());
		
		//while(!pages.isEmpty()) {
			for (WebElement r : rows) {
				List<WebElement> allCells = r.findElements(By.tagName("td"));
				for (WebElement cells : allCells) {
					System.out.print(cells.getText()+" | ");
				}
				System.out.println();
			}
		//}
		
	}

}
