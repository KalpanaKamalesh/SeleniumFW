package base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
public int iBrowserType=1;
public String sURL="https://uibank.uipath.com/";
@BeforeClass
public void browserInvoke() {
	switch(iBrowserType) {
	case 1:
			System.out.println("User selection is : "+iBrowserType+",So invoking Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
	case 2:
		System.out.println("User selection is : "+iBrowserType+",So invoking Firefox Browser");
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		break;		
	case 3:
		System.out.println("User selection is : "+iBrowserType+",So invoking Edge Browser");
		WebDriverManager.edgedriver().setup();
		
		driver= new EdgeDriver();
		break;
	case 4:
		System.out.println("User selection is : "+iBrowserType+",So invoking IE Browser");
		WebDriverManager.iedriver().setup();
	
		driver= new InternetExplorerDriver();
		break;
	default:
		System.out.println("User selection is wrong: "+iBrowserType+",So invoking the default Chrome Browser");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		break;
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(sURL);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
}
@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}