package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();
		// Mouse Hover on MEN
		WebElement menhover = driver.findElement(By.xpath("//a[@data-group='men']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menhover).perform();

		Thread.sleep(1000);
		// Clicking on Jackets
		driver.findElement(By.xpath("//a[contains(text(),'Jacket')]")).click();

		// Finding the total count of item
		String totalJackets = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total no. of Jackets: " + totalJackets);
		String substr = totalJackets.substring(3, 8);
		System.out.println("Substring: "+substr);
		// Validating Sum of Count of Categories is equal
		int sum = 0;
		List<WebElement> cat = driver.findElements(By.className("categories-num"));
		for (int i = 0; i < cat.size(); i++) {
			System.out.println(cat.get(i).getText().replaceAll("\\(", "").replaceAll("\\)", ""));
			String allcat = cat.get(i).getText().replaceAll("\\(", "").replaceAll("\\)", "");
			sum = sum + Integer.parseInt(allcat);
		}
		System.out.println("Adding all the categories count: " + sum);
		String strsum = Integer.toString(sum);
		Thread.sleep(1000);

		if (substr.equals(strsum)) {
			System.out.println("Total No. of Jackets is Same..");
		} else {
			System.out.println("Total No. of Jackets is not Same..");
		}

		
		// Select Check Box "Jacket"
		driver.findElement(By.xpath("//span[contains(text(),'Categories')]//following::ul//li//label")).click();

		driver.findElement(By.xpath("//div[@class=\"brand-more\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search brand\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search brand\"]")).sendKeys("Duke", Keys.ENTER);
		
		Thread.sleep(2000);
		
		WebElement dukeCheckBox = driver.findElement(By.xpath("(//input[@value=\"Duke\"])[1]"));
		actions.moveToElement(dukeCheckBox).perform();
		actions.click(dukeCheckBox).perform();
		
		driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite FilterDirectory-close sprites-remove\"]")).click();
		
		Thread.sleep(2000);
		List<WebElement> allDukes = driver.findElements(By.xpath("//h3[@class=\"product-brand\"]"));
		String checkDuke = driver.findElement(By.xpath("//h3[contains(text(),'Duke')]")).getText();
		for (int i = 0; i < allDukes.size(); i++) {
			//System.out.println(allDukes.get(i).getText());
			String dukes = allDukes.get(i).getText();
			if (dukes.equals(checkDuke)) {
				System.out.println("Brand is Duke");
			} else {
				System.out.println("Brand is not Duke");
			}
		}
		
		//Sorting By "Better Discount"
		WebElement sortbyhover = driver.findElement(By.xpath("//div[@class=\"sort-sortBy\"]"));
		
		actions.moveToElement(sortbyhover).build().perform();
		actions.click(sortbyhover).perform();
		
		Thread.sleep(2000);
		WebElement betterdisc = driver.findElement(By.xpath("(//ul[@class=\"sort-list\"]//li)[4]"));
		
		actions.click(betterdisc).build().perform();
		
		//Printing the first Price of sorted Better Discount
		WebElement firstDiscountPrice = driver.findElement(By.xpath("(//span[@class=\"product-discountedPrice\"])[1]"));
		System.out.println("First Price of Better Discount: "+firstDiscountPrice.getText());
		
		//Taking Screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/myntra.png");
		FileUtils.copyFile(src, dest);
		
		Thread.sleep(2000);
		//Clicking on "Wish List"
		WebElement wishlist = driver.findElement(By.xpath("//span[contains(text(),'Wishlist')]"));
		actions.moveToElement(wishlist).perform();
		actions.click(wishlist).perform();
		System.out.println(driver.getTitle());
		
		driver.close();	
	}
}
