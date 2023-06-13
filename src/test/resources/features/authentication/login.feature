Feature: Login

  Rule: Customers needs to provide valid credentials to access the product catalog
      Example: Colin logs in with valid credentials
        Given Colin is on the login page
        When Colin logs in with valid credentials
        Then He should be presented with the product catalog