package com.david.codejourney.salestrategy.responsechain.handler;

import com.david.codejourney.salestrategy.calc.ICalculate;
import com.david.codejourney.salestrategy.strategy.PotterStrategy;

/**
 * User: David Date: 14-04-18 Time: 下午7:03
 */
public abstract class PotterHandler implements IHandler {
    private IHandler nextHandler;

    public PotterHandler(IHandler priceHandler) {
        this.nextHandler = priceHandler;
    }

    public void handle(ICalculate calc, PotterStrategy discountStrategy) {
        run(calc, discountStrategy);
        IHandler nextHandler = getNextHandler();
        if (nextHandler != null) {
            nextHandler.handle(calc, discountStrategy);
        }
    }

    public abstract void run(ICalculate calc, PotterStrategy discountStrategy);

    protected IHandler getNextHandler() {
        return nextHandler;
    }
}
