package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.google.common.base.Verify;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home;
import utils.Utility;

public class OpenCanvasSteps {


	private WebDriver driver;
	Home home;
	@Given("Launch Chrome Browser")
	public void launch_chrome_browser() {
		this.driver = BasicSetup.openBrowser();
	}
	@When("Open Schedule designer")
	public void open_schedule_designer() throws InterruptedException {
		this.driver.get(DataProvider.url);
		Utility.waitToLoad();
		
	}

	@Then("Verify the title is present as Schedule Designer")
	public void verifyThePageTitle() {
		home = new Home(this.driver);
		Verify.verify(home.getPageTitle().equalsIgnoreCase(home.homePageTitle));

	}

	@And("Study picker is opened")
	public void study_picker_is_opened() throws InterruptedException {
		Verify.verify(home.is_studypicker_present());
		
	}

	@When("Search for a Study")
	public void search_for_a_study() throws InterruptedException {
		home = new Home(BasicSetup.getDriver());
		home.searchStudy();
	}

	@And("Select the Study")
	public void select_the_study() throws InterruptedException {
		home.selectStudy();
		Utility.waitToLoad();
	}

	@And("Canvas is in Edit Mode")
	public void canvas_is_in_edit_mode() throws InterruptedException {
		home = new Home(BasicSetup.getDriver());
		home.takeMetoTheEditMode();
	}
	@Then("Selected study is displayed")
	public void selected_study_is_displayed() {
	
		Verify.verify(home.getSelectedStudy(BasicSetup.getDriver()).equalsIgnoreCase(home.studyName));
	}
	
	@And("One node is displayed as {string}")
	public void one_node_is_displayed_as(String string) {
		home = new Home(this.driver);
		Verify.verify(home.parentNodeIsplayed(string));
	}
	
	

	@Then("{string} node is displayed at Toolbox")
	public void node_is_displayed_at_toolbox(String string) {
		home = new Home(this.driver);
		Verify.verify(home.isToolboxOptionIsDisplayed(string));
	}
	@And("Close Browser")
	public void close_browser() {
		BasicSetup.closeBrowser(BasicSetup.getDriver());
	}
	

}
