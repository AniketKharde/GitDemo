package mainjava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PIMPage extends BaseClass {

	
	// All the locators of page //
	@FindBy(xpath="//span[text()='PIM']")
	WebElement clickPIMPage;
	
	@FindBy(css="h6")
	WebElement titleOfPIMPage;
	
	@FindBy(xpath="//label[text()='Employee Name']//parent::div//following-sibling::div//input")
	WebElement setEmpName;
	
	@FindBy(css="button[type='submit']")
	WebElement clickSearch;
	
	@FindBy(xpath ="//*[@class='orangehrm-container']")
	WebElement searchRecord;
	
	// Initialization of locators/variables //
	public PIMPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methods required to perform test steps //
	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to click PIM Page
	 */
	public void clickPIMPageLink() {
		clickPIMPage.click();
	}
	
	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to get title of PIM page
	 * @return : String
	 */
	public String getPIMPageTitle() {
		return titleOfPIMPage.getText(); 
	}
	
	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to set Employee name 
	 * @param empName 
	 */
	public void setEmployeeName(String empName) {
		setEmpName.sendKeys(empName);
	}
	
	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to click search button
	 */
	public void clickSearchButton() {
		clickSearch.click();
	}
	
	/**
	 * @Author : Aniket Kharde
	 * @Date : 06-Feb-2023
	 * @Description : This test method used to 
	 * @param empName
	 * @return String
	 */
	public String getEmpListFromSearchResults(String empData) {
	    return searchRecord.findElements(By.xpath("//div[contains(text(),'"+empData+"')]")).get(0).getText();	
	}
	
	
	
	
}
