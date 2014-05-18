Feature: Kata Potter
  In order to get as big a discount as possible
  As a reader
  I want to calculate the lowest price of different series of Potter books in the basket.
  One copy of any of the five books costs 8 EUR. If, however, you buy two different books from
  the series, you get a 5% discount on those two books. If you buy 3 different books, you get a 10%
  discount. With 4 different books, you get a 20% discount. If you go the whole hog, and buy all 5,
  you get a huge 25% discount.
  The unit of price is cent.

  Scenario Outline: potter tests
    Given I clear my shopping basket
    And I buy <Harry Potter and the Philosopher's Stone> copies of 1st book
    And I buy <Harry Potter and the Chamber of Secrets> copies of 2nd book
    And I buy <Harry Potter and the Prisoner of Azkaban> copies of 3rd book
    And I buy <Harry Potter and the Goblet of Fire> copies of 4th book
    And I buy <Harry Potter and the Order of Phoenix> copies of 5th book
    When I calculate the price
    Then I should get the lowest price <lowest price>

  Examples: test basics
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    0                     |                    0                    |                      0                   |                  0                  |                   0                   |       0      |
    |                    1                     |                    0                    |                      0                   |                  0                  |                   0                   |       800    |
    |                    0                     |                    1                    |                      0                   |                  0                  |                   0                   |       800    |
    |                    0                     |                    0                    |                      1                   |                  0                  |                   0                   |       800    |
    |                    0                     |                    0                    |                      0                   |                  1                  |                   0                   |       800    |
    |                    0                     |                    0                    |                      0                   |                  0                  |                   1                   |       800    |
    |                    2                     |                    0                    |                      0                   |                  0                  |                   0                   |       1600   |
    |                    0                     |                    3                    |                      0                   |                  0                  |                   0                   |       2400   |

  Examples: test simple discounts
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    1                     |                    1                    |                      0                   |                  0                  |                   0                   |       1520   |
    |                    1                     |                    0                    |                      1                   |                  0                  |                   1                   |       2160   |
    |                    1                     |                    1                    |                      1                   |                  0                  |                   1                   |       2560   |
    |                    1                     |                    1                    |                      1                   |                  1                  |                   1                   |       3000   |

  Examples: test several discounts
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    2                     |                    1                    |                      0                   |                  0                  |                   0                   |       2320   |
    |                    2                     |                    2                    |                      0                   |                  0                  |                   0                   |       3040   |
    |                    2                     |                    1                    |                      2                   |                  1                  |                   0                   |       4080   |
    |                    1                     |                    2                    |                      1                   |                  1                  |                   1                   |       3800   |

  Examples: test edge cases
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    2                     |                    2                    |                      2                   |                  1                  |                   1                   |       5120   |
    |                    5                     |                    5                    |                      4                   |                  5                  |                   4                   |       14120   |
