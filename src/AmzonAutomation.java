import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmzonAutomation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\driver\\chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//scroll down method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		System.out.println(driver.findElement(By.linkText("Explore all categories")).isDisplayed());
		
		//Mouse hover to Sign In
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.partialLinkText("Sign in"))).perform();
		
		//Navigate to login page
		driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("123");
		driver.findElement(By.id("signInSubmit")).click();
		
		String ActualMessage = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";
		String ExpectedMessage = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
		System.out.println(ExpectedMessage);
		if(ActualMessage.contentEquals(ExpectedMessage)) {
			System.out.println("Expected Message from Amazon");
		}
		else
			System.out.println("Messages are incorrect");
		
		
		
		
		
		//Close the browser
		driver.close();
	}

}
