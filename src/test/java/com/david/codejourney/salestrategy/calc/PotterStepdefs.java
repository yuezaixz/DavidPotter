package com.david.codejourney.salestrategy.calc;

import static org.junit.Assert.assertEquals;

import com.david.codejourney.salestrategy.calc.impl.PriceCaclulate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Potter Step Definitions
 * User: Ben
 * Date: 13-7-31
 * Time: 下午5:45
 * To change this template use File | Settings | File Templates.
 */
public class PotterStepdefs {
    private ICalculate calc = new PriceCaclulate();

    @Given("^开始我先要初始化我的购物车$")
    public void I_clear_my_shopping_basket() throws Throwable {
        calc.initialize();
    }

    @Given("^我购买 (\\d+) 系列 (\\d+)(?:st|nd|rd|th) 本书$")
    public void I_buy_copies_of_book(int numberOfBook,int seriesNumberOfBook) throws Throwable {
        System.out.println("wudw"+seriesNumberOfBook);
        calc.putIntoBasket(seriesNumberOfBook, numberOfBook);
    }
    @When("^我计算购物车的总价$")
    public void I_calculate_the_price() throws Throwable {
        calc.calculate();
    }

    @Then("^我最少应该付 (\\d+)$")
    public void I_should_get_the_lowest_price(int expectedPrice) throws Throwable {
        int price = (int) (calc.getCalculatedPrice().getPrice());
        assertEquals("错误 - 计算结果与期望值不一致", expectedPrice, price);
    }

}
