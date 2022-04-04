Feature: As a user I can open Schedule designer canvas and select study, see the default nodes
		@smoke
    Scenario: Check Canvas is opened correctly
        Given Launch Chrome Browser
        When Open Schedule designer 
        Then Verify the title is present as Schedule Designer
        And Study picker is opened
        And Close Browser
        
       
    @smoke  
    Scenario: Check User can select a Study  
    		Given Launch Chrome Browser
        When Open Schedule designer  	
        And Search for a Study
        And Select the Study 
        Then Selected study is displayed       
        And Close Browser
        
        
   Scenario: Check User can see the Default nodes
   			Given Launch Chrome Browser
        When Open Schedule designer  	
        And Search for a Study
        And Select the Study       
        Then Selected study is displayed
        And One node is displayed as "Start"       
        And One node is displayed as "End"
        And One node is displayed as "Anytime"
         And One node is displayed as "Continue"
        And Close Browser
