package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();

		Thread.sleep(1000);
		// Searching - one plus 9 pro
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("one plus 10 pro", Keys.ENTER);

		// Getting the Price of First Product
		String priceFirstProduct = driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[1]")).getText();
		System.out.println("Price of First Product: " + priceFirstProduct);

		// Printing the number of customer rating for the first product
		String totalCusRating = driver.findElement(By.xpath("(//span[@class=\"a-size-base s-underline-text\"])[1]"))
				.getText();
		System.out.println("No. of Customer Ratings for the First Product: " + totalCusRating);

		// Mouse Hover on Rating (Stars)
		WebElement rating = driver.findElement(By.xpath("(//span[@data-action='a-popover'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(rating).build().perform();
		action.click(rating).perform();

		Thread.sleep(2000);
		// Getting percentage of star rating
		WebElement ratingTable = driver.findElement(By.xpath("//div[@class='a-row a-spacing-medium']//following::table"));
		List<WebElement> rows = ratingTable.findElements(By.tagName("tr"));
		System.out.println("Row Size: " + rows.size());

		System.out.println("Ratings:");

		List<WebElement> columnsList = null;

		for (WebElement row : rows) {
			System.out.println();
			columnsList = row.findElements(By.tagName("td"));
			for (WebElement column : columnsList) {
				System.out.print(column.getText()+" ");
			}

		}

		// Printing First Text Link of First Image
		driver.findElement(By.xpath("(//div[@class=\"sg-col-inner\"]//parent::a)[7]")).click();
		String firstTextLink = driver.findElement(By.xpath("(//div[@class=\"sg-col-inner\"]//parent::a)[7]")).getText();
		System.out.println("\nFirst Text Link of First Image: " + firstTextLink);

		Set<String> windows = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windows);

		driver.switchTo().window(winList.get(1));
		System.out.println(driver.getTitle());

		// Screenshot of the Product
		File ProductScreenshot = driver.getScreenshotAs(OutputType.FILE);
		File store = new File("./snap/productimage.png");
		FileUtils.copyFile(ProductScreenshot, store);

		// Add to Cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(1000);
		
		// Getting Cart Sub Total
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']")).click();
		String cartSubTotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']")).getText();
		System.out.println(cartSubTotal);
		System.out.println("Cart Sub Total:"+cartSubTotal);
		String CST = cartSubTotal.substring(3, 9);
		System.out.println("CST:"+CST);
		
		if (priceFirstProduct.equals(CST)) {
			System.out.println("Price of the Product and Sub Total are Same..");
		} else {
			System.out.println("Price of the Product and Sub Total are not Same..");
		}

		driver.switchTo().defaultContent();
		driver.getTitle();
	}

}
