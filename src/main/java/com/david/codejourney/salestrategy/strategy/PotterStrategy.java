package com.david.codejourney.salestrategy.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.david.codejourney.salestrategy.basket.Basket;
import com.david.codejourney.salestrategy.price.Price;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-8-1
 * Time: 下午7:41
 * To change this template use File | Settings | File Templates.
 */
public class PotterStrategy {
    private static final Logger LOGGER = Logger.getLogger(PotterStrategy.class.getName());
    
    public static final List<String> POTTER_SERIES_NAME_LIST = new ArrayList<String>();
    static{
        POTTER_SERIES_NAME_LIST.add("Harry Potter and the Philosopher's Stone");
        POTTER_SERIES_NAME_LIST.add("Harry Potter and the Chamber of Secrets");
        POTTER_SERIES_NAME_LIST.add("Harry Potter and the Prisoner of Azkaban");
        POTTER_SERIES_NAME_LIST.add("Harry Potter and the Goblet of Fire");
        POTTER_SERIES_NAME_LIST.add("Harry Potter and the Order of Phoenix");
    }
    
    public static final Price PRICE_FOR_EACH_BOOK_WITHOUT_DISCOUNT = new Price(800);
    public static final int MAX_SERIES_NUMBER = 5;
    public static final Price CHEAPER_BY_FIVE_THREE_PATTERN = new Price(40);
    public static final int FIVE_THREE_PATTERN_FIVE = 5;
    public static final int FIVE_THREE_PATTERN_THREE = 3;
    public static final int MAX_NUMBER_OF_COPIES_FOR_EACH_SERIES = 10;
    public static final double DISCOUNT_FOR_TWO_SERIES = 0.95;
    public static final double DISCOUNT_FOR_THREE_SERIES = 0.9;
    public static final double DISCOUNT_FOR_FOUR_SERIES = 0.8;
    public static final double DISCOUNT_FOR_FIVE_SERIES = 0.75;
    private int[] differentSeriesCount = new int[PotterStrategy.MAX_NUMBER_OF_COPIES_FOR_EACH_SERIES];

    public PotterStrategy() {
        // To turn on logging, set level to be Level.INFO.
        LOGGER.setLevel(Level.OFF);
    }

    public boolean hasFiveThreePattern(Basket shoppingBasket) {
        int[][] basketTwoDArray = shoppingBasket.convertBasketToTwoDArray();
        countDifferentSeries(basketTwoDArray);
        for (int i = 0; i < differentSeriesCount.length - 1; i++) {
            LOGGER.info("==Going to check differentSeriesCount[" + i + "]: " + differentSeriesCount[i] + "; differentSeriesCount[" + (i+1) + "]: " + differentSeriesCount[i+1]);
            if (differentSeriesCount[i] == FIVE_THREE_PATTERN_FIVE && differentSeriesCount[i+1] == FIVE_THREE_PATTERN_THREE) {
                LOGGER.info("==Found five three pattern.");
                return true;
            }
        }
        return false;
    }

    public void countDifferentSeries(int[][] basketTwoDArray) {
        int count = 0;
        for (int i = 0; i < differentSeriesCount.length; i++) {
            for (int j = 0; j < basketTwoDArray.length; j++) {
                count += basketTwoDArray[j][i];
            }
            differentSeriesCount[i] = count;
            count = 0;
        }
        printDifferentSeriesCount(differentSeriesCount);
    }

    private void printDifferentSeriesCount(int[] differentSeriesCount) {
        LOGGER.info("==different series count: " + Arrays.toString(differentSeriesCount));
    }

    public static String getSeriesNumOfBookName(int seriesNumOfBook) {
        return POTTER_SERIES_NAME_LIST.get(seriesNumOfBook-1);
    }
}
