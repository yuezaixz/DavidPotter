package com.david.codejourney.salestrategy.basket;

import java.util.Map;

import com.david.codejourney.salestrategy.factory.BasketFactoryBean;
import com.david.codejourney.salestrategy.price.Price;
import com.david.codejourney.salestrategy.series.Series;
import com.david.codejourney.salestrategy.strategy.PotterStrategy;

public class PotterBasket extends Basket {
    public PotterBasket(final Series... inputSeries) {
        super(inputSeries);
        this.factory = BasketFactoryBean.getPotterBasketFactoryInstance();
    }

    @Override
    public Price howMany() {
        return new Price(bookNum() * 8);
    }

    public void print() {
        StringBuffer sb = new StringBuffer();
        for (String bookName : seriesMap.keySet()) {
            sb.append(bookName).append("系列共")
                    .append(seriesMap.get(bookName).length()).append("本；\n");
        }
        System.out.println(sb.toString());
    }

    @Override
    public int[][] convertBasketToTwoDArray() {
        int[][] twoDArray = new int[PotterStrategy.MAX_SERIES_NUMBER][PotterStrategy.MAX_NUMBER_OF_COPIES_FOR_EACH_SERIES];
        Map<String, Series> series = seriesMap;
        int i = 0;

        for (Series serie : series.values()) {
            for (int j = 0; j < serie.length(); j++) {
                if (i >= PotterStrategy.MAX_SERIES_NUMBER
                        && j >= PotterStrategy.MAX_NUMBER_OF_COPIES_FOR_EACH_SERIES) {
                    throw new IllegalStateException(
                            "the 2-d array is only 5x10.");
                }
                twoDArray[i][j] = 1;
            }
            i++;
        }

        return twoDArray.clone();
    }
}
