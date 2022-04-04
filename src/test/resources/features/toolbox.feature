Feature: As a study manager, in canvas from the toolbar section I can add node to the canvas
	@toolbox
	Scenario Outline: Check the node is displayed in the toolbox correctly
				Given Launch Chrome Browser
        When Open Schedule designer  	
        And Search for a Study
        And Select the Study 
        And Canvas is in Edit Mode
        Then Selected study is displayed
        And "<NodeName>" node is displayed at Toolbox
             
        And Close Browser
 
 Examples: Test data for nodes
 	|NodeName|
 	|Event Instance|
 	|Event Template|
 	|Script|
 	|Branch|
 	|Note|
 	|Header|
 	
 