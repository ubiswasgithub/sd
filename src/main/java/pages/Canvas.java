package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import utils.Utility;

public class Canvas{
	
	
	private static String projectdir = System.getProperty("user.dir");
	private static String path_to_images = projectdir + "/src/test/resources/images/";
	
	@FindBy(how = How.XPATH, using = "//div[@class='drawflow']")
	WebElement canvas_drawflow;
	
	
	
	@FindBy(how = How.XPATH, using ="//div[@class='parent-node']/p[text()='Anytime']")
	WebElement anytime;
	
	@FindBy(how = How.XPATH, using = "//div[@class='diagram-card note']")
	WebElement note_node;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='diagram-card note']//button/img[@alt='Edit']")
	WebElement note_node_edit;
	
	@FindBy(how = How.XPATH, using = "//div[@class='diagram-card note']//button/img[@alt='Delete']")
	WebElement note_node_delete;
	
	@FindBy(how = How.XPATH, using ="//div[@class='mat-dialog-content']//textarea[@placeholder='Note...']")
	WebElement note_placeholder;
	
	@FindBy(how = How.XPATH, using = "//div[@class='mat-dialog-content']//button/span[text()='Yes']")
	WebElement note_delete_confirmation_yes;
	
	@FindBy(how = How.XPATH, using ="//div[@class='mat-dialog-content']//button/span[text()='Save']")
	WebElement note_save_btn;
	
	//header		
	
	@FindBy(how = How.XPATH, using = "//div[@class='diagram-card header']")
	WebElement header_node;
	
	@FindBy(how = How.XPATH, using ="//div[@class='mat-dialog-content']//input[@placeholder='Header...']")
	WebElement header_placeholder;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='mat-dialog-content']//button/span[text()='Yes']")
	WebElement header_delete_confirmation_yes;
	
	@FindBy(how = How.XPATH, using ="//div[@class='mat-dialog-content']//button/span[text()='Save']")
	WebElement header_save_btn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='diagram-card header']//button/img[@alt='Edit']")
	WebElement header_node_edit;
	
	private WebDriver driver;

	public Canvas(WebDriver driver) {
		
		this.driver = driver;	
		PageFactory.initElements(driver, this);;
	}
	
	
	public void dragAndDropTheNoteNode(String src, String target) {
		
		Utility.dragAndDropBySikuli(src, target, path_to_images);
		
	}


	public boolean IsNoteNodeIsDisplayed() {
		try {
			return note_node.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	
	}
	
	public boolean IsHeaderNodeIsDisplayed() {
		try {
			return header_node.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	
	}


	public boolean getDefaultNodeTitle(String nodename, String updatedtxt) {
		// TODO Auto-generated method stub
		if(nodename.equalsIgnoreCase("Note"))
			return note_node.getText().toString().trim().equalsIgnoreCase(updatedtxt);
		else if(nodename.equalsIgnoreCase("Header"))
			return header_node.getText().toString().trim().equalsIgnoreCase(updatedtxt);
		else if(nodename.equalsIgnoreCase("Event"))
			return false;
		else if(nodename.equalsIgnoreCase("Event Template"))
			return true;
		else if(nodename.equalsIgnoreCase("Script"))
			return true;
		else if(nodename.equalsIgnoreCase("Branch"))
			return true;
		return false;
		
	}


	public void updateNoteNodeTo(String string) {
		if(note_node.getText().toString().trim().equalsIgnoreCase("Note")) {
			
			note_node_edit.click();
			note_placeholder.clear();
			note_placeholder.sendKeys(string);
			
			note_save_btn.click();
			
		}
		
	}


	public void deleteNoteNodeAs(String string) {
		// TODO Auto-generated method stub
		
		if(note_node.getText().toString().trim().equalsIgnoreCase(string)) {
			note_node_delete.click();
			note_delete_confirmation_yes.click();
		}
		
	}


	public void updateHeaderNodeTo(String string) {
		if (header_node.getText().toString().trim().equalsIgnoreCase("Header")) {

			header_node_edit.click();
			header_placeholder.clear();
			header_placeholder.sendKeys(string);

			note_save_btn.click();

		}
		
	}
	
	

}
