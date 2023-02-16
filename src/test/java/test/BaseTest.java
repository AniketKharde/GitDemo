package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseClass;
import mainjava.DashBoardPage;
import mainjava.LoginPage;
import mainjava.PIMPage;

public class BaseTest extends BaseClass{

	
	public static WebDriver browserName(String browser) {
        if(browser.equals("edge")) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}
	@BeforeSuite
	public void initBrowser(){
		browserName("edge");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
/*	@AfterSuite
	public void initBrowser() throws IOException {
		//Properties class 
		Properties prop = new Properties();
		//FileInputStream fileDestination = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Maven\\MavenFramework\\src\\test\\java\\GlobalData.properties");
		FileInputStream fileDestination = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\GlobalData.properties");
		prop.load(fileDestination);
	    String browserName = prop.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("edge")) {
	    	WebDriverManager.edgedriver().setup();
	    	driver = new EdgeDriver();
	    }
	    else if(browserName.equalsIgnoreCase("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	    }
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
	}
	*/
	
	
	@BeforeClass
	public void  pageObjects() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		pimpage = new PIMPage(driver);
	}
	
	@AfterSuite
	public void tearDownEnvironment() {
		driver.quit();
	}
	
	@AfterClass
	public void logOut() {
		dashboardpage.clickLogoutButton();
	}
}
