


Feature: Dobby LogOut

		As 			an user
		I want 		to log out
		so that		Dobbys control-pannel is logged

		
  Scenario Outline: Dobby LogOut
  
		Given 		I wait for the "MainActivity" screen to appear
			And	 	I press "buttonLogin"
			And		I enter "<User>" into input field number 1
			And 		I press the enter button
			And 		I enter "<Password>" into input field number 2
			And 		I press the enter button
			And		I press "loginConfirm"
			And 		I should see "Successfully logged in"
			
		When 		I press "toolbar" 
			And 		I press "Logout"	
			
		Then 		I should see "Successfully logged out"

	Examples:
		| User  		|   Password    |
		| Dobby 		|   123         |