import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleReferenceExceptionHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\driver\\chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.linkText("Shop")).click();
		driver.findElement(By.linkText("Home")).click();
		//Thread.sleep(5000);
		WebElement nameField = driver.findElement(By.name("name"));
		nameField.sendKeys("Hello");
		
		WebElement nameCSS = driver.findElement(By.cssSelector("input:nth-child(2)"));
		nameCSS.sendKeys("Aadhinath");
		
	}

}
