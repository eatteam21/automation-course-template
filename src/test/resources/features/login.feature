Feature: Login functionality

  Scenario Outline: Login Successfully
    Given the user is on the homepage
    When user enters email "<username>"
    And user enters password
    Then verify login successfully

    Examples:
      | username             |
      | trongtuyen@gmail.com |
      | testtest@gmail.com   |

#   @Ignore
#   Scenario: Login Failed
#     Given the user is on the homepage
#     When user enters email
#     And user enters password
#     Then verify login successfully
