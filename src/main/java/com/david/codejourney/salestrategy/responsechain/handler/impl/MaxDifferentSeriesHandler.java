package com.david.codejourney.salestrategy.responsechain.handler.impl;

import com.david.codejourney.salestrategy.calc.ICalculate;
import com.david.codejourney.salestrategy.responsechain.handler.IHandler;
import com.david.codejourney.salestrategy.responsechain.handler.PotterHandler;
import com.david.codejourney.salestrategy.strategy.PotterStrategy;

public class MaxDifferentSeriesHandler extends PotterHandler {

    public MaxDifferentSeriesHandler(IHandler priceHandler) {
        super(priceHandler);
    }

    @Override
    public void run(ICalculate calc, PotterStrategy discountStrategy) {
        while (calc.areThereAnyBooksLeft()) {
            calc.fillSeriesBoxAndCalculatePrice();
        }
    }

}
