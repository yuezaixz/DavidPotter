package com.david.codejourney.salestrategy.responsechain.handler;

import com.david.codejourney.salestrategy.basket.Basket;
import com.david.codejourney.salestrategy.calc.ICalculate;
import com.david.codejourney.salestrategy.strategy.PotterStrategy;

public interface IHandler {
    public void handle(ICalculate calc, PotterStrategy discountStrategy);
}
