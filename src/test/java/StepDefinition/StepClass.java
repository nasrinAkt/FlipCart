package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepClass {
	WebDriver driver;
	
	@Given("^Open flipcart application$")
	public void open_flipcart_application() throws Throwable {
	 
	System.setProperty("Webdriver.chrome.driver", "C:\\chrome driver\\chrome-win64\\chrome.exe");	
	ChromeOptions run = new ChromeOptions();
	run.addArguments("--remote-allow-origins=*");
	
	driver = new ChromeDriver();
	
	driver.get("https://www.flipkart.com/");
	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();
	WebElement close = driver.findElement(By.xpath("/html/body/div[3]/div/span"));
	close.click();
	Thread.sleep(1000);
	
	}

	@Then("^mouse over on fashion$")
	public void mouse_over_on_fashion() throws Throwable {
	   Actions ac = new Actions(driver);
	   ac.moveToElement(driver.findElement(By.xpath("//div[@aria-label='Fashion']//div//span[@class='_1XjE3T']"))).build().perform();
	   Thread.sleep(2000);
	}

	@Then("^select women ethnic from dropdown$")
	public void select_women_ethnic_from_dropdown() throws Throwable {
	   WebElement run = driver.findElement(By.linkText("Women Ethnic"));
	   run.click();
	   
	  boolean v = driver.findElement(By.xpath("//h1[text()='Women Ethnic Wear']")).isDisplayed();
	  Assert.assertTrue(v);
	   Thread.sleep(2000);
	   driver.close();
	   
	}

	


}
