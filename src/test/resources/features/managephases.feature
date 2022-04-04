Feature: As a user I can see the default phase when open canvas then can add, edit and delete phases
	Scenario: Check Canvas shows default phase when it is launched
			Given Launch Chrome Browser
      When Open Schedule designer  	
      And Search for a Study
      And Select the Study
      Then Default phase is dispayed and selected
      
	Scenario: Check User can Add phase successfully
			Given Schedule designer canvas is opened 
			And Study is selected
			And Canvas is in Edit Mode
			When Select the option to Add phase
			And Enter required phase data as "newphase"
			And Select the option to Save
			Then Verify phase is added as "newphase"
	Scenario: Check User can Edit phase successfully
			Given Phase is selected as "newphase"
			When Select the option to Edit phase for "newphase"
			And Update the data for phase as "newphase_updated"
			And Select the option to Save
			Then Verify phase is updated to "newphase_updated"
	Scenario: Check User can Delete phase successfully
			Given Phase is selected as "newphase_updated"
			When Select the option to delete phase "newphase_updated"
			And Confirmation Modal is displayed
			And Select the option to Confirm the deletion
			Then Verify the phase "newphase_updated" is deleted
			And Close Browser
			
			
	
			