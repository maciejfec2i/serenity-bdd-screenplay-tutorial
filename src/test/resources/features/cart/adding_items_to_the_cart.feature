Feature: Adding Items to the cart

  Rule: Items added from the catalog page should appear in the cart
    Example: Colin adds some items to his cart
      Given Colin has logged in to the application
      And he is browsing the catalog
      When he adds the following items to the cart:
        | Sauce Labs Backpack     |
        | Sauce Labs Bolt T-Shirt |
      Then then shopping cart count should be correct
      And the items should appear in the cart