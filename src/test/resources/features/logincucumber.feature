# @Ignore
Feature: Login functionality cucumber

  Scenario Outline: Login case
    Given the user is on the homepage
    When user enters email "<email>"
    And user enters password "<pass>"
    And user submit login
    Then verify login successfully "<expected>"
    Then verify login erro email <expectedMessageErroEmail>
    Then verify login null mail <expectedMessageNullEmailDisplay>
    Then verify login erro password <expectedMessageErroPassDisplay>
    Then verify login null pass <expectedMessageNullPassDisplay>
    Then verify login null email and pass <expectedMessageNullEmailAndPassDisplay>

    Examples: Page titles
      | email                          | pass            | expected | expectedMessageErroEmail | expectedMessageNullEmailDisplay | expectedMessageErroPassDisplay | expectedMessageNullPassDisplay | expectedMessageNullEmailAndPassDisplay |
      | trongtuyen451@gmail.com        | Admin@123456    | true     | false                    | false                           | false                          | false                          | false                                  |
      | trongtuyentestfailse@gmail.com | Admin@123456    | false    | true                     | false                           | false                          | false                          | false                                  |
      |                                | Admin@123456    | false    | false                    | true                            | false                          | false                          | false                                  |
      | trongtuyen451@gmail.com        | Adminpassfailse | false    | false                    | false                           | true                           | false                          | false                                  |
      | trongtuyen451@gmail.com        |                 | false    | false                    | false                           | false                          | true                           | false                                  |
      |                                |                 | false    | false                    | false                           | false                          | false                          | true                                   |
