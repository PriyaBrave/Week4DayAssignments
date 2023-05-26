package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChittorgarhAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.getWindowHandle();
		//Click on "Stock Market"
		driver.findElement(By.xpath("//a[@title=\"Stock Market\"]")).click();
		//Click on "NSE Bulk Deals
		driver.findElement(By.xpath("(//a[contains(text(),'Bulk Deals')])[1]")).click();
		
		//Get all the Security Names
		WebElement bulkTable = driver.findElement(By.xpath("(//div[@class=\"table-responsive\"]//table)[1]"));
		List<WebElement> brows = bulkTable.findElements(By.tagName("tr"));
		List<WebElement> bcols = bulkTable.findElements(By.tagName("td"));
		System.out.println("Rows: "+brows.size()+" Column Size: "+bcols.size());
		
		List<String> securityList = new ArrayList<String>(); 
		
		for (int i = 1; i < brows.size(); i++) {
				//Thread.sleep(1000);
				String securityNames = driver.findElement(By.xpath("(//table)[2]/tbody/tr["+ i +"]/td[1]/a")).getText();
				System.out.println(i+"*****"+securityNames);
				securityList.add(securityNames);
		} 
		Set<String> securitySet = new HashSet<String>(securityList);
		
		//Checking for Duplicate Security Names
		System.out.println("Duplicates: ");
		
		if(securityList.size()!=securitySet.size()) {
			System.out.println("Security names have duplicates");
		}
		
		Set<String> duplicateSecurityNames = new LinkedHashSet<String>();
		for (String string : securityList) {
			if(!securitySet.add(string)) {
				duplicateSecurityNames.add(string);
			}
		}
		
		System.out.println(duplicateSecurityNames);
	}
}
