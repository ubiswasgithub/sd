package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class Phase {
	
	private WebDriver driver;
	public final String default_phase_name = "Default";
	public final String add_phase_title = "Add Phase";
	
	//phases
	@FindBy(how = How.XPATH, using="//span[text()='Default']")
	WebElement default_phase_locator;
	
	@FindBy(how = How.XPATH, using = "//img[@alt='add']")
	WebElement add_phase_locator;
	
	@FindBy(how = How.XPATH, using = "//app-dialog-frame[@title='Add Phase']")
	WebElement add_phase_modal_title;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='Name']")
	WebElement phase_term_locator;
	
	@FindBy(how = How.XPATH, using = "//span[@class='mat-option-text']")
	List<WebElement> termoption_phase_locator;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='Name']")
	WebElement _phase_locator;
	
	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname='Description']")
	WebElement _desc_locator;
	
	@FindBy(how = How.XPATH, using = "//span[@class='mat-button-wrapper']")
	List<WebElement> _btn_save;
	
	@FindBy(how = How.XPATH, using = "//button//span[text()='Cancel']")
	WebElement _btn_cancel;
	

	@FindBy(how = How.XPATH, using = "//div//span[@class='mr-5 flex-grow-1']")
	List<WebElement> _total_phases;
	
	@FindBy(how = How.XPATH, using ="//div//img[@alt='edit']")
	List<WebElement> option_to_edit_phases;
	
	@FindBy(how = How.XPATH, using ="//div//img[@alt='delete']")
	WebElement option_to_delete_phase;
	
	@FindBy(how = How.XPATH, using ="//div/h4[text()='Confirmation']")
	WebElement confirmation_modal_to_delete_phase;
	
	@FindBy (how = How.XPATH, using = "//div//button//span[text()='Yes']")
	WebElement option_to_confirm_delete_phase;
	
	
	public Phase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	public String getDefaultPhase() {
		//Utility.waitForAnElement(default_phase_locator, this.driver);
		
		default_phase_locator.click();
		return default_phase_locator.getText().toString().trim();
	}


	public void selectOptionToAddPhase() throws InterruptedException {
		Utility.waitForTheElementToBeVisible(add_phase_locator, this.driver);
		add_phase_locator.click();
//		Utility.waitToLoad();
		
		
	}


	public void enterRequiredPhaseData(String string) throws InterruptedException {
		Utility.waitForTheElementToBeVisible(_phase_locator, this.driver);
		_phase_locator.clear();
		_phase_locator.sendKeys(string);
		_desc_locator.clear();
		_desc_locator.sendKeys("Test");
//		Utility.waitToLoad();
		
		
		
	}
	
	public String getAddPhaseTitle() {
		return add_phase_modal_title.getText().toString();
	}


	public void savePhase() throws InterruptedException {
		for (int i= 0; i< _btn_save.size(); i++) {
			if(_btn_save.get(i).getText().toString().trim().equalsIgnoreCase("Save")) {
				_btn_save.get(i).click();
				break;
			}
		}
		
		Utility.waitToLoad();
	}


	public boolean isNewPhaseIsDisplayed(String string) {
		// TODO Auto-generated method stub
		for (int i = 0;i<_total_phases.size(); i++) {
			if (_total_phases.get(i).getText().toString().equalsIgnoreCase(string)) {
				return true;
			}
		}
		
		return false;
	}


	public boolean IsNewPhaseIsSelected(String string) {
		// TODO Auto-generated method stub
		for (int i = 0;i<_total_phases.size(); i++) {
			if (_total_phases.get(i).getText().toString().equalsIgnoreCase(string)) {
				_total_phases.get(i).click();
				return _total_phases.get(i).isEnabled();
			}
		}
		return false;
		
	}
	
	
	public void selectOptionToEdit(String string) {
		// TODO Auto-generated method stub
		for (int i = 0;i<_total_phases.size(); i++) {
			if (_total_phases.get(i).getText().toString().equalsIgnoreCase(string)) {
				option_to_edit_phases.get(i).click();
				
				break;
			}
		}
	
		
	}


	public void updatePhaseName(String string) throws InterruptedException {
		_phase_locator.clear();
		_phase_locator.sendKeys(string);
	
		
	}


	public boolean isPhaseUpdated(String string) {
		// TODO Auto-generated method stub
		for (int i = 0;i<_total_phases.size(); i++) {
			if (_total_phases.get(i).getText().toString().equalsIgnoreCase(string)) {			
				return _total_phases.get(i).isDisplayed();
			}
		}
		return false;
	
		
	}


	public void deletePhase(String string) {
		
		for (int i = 0;i<_total_phases.size(); i++) {
			if (_total_phases.get(i).getText().toString().trim().equalsIgnoreCase(string)) {
				option_to_delete_phase.click();			
				break;
			}
		}
	
		
		
	}
	
	public boolean deletedPhaseNotExists(String string) {
		for (int i = 0;i<_total_phases.size(); i++) {
			if (_total_phases.get(i).getText().toString().trim().equalsIgnoreCase(string)) {			
				return _total_phases.get(i).isDisplayed();
			}
		}
		return false;
	}


	public boolean isConfirmationModalIsDisplayedForDeletingPhase() {
		// TODO Auto-generated method stub
		if (confirmation_modal_to_delete_phase.isDisplayed())
			return true;
		return false;
	}


	public void selectTheOptionToConfirmDeletePhase() {
		// TODO Auto-generated method stub
		option_to_confirm_delete_phase.click();
	}
	
	
	
	

}
