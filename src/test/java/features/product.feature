Feature: As Api user I can post and get product
    Scenario: as Api User I can Post Product
        Given I set base url "/products"
        And I set product name "MacBookPro33" and price "4000"
        When I post product
        Then Post product response should be "200"

    Scenario: as Api User I can Post Product with error
        Given I set base url "/products"
        And I set product name "MacBookPro33" and price "4000"
        When I post product
        Then Post product response should be "204"

