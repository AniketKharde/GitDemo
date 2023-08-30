package test;

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
	public void verifyEmpSearchEmpName() {
		pimpage.setEmployeeName("Cassidy");
		pimpage.clickSearchButton();
        String verifyEmpName = pimpage.getEmpListFromSearchResults("Cassidy");
		Assert.assertEquals(verifyEmpName, "Cassidy");
	}
	
	
	
}
