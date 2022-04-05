package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class Home {
	
	private WebDriver driver;
	
	public final String homePageTitle= "Schedule Designer";
	public final String studyName = "uTestSponsor QA_UB_SD";
	
	public final String toolboxOptions[] = {"Event Instance", "Event Template"
			, "Script", "Branch", "Note", "Header"};
	
	
	@FindBy(how= How.XPATH, using = "//mat-dialog-container[@id='mat-dialog-0']//h4")
	WebElement studypicker_locator;
	
	@FindBy(how =How.XPATH, using = "//input[@placeholder='Search']")
	WebElement search_locator;
	
	@FindBy(how = How.XPATH, using = "//div[@class='selection-list']")
	WebElement select_study_locator;
	
	@FindBy(how = How.XPATH, using = "//button/span[text()='Select']")
	WebElement btn_select_study_locator;
	
	@FindBy(how= How.XPATH, using ="//button[@class='btn btn-primary btn-selector']")
	WebElement study_selector_container_locator;
	
	@FindBy(how = How.XPATH, using ="//div[@class='parent-node']//p")
	List<WebElement> parent_nodes;
	
	@FindBy(how = How.XPATH, using ="//div[@class='slider round']")
	WebElement slider_round;
	
	@FindBy(how = How.XPATH, using ="//div[@class='slider round']/span[text()='Fixed']")
	WebElement slider_round_fixed_mode;
	
	@FindBy(how = How.XPATH, using ="//div[@data-node='note']")
	WebElement note;
	
	@FindBy(how = How.XPATH, using ="//div[@data-node='header']")
	WebElement header;
	@FindBy(how = How.XPATH, using ="//div[@data-node='event']")
	WebElement event_instance;
	
	@FindBy(how = How.XPATH, using ="//div[@data-node='eventTemplate']")
	WebElement event_template;
	
	@FindBy(how = How.XPATH, using ="//div[@data-node='branch']")
	WebElement branch;
	
	@FindBy(how = How.XPATH, using ="//div[@data-node='script']")
	WebElement script;
	
	
	
	

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean is_studypicker_present() throws InterruptedException {
		Utility.waitToLoad();
		Utility.waitForTheElementToBeVisible(btn_select_study_locator,this.driver);
		return studypicker_locator.isDisplayed();
	}
	
	public String getPageTitle() {
		return this.driver.getTitle();
	}
	
	public void searchStudy() throws InterruptedException{	
		Utility.waitToLoad();
		Utility.waitForServerToSave();
		Utility.waitForTheElementToBeVisible(search_locator, this.driver);
		search_locator.clear();
		search_locator.sendKeys(studyName);
		
	}
	
	public void selectStudy() throws InterruptedException {
		Utility.waitForTheElementToBeVisible(select_study_locator, this.driver);
		select_study_locator.click();
		Utility.waitForTheElementToBeVisible(btn_select_study_locator, this.driver);
		btn_select_study_locator.click();
		Utility.waitForServerToSave();
	
	}
	
	public String getSelectedStudy(WebDriver driver) {
		Utility.waitForTheElementToBeVisible(study_selector_container_locator, driver);
		return study_selector_container_locator.getText().toString().trim();
	}
	
	

//	public void waitForAnElement() {
//		Utility.waitForAnElement(studypicker_locator, this.driver);
//		
//	}

	public boolean parentNodeIsplayed(String string) {
		for (int i =0; i < parent_nodes.size(); i++) {
			if(parent_nodes.get(i).getText().toString().trim().equalsIgnoreCase(string)) {
				return parent_nodes.get(i).isDisplayed();
			}
		}
		return false;
	}
	
	public void takeMetoTheEditMode() throws InterruptedException {
		Utility.waitForTheElementToBeVisible(slider_round, driver);
		if(slider_round_fixed_mode.getText().toString().equalsIgnoreCase("Fixed")) {
			slider_round.click();
		}
		
		Utility.waitForServerToSave();
		Utility.waitToLoad();
	}

	public boolean isToolboxOptionIsDisplayed(String string) {
		if(string.equalsIgnoreCase(toolboxOptions[0]))
			return event_instance.isDisplayed();
		else if(string.equalsIgnoreCase(toolboxOptions[1]))
			return event_template.isDisplayed();
		else if (string.equalsIgnoreCase(toolboxOptions[2]))
			return script.isDisplayed();
		else if(string.equalsIgnoreCase(toolboxOptions[3]))
			return branch.isDisplayed();
		else if (string.equalsIgnoreCase(toolboxOptions[4]))
			return note.isDisplayed();
		else
			return header.isDisplayed();
	}
	

}
