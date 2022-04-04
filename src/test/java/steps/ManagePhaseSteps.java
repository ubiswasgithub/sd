package steps;

import org.junit.Assert;

import com.google.common.base.Verify;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home;
import pages.Phase;
import utils.Utility;

public class ManagePhaseSteps {
	
	Phase phase;
	
	@Then("Default phase is dispayed and selected")
	public void default_phase_is_dispayed_and_selected() {
	   phase = new Phase(BasicSetup.getDriver());
	   
	   Verify.verify(phase.getDefaultPhase().equalsIgnoreCase(phase.default_phase_name));
	}

	@Given("Schedule designer canvas is opened")
	public void schedule_designer_canvas_is_opened() {
	   
	}

	@And("Study is selected")
	public void study_is_selected() {
	   
	}


	@When("Select the option to Add phase")
	public void select_the_option_to_add_phase() throws InterruptedException {
		phase = new Phase(BasicSetup.getDriver());
		phase.selectOptionToAddPhase();
		//Assert.assertTrue(phase.getAddPhaseTitle().equalsIgnoreCase(phase.add_phase_title));
	}

	@And("Enter required phase data as {string}")
	public void enter_required_phase_data_as(String string) throws InterruptedException {
		phase = new Phase(BasicSetup.getDriver());
		phase.enterRequiredPhaseData(string);
	}

	@And("Select the option to Save")
	public void select_the_option_to_save() throws InterruptedException {
		//phase = new Phase(BasicSetup.getDriver());
		phase.savePhase();		
		Utility.waitForServerToSave();
		
		
	}

	@Then("Verify phase is added as {string}")
	public void verify_phase_is_added(String string) throws InterruptedException {
		phase = new Phase(BasicSetup.getDriver()); 
		
		Verify.verify(phase.isNewPhaseIsDisplayed(string));
	}
	
	@Given("Phase is selected as {string}")
	public void phase_is_selected_as(String string) {
		phase = new Phase(BasicSetup.getDriver());
		Verify.verify(phase.IsNewPhaseIsSelected(string));
		
	}
	
	@When("Select the option to Edit phase for {string}")
	public void select_the_option_to_edit_phase(String string) throws InterruptedException {
		phase.selectOptionToEdit(string);
		Utility.waitToLoad();
	}
	
	@And("Update the data for phase as {string}")
	public void update_the_data_for_phase(String string) throws InterruptedException {
		phase.updatePhaseName(string);		
		Utility.waitForServerToSave();
	
	}

	@Then("Verify phase is updated to {string}")
	public void verify_phase_is_updated(String string) {
		phase = new Phase(BasicSetup.getDriver());
		Verify.verify(phase.isPhaseUpdated(string));
	}
	
	
	@When("Select the option to delete phase {string}")
	public void select_the_option_to_delete_phase(String string) throws InterruptedException {	
	   phase.deletePhase(string);
	   Utility.waitToLoad();
	   
	}
	
	@And("Confirmation Modal is displayed")
	public void Confirmation_Modal_is_displayed() throws InterruptedException{
		Utility.waitToLoad();
		phase = new Phase(BasicSetup.getDriver());
		Verify.verify(phase.isConfirmationModalIsDisplayedForDeletingPhase());
	}
	
	@And("Select the option to Confirm the deletion")
	public void Select_the_option_to_Confirm_the_deletion() throws InterruptedException {
		Utility.waitToLoad();
		phase.selectTheOptionToConfirmDeletePhase();
		Utility.waitForServerToSave();
	}

	@Then("Verify the phase {string} is deleted")
	public void verify_selected_phase_is_deleted(String string) {
		Verify.verify(!phase.deletedPhaseNotExists(string));
	}


}
