package mainjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashBoardPage extends BaseClass{
	
	// All the locators of page //
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement txtDashboard;
	
	@FindBy(css = ".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon")
	WebElement logoutDropDownClick;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutButtonClick;
	
	
	
	
	// Initialization of locators/variables //
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	// Methods required to perform test steps //
  public String getDashBoardPageTitle() {
	return txtDashboard.getText();	  
  }
  
  public void clickLogoutButton() {
	  logoutDropDownClick.click();
	  logoutButtonClick.click();
  }
}
