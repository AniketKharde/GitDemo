package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class CommonTest extends BaseTest{

	@BeforeClass
	public void login() {
		loginpage.setUsername("Admin");
		loginpage.setPassword("admin123");
		loginpage.clickLoginButton();
		String verifydashTitle = dashboardpage.getDashBoardPageTitle();
		Assert.assertEquals(verifydashTitle, "Dashboard");
  }
	
}
