package com.david.codejourney.salestrategy.basket;

import com.david.codejourney.salestrategy.series.Series;
import com.david.codejourney.salestrategy.strategy.PotterStrategy;

public class PotterBasketFactory implements IBasketFactory {

    @Override
    public Basket getEmptyBasket() {
        return new PotterBasket(new Series(
                PotterStrategy.getSeriesNumOfBookName(1)), new Series(
                PotterStrategy.getSeriesNumOfBookName(2)), new Series(
                PotterStrategy.getSeriesNumOfBookName(3)), new Series(
                PotterStrategy.getSeriesNumOfBookName(4)), new Series(
                PotterStrategy.getSeriesNumOfBookName(5)));
    }

}
