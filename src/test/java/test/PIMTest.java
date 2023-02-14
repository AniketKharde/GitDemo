package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMTest extends CommonTest {
	

	@Test(priority=4,groups= {"Smoke","Regression"})
    public void verifyTitleOfPIMPage() {
		pimpage.clickPIMPageLink();
		String verifyPIMPageTitle = pimpage.getPIMPageTitle();
		Assert.assertEquals(verifyPIMPageTitle, "PIM");
	}
	
	@Test(priority=5,groups= {"Smoke","Regression"})
	public void verifyEmpSearchEmpName() throws InterruptedException {
		pimpage.setEmployeeName("lan");
		pimpage.clickSearchButton();
        String verifyEmpName = pimpage.getEmpListFromSearchResults("lan");
		Assert.assertEquals(verifyEmpName, "lan");
	}
	
	@Test
	public void m2() {
		System.out.println("M2");
	}
	
	
	public void m3() {
		System.out.println("M3");
	}
	
}
