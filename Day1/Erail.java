package Week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MAS");
		Thread.sleep(500);
		fromStation.sendKeys(Keys.ENTER);
		
		WebElement ToStation = driver.findElement(By.id("txtStationTo"));
		ToStation.clear();
		ToStation.sendKeys("MAS");
		Thread.sleep(500);
		ToStation.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainsList = driver.findElements(By.xpath("//div[@id='divTrainList']//tbody//td[2]"));
		List<String> trainNames = new ArrayList<String>();
		for (WebElement train : trainsList) {
			trainNames.add(train.getText());
			
		}
		Set <String> trains = new HashSet<String>(trainNames);
		if(trainNames.size() == trains.size()){
			System.out.println("No Duplicates");
		} else {
				System.out.println("Duplicates present");	
	}

}
}
