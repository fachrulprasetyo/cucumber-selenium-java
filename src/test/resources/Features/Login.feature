Feature: Login Web Saucedemo

  @Test1
  Scenario Outline: : Login Success
    Given Open website saucedemo
    And Input valid <username> and <password>
    When Click login button
    Then Should success login and redirect to homepage

  Examples:
    | username | password |
    | standard_user | secret_sauce |

  @Test2
  Scenario Outline: : Login Failed
    Given Open website saucedemo
    And Input invalid <username> and <password>
    When Click login button
    Then Failed login and showing error message

    Examples:
      | username | password |
      | standard_user | wrong_pass |

  @Test3
  Scenario Outline: : Login Failed Without Input Credentials
    Given Open website saucedemo
    And Without input <username> and <password>
    When Click login button
    Then Failed login and showing error message Epic sadface: Username is required

    Examples:
      | username | password |
      |  |  |