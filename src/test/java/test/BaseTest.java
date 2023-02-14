package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseClass;
import mainjava.DashBoardPage;
import mainjava.LoginPage;
import mainjava.PIMPage;

public class BaseTest extends BaseClass{

	@BeforeClass
	public void initBrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void  pageObjects() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		pimpage = new PIMPage(driver);
	}
	
	@AfterClass
	public void tearDownEnvironment() {
		driver.quit();
	}
}
