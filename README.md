<img src="https://www.ssttek.com/img/logo/dark_logo.svg"/>

# SSTTEK Testing Engineers Assessment
## ebay-test-case

Creation of test cases for ebay using cucumber

```cucumber
 Scenario: UI001.AddSuccessfulCart
    Given Hover "Home & Garden" category and open "Home Décor" subcategory
    And Check "Home Décor" subcategory name
    When Add to 3 cart
    And Open cart
    And Check 3 item in cart
    Then Remove first product
```

```cucumber
 Given Open login page
    When "keminssster@gmail.com" and "kaan0604" are entered.
    And Clear watch list
    And Hover "Home & Garden" category and open "Home Décor" subcategory
    And Check "Home Décor" subcategory name
    And Add to 3 watch list
    Then Check 3 item in watch list
```

## Run with Jenkins

Execute Shell 
mvn test -Dtest=TestRunner -Dbrowser=chrome

-Dtest: runner file in project

-Dbrowser: utils/Driver in project
