package steps;

import com.google.common.base.Verify;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Canvas;
import utils.Utility;

public class CanvasSteps {
	
	Canvas canvas;
	
	@When("Drag and drop the {string}")
	public void drag_and_drop_the_note(String string) throws InterruptedException {
		canvas = new Canvas(BasicSetup.getDriver());
		if(string.equalsIgnoreCase("Note"))
			canvas.dragAndDropTheNoteNode("Note.png","Anytime.png");
		else if(string.equalsIgnoreCase("Header"))
			canvas.dragAndDropTheNoteNode("Header.png","Anytime.png");
		else if(string.equalsIgnoreCase("Event Instance"))
			canvas.dragAndDropTheNoteNode("Event_Instance.png","Anytime.png");
		else if( string.equalsIgnoreCase("Event Template"))
			canvas.dragAndDropTheNoteNode("Event_Template.png","Anytime.png");
		else if (string.equalsIgnoreCase("Branch"))
			canvas.dragAndDropTheNoteNode("Branch.png","Anytime.png");
		else if(string.equalsIgnoreCase("Script"))
			canvas.dragAndDropTheNoteNode("Script.png","Anytime.png");
		
		Utility.waitForServerToSave();
	}

	@Then("Verify Note node is added to the canvas")
	public void verify_note_node_is_added_to_the_canvas() throws InterruptedException {		
		canvas = new Canvas(BasicSetup.getDriver());
		Verify.verify(canvas.IsNoteNodeIsDisplayed());
		
	}

	@Then("Default title for the {string} Node is {string}")
	public void default_title_for_the_note_is(String nodename, String string ) {
	  Verify.verify(canvas.getDefaultNodeTitle(string, string));
	}

	@When("Edit the Note as {string}")
	public void edit_the_note_as(String string) throws InterruptedException {
		canvas = new Canvas(BasicSetup.getDriver());
		canvas.updateNoteNodeTo(string);
		Utility.waitToLoad();
		Utility.waitForServerToSave();
	}

	@Then("Verify the {string} node name is updated to {string}")
	public void verify_the_note_node_name_is_updated_to(String nodename, String title) {
		 Verify.verify(canvas.getDefaultNodeTitle(nodename, title));
	}

	@When("Delete the Note {string}")
	public void delete_the_note(String string) throws InterruptedException {
		canvas = new Canvas(BasicSetup.getDriver());
		canvas.deleteNoteNodeAs(string);
		Utility.waitToLoad();
		Utility.waitForServerToSave();
	}

	@Then("Verify the {string} is not in the canvas")
	public void verify_the_is_not_in_the_canvas(String string) {
		Verify.verify(!canvas.IsNoteNodeIsDisplayed());
	}
	
	
	//header
	
	@Then("Verify Header node is added to the canvas")
	public void verify_header_node_is_added_to_the_canvas() throws InterruptedException {		
		canvas = new Canvas(BasicSetup.getDriver());
		Verify.verify(canvas.IsHeaderNodeIsDisplayed());
		
	}
	
	
	@When("Edit the Header as {string}")
	public void edit_the_header_as(String string) throws InterruptedException {
		canvas = new Canvas(BasicSetup.getDriver());
		canvas.updateHeaderNodeTo(string);
		Utility.waitToLoad();
		Utility.waitForServerToSave();
	}


}
