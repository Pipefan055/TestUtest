package tests;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class TestUtest {
	
	//VARIABLES
			private WebDriver driver;
			private Map<String, Object> vars;
			  JavascriptExecutor js;
			private static final String TIPO_DRIVER = "webdriver.chrome.driver";
			private static final String PATH_DRIVER = "./src/test/resources/webDriver/chromedriver.exe";
		
		  @BeforeClass
			public static void setUpBeforeClass() 
			{
				System.out.println("INICIO TESTS");
				System.setProperty(TIPO_DRIVER, PATH_DRIVER);	
			}
		  @Before
			public void setUp() 
			{
				driver = new ChromeDriver();
				js = (JavascriptExecutor) driver;

			}
		  @After
		  public void tearDown() {
		    driver.quit();
		  }
		  @Test
		  public void testsearchpage() {
		    driver.get("https://utest.com/");
		    driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
		    driver.manage().window().setSize(new Dimension(1382, 736));
		    //driver.findElement(By.linkText("Join Today")).click();
		    driver.findElement(By.cssSelector(".unauthenticated-nav-bar__sign-up")).click();
		    js.executeScript("window.scrollTo(0,0)");
		    driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
		    driver.findElement(By.name("firstName")).click();
		    driver.findElement(By.name("firstName")).sendKeys("Andres");
		    driver.findElement(By.name("lastName")).click();
		    driver.findElement(By.name("lastName")).sendKeys("Quecan");
		    driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).sendKeys("andresfq.115@gmail.com");
		    driver.findElement(By.name("birthMonth")).click();
		    {
		      WebElement dropdown = driver.findElement(By.id("birthMonth"));
		      dropdown.findElement(By.xpath("//option[. = 'February']")).click();
		    }
		    driver.findElement(By.id("birthDay")).click();
		    {
		      WebElement dropdown = driver.findElement(By.id("birthDay"));
		      dropdown.findElement(By.xpath("//option[. = '8']")).click();
		    }
		    driver.findElement(By.id("birthYear")).click();
		    {
		      WebElement dropdown = driver.findElement(By.id("birthYear"));
		      dropdown.findElement(By.xpath("//option[. = '2001']")).click();
		    }
		    driver.findElement(By.cssSelector("#languages > div:nth-child(1)")).click();
		    driver.findElement(By.cssSelector("#languages > div:nth-child(1)")).click();
		    driver.findElement(By.cssSelector("#languages > div:nth-child(1)")).click();
		    {
		      WebElement element = driver.findElement(By.cssSelector("#languages > div:nth-child(1)"));
		      Actions builder = new Actions(driver);
		      builder.doubleClick(element).perform();
		    }
		    driver.findElement(By.cssSelector(".btn-blue")).click();

		    driver.findElement(By.name("city")).click();
		    driver.findElement(By.name("city")).sendKeys("Bog");
		    driver.findElement(By.name("city")).click();
		    driver.findElement(By.name("city")).sendKeys("otá");
		    {
		    	WebElement dropdown = driver.findElement(By.name("city"));
			    dropdown.findElement(By.xpath("//option[. = 'Bogotá Bogota, Colombia']")).click();
		    }
		    driver.findElement(By.name("zip")).click();
		    driver.findElement(By.name("zip")).sendKeys("111071");
		    
		    driver.findElement(By.cssSelector(".btn-blue")).click();
		    
		    driver.findElement(By.cssSelector(".ui-select-search")).click();
		    driver.findElement(By.cssSelector(".ui-select-search")).sendKeys("Windows");
		  }
}

