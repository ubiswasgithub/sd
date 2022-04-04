Feature: As a user I can add, edit and delete the Note and Header node in the canvas.
Scenario: Check user can add Note node
 			Given Launch Chrome Browser
      When Open Schedule designer  	
      And Search for a Study
      And Select the Study 
      And Canvas is in Edit Mode
      And Drag and drop the "Note" 
      Then Verify Note node is added to the canvas
      And Default title for the "Note" Node is "Note"
      And Close Browser
      
Scenario: Check user can edit Note node
 			Given Launch Chrome Browser
      When Open Schedule designer  	
      And Search for a Study
      And Select the Study 
      And Canvas is in Edit Mode
      And Edit the Note as "Note_updated"
      Then Verify the "Note" node name is updated to "Note_updated"
      And Close Browser
      
Scenario: Check user can delete Note node
 			Given Launch Chrome Browser
      When Open Schedule designer  	
      And Search for a Study
      And Select the Study 
      And Canvas is in Edit Mode   
      And Delete the Note "Note_updated"
      Then Verify the "Note_updated" is not in the canvas
      And Close Browser
 	
 Scenario: Check user can add Header node
 			Given Launch Chrome Browser
      When Open Schedule designer  	
      And Search for a Study
      And Select the Study 
      And Canvas is in Edit Mode
      And Drag and drop the "Header" 
      Then Verify Header node is added to the canvas
      And Default title for the "Header" Node is "Header"
      And Close Browser
      
 Scenario: Check user can edit Header node
 			Given Launch Chrome Browser
      When Open Schedule designer  	
      And Search for a Study
      And Select the Study 
      And Canvas is in Edit Mode
      And Edit the Header as "Header_updated"
      Then Verify the "Header" node name is updated to "Header_updated"
      And Close Browser
 
 Scenario: Check user can delete Header node
 			Given Launch Chrome Browser
      When Open Schedule designer  	
      And Search for a Study
      And Select the Study 
      And Canvas is in Edit Mode   
      And Delete the Note "Header_updated"
      Then Verify the "Header_updated" is not in the canvas
      And Close Browser