package week4.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HTMLTable {

	public static void main(String[] args) throws InterruptedException {
		// 		
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();
		
		WebElement table = driver.findElement(By.xpath("//div[@class=\"render\"]/table"));
		List<WebElement> rows = table.findElements(By.xpath("//div[@class=\"render\"]/table//tbody//tr"));
		List<WebElement> cols = table.findElements(By.xpath("//div[@class=\"render\"]/table//tbody//tr//td"));
		
		//Printing the no. of rows ands columns
		System.out.println("No. of Rows: "+rows.size());
		System.out.println("No. of Columns: "+cols.size());
		
		//Printing the Table   
		List<WebElement> hrow = driver.findElements(By.xpath("(//table)[1]/thead/tr"));
		
		for (WebElement hr : hrow) {
			List<WebElement> cells = hr.findElements(By.tagName("th"));
			for (WebElement headings : cells) {
				System.out.print(headings.getText()+" | ");
			}
			System.out.println();
		}
		for (WebElement allrows : rows) {
			List<WebElement> cells = allrows.findElements(By.tagName("td"));
			for (WebElement allcells : cells) {
				System.out.print(allcells.getText()+" | ");
			}
			System.out.println();
		}
		
		String tableFootText = driver.findElement(By.xpath("(//table)[1]/tfoot/tr/td")).getText();
		System.out.println(tableFootText);	
	}

}
