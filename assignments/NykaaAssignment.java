package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.getWindowHandle();
		//Mouse Hover on Brands & Selecting L'Oreal Paris Brands
		WebElement brandstab = driver.findElement(By.xpath("//a[contains(text(),'brands')]"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(brandstab).perform();
		
		Thread.sleep(1000);
		WebElement searchbrand = driver.findElement(By.xpath("//input[@id=\"brandSearchBox\"]"));
		builder.click(searchbrand).perform();
		driver.findElement(By.xpath("//input[@id=\"brandSearchBox\"]")).sendKeys("L'Oreal Paris",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='css-150nd8c']//a")).click();
		
		System.out.println(driver.getTitle());
		
		//Sort By
		driver.findElement(By.xpath("//span[contains(text(),'Sort By : popularity')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		
		//Category
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		driver.findElement(By.xpath("//li[@class='css-1do4irw']//div")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Hair Care')])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).click();
		
		//Concern
		driver.findElement(By.xpath("//span[contains(text(),'Concern')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();
		
		//Checking Filters are Applied
		String filter = driver.findElement(By.xpath("//span[contains(text(),'Filters Applied')]")).getText();
		System.out.println(filter);
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class=\"css-3i7s5s\"]"));
		
		for (WebElement fil : filters) {
			System.out.println(fil.getText());
		}
		
		//Clicking the filtered product (shampoo)
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo With UVA & UVB')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> windowslist = new ArrayList<String>(windows);
		
		driver.switchTo().window(windowslist.get(1));
		//Selecting the Size = 180 ML
		WebElement size = driver.findElement(By.xpath("//select[@title=\"SIZE\"]"));
		Select sizes = new Select(size);
		sizes.selectByIndex(2);
		
		//Printing MRP
		String mrp = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		System.out.println("MRP: "+mrp);
		
		//Clicking "ADD to BAG
		driver.findElement(By.xpath("//span[contains(text(),'Add to Bag')]")).click();
		
		//Clicking the Shopping Bag
		driver.findElement(By.xpath("//button[@class=\"css-aesrxy\"]")).click();
		
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		//Printing the Grand Total Amount
		String grandTotal = driver.findElement(By.xpath("(//div[@data-test-id=\"footer\"]//parent::span)[1]")).getText();
		System.out.println("Grand Total: "+grandTotal);
		
		//Clicking "Proceed" & Sign In as Guest
		driver.findElement(By.xpath("//span[contains(text(),'Proceed')]")).click();
		
		//Check Out as Guest
		driver.findElement(By.xpath("//button[contains(text(),'Continue as guest')]")).click();
		//Address
		//driver.findElement(By.xpath("//p[contains(text(),'Add New Address')]")).click();
		//Checking Grand Total
		String finalGrandTotal = driver.findElement(By.xpath("//p[@class=\"css-1e59vjt eka6zu20\"]")).getText();
		System.out.println("Final Grand Total: "+finalGrandTotal);
		if(grandTotal.equals(finalGrandTotal)) {
			System.out.println("Both Grand Totals are Same..");
		}
		
		
	}

}
