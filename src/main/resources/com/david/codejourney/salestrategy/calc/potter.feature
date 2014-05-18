Feature: Kata Potter
 出版社要促销一套哈利波特图书，该套图书共5集，每集单册购买价8元。
 若任意两集各买一本，打95折；若任意三集各买一本，打9折；若任意四集各买一本，打8折；
 若所有这五集都各买一本，打75折。上述优惠之外再购买的单册还是按8元一本计价。
 比如五集各买一本之外再加一本第一集，五本书打75折，这本另加的第一集按8元计价。
 若有人第一集买2本，第二集买2本，第三集买2本，第四集买1本，第五集买1本。
 问打折后最低的优惠价是多少钱？提示，不是51.6元，而是51.2元。

  Scenario Outline: David的Potter测试
    Given 开始我先要初始化我的购物车
    And 我购买 <Harry Potter and the Philosopher's Stone> 本 1st 系列书
    And 我购买 <Harry Potter and the Chamber of Secrets> 本 2nd 系列书
    And 我购买 <Harry Potter and the Prisoner of Azkaban> 本 3rd 系列书
    And 我购买 <Harry Potter and the Goblet of Fire> 本 4th 系列书
    And 我购买 <Harry Potter and the Order of Phoenix> 本 5th 系列书
    When 我计算购物车的总价
    Then 我最少应该付 <lowest price>

  Examples: 最基本的测试
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    0                     |                    0                    |                      0                   |                  0                  |                   0                   |       0      |
    |                    1                     |                    0                    |                      0                   |                  0                  |                   0                   |       800    |
    |                    0                     |                    1                    |                      0                   |                  0                  |                   0                   |       800    |
    |                    0                     |                    0                    |                      1                   |                  0                  |                   0                   |       800    |
    |                    0                     |                    0                    |                      0                   |                  1                  |                   0                   |       800    |
    |                    0                     |                    0                    |                      0                   |                  0                  |                   1                   |       800    |
    |                    2                     |                    0                    |                      0                   |                  0                  |                   0                   |       1600   |
    |                    0                     |                    3                    |                      0                   |                  0                  |                   0                   |       2400   |

  Examples: 简单的打折测试
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    1                     |                    1                    |                      0                   |                  0                  |                   0                   |       1520   |
    |                    1                     |                    0                    |                      1                   |                  0                  |                   1                   |       2160   |
    |                    1                     |                    1                    |                      1                   |                  0                  |                   1                   |       2560   |
    |                    1                     |                    1                    |                      1                   |                  1                  |                   1                   |       3000   |

  Examples: 复合折扣测试
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    2                     |                    1                    |                      0                   |                  0                  |                   0                   |       2320   |
    |                    2                     |                    2                    |                      0                   |                  0                  |                   0                   |       3040   |
    |                    2                     |                    1                    |                      2                   |                  1                  |                   0                   |       4080   |
    |                    1                     |                    2                    |                      1                   |                  1                  |                   1                   |       3800   |

  Examples: 复杂折扣测试
    | Harry Potter and the Philosopher's Stone | Harry Potter and the Chamber of Secrets | Harry Potter and the Prisoner of Azkaban | Harry Potter and the Goblet of Fire | Harry Potter and the Order of Phoenix | lowest price |
    |                    2                     |                    2                    |                      2                   |                  1                  |                   1                   |       5120   |
    |                    5                     |                    5                    |                      4                   |                  5                  |                   4                   |       14120   |
