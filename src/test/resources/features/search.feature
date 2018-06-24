Feature: Google sign in


  Background:
  User navigates to Facebook Given
    Given I am on home page
    And I click on signIn button


  Scenario: google invalid sign in
    When I enter username as "testmail"
    And I enter password as "test"
    Then Page should show invalid login




#  Scenario: google sign up
#    When I click create account button
#    Then Page should redirect to signup



#  Scenario outline example

#  Scenario Outline: google invalid sign in
#    When I enter username as "<username>"
#    And I enter password as "<password>"
#    Then Page should show invalid login
#    Examples:
#      | username  | password  |
#      | testmail | password1 |
#      | testmail2 | password2 |






#Data tables example

#  Scenario: google sign up
#    When I click create account button
#    And  I enter incorrect form data
#      | Fields                 | Values              |
#      | First Name             | Tom                 |
#      | Last Name              | Kenny               |
#      | Email Address          | testmai1            |
#      | Password               | test                |
#    Then A signup error should be shown