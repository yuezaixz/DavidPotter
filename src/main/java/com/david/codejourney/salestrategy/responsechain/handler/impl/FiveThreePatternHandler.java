package com.david.codejourney.salestrategy.responsechain.handler.impl;

import com.david.codejourney.salestrategy.calc.ICalculate;
import com.david.codejourney.salestrategy.responsechain.handler.IHandler;
import com.david.codejourney.salestrategy.responsechain.handler.PotterHandler;
import com.david.codejourney.salestrategy.strategy.PotterStrategy;

public class FiveThreePatternHandler extends PotterHandler {

    public FiveThreePatternHandler(IHandler wordHandler) {
        super(wordHandler);
    }
    @Override
    public void run(ICalculate calc, PotterStrategy discountStrategy) {
        if (calc.hasFiveThreePattern()) {
            calc.setCalculatedPrice(calc.getCalculatedPrice().minus(PotterStrategy.CHEAPER_BY_FIVE_THREE_PATTERN));
        }
    }

}
