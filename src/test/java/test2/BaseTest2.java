package test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava2.BaseClass2;
import mainjava2.DashBoardPage2;
import mainjava2.LoginPage2;
import mainjava2.PIMPage2;


public class BaseTest2 extends BaseClass2{

	@BeforeSuite
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
		loginpage = new LoginPage2(driver);
		dashboardpage = new DashBoardPage2(driver);
		pimpage = new PIMPage2(driver);
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
