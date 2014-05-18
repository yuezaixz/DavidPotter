package com.david.codejourney.salestrategy.calc.impl;

import com.david.codejourney.salestrategy.basket.Basket;
import com.david.codejourney.salestrategy.book.Book;
import com.david.codejourney.salestrategy.calc.ICalculate;
import com.david.codejourney.salestrategy.factory.BasketFactoryBean;
import com.david.codejourney.salestrategy.price.Price;
import com.david.codejourney.salestrategy.responsechain.handler.IHandler;
import com.david.codejourney.salestrategy.responsechain.handler.impl.FiveThreePatternHandler;
import com.david.codejourney.salestrategy.responsechain.handler.impl.MaxDifferentSeriesHandler;
import com.david.codejourney.salestrategy.strategy.PotterStrategy;

public class PriceCaclulate implements ICalculate {

    private Price calculatedPrice = new Price(0);
    
    private IHandler handler ;
    
    private PotterStrategy potterStrategy;
    
    private Basket potterBasket;
    
    public PriceCaclulate() {
        IHandler maxDiffenentSeriesHandler = new MaxDifferentSeriesHandler(null);
        potterStrategy = new PotterStrategy();
        handler = new FiveThreePatternHandler(
                maxDiffenentSeriesHandler);
        potterBasket = BasketFactoryBean.getPotterBasketFactoryInstance().getEmptyBasket();
    }

    public static void main(String[] args) {
        ICalculate cacluate = new PriceCaclulate();

        cacluate.putIntoBasket(PotterStrategy.getSeriesNumOfBookName(1), 1);
        cacluate.putIntoBasket(PotterStrategy.getSeriesNumOfBookName(2), 1);
//        cacluate.putIntoBasket(PotterStrategy.POTTER_SERIES_THREE_NAME, 2);
//        cacluate.putIntoBasket(PotterStrategy.POTTER_SERIES_FOUR_NAME, 1);
//        cacluate.putIntoBasket(PotterStrategy.POTTER_SERIES_FIVE_NAME, 2);

        cacluate.printBasket();
        cacluate.calculate();
        cacluate.printCalc();

    }

    public void printCalc() {
        System.out.println("购物车中的哈利波特故事书"+this.calculatedPrice);
    }

    /** (非 Javadoc) 
    * <p>Title: getCalculatedPrice</p> 
    * <p>Description: </p> 
    * @return 
    * @see com.david.codejourney.salestrategy.calc.ICalculate#getCalculatedPrice() 
    */
    @Override
    public Price getCalculatedPrice() {
        return calculatedPrice;
    }

    /** (非 Javadoc) 
    * <p>Title: setCalculatedPrice</p> 
    * <p>Description: </p> 
    * @param calculatedPrice 
    * @see com.david.codejourney.salestrategy.calc.ICalculate#setCalculatedPrice(com.david.codejourney.salestrategy.price.Price) 
    */
    @Override
    public void setCalculatedPrice(Price calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }

    /** (非 Javadoc) 
    * <p>Title: calculate</p> 
    * <p>Description: </p> 
    * @param potterBasket 
    * @see com.david.codejourney.salestrategy.calc.ICalculate#calculate(com.david.codejourney.salestrategy.basket.Basket) 
    */
    @Override
    public void calculate() {
        handler.handle(this, this.potterStrategy);
    }

    /** (非 Javadoc) 
    * <p>Title: fillSeriesBoxAndCalculatePrice</p> 
    * <p>Description: </p> 
    * @param basket 
    * @see com.david.codejourney.salestrategy.calc.ICalculate#fillSeriesBoxAndCalculatePrice(com.david.codejourney.salestrategy.basket.Basket) 
    */
    @Override
    public void fillSeriesBoxAndCalculatePrice() {
        int seriesNum = potterBasket.popForEachSeriesBox();
        switch (seriesNum) {
        case 1:
            calculatedPrice = calculatedPrice
                    .add(PotterStrategy.PRICE_FOR_EACH_BOOK_WITHOUT_DISCOUNT);
            break;
        case 2:
            calculatedPrice = calculatedPrice
                    .add(PotterStrategy.PRICE_FOR_EACH_BOOK_WITHOUT_DISCOUNT
                            .mul(2).mul(PotterStrategy.DISCOUNT_FOR_TWO_SERIES));
            break;
        case 3:
            calculatedPrice = calculatedPrice
                    .add(PotterStrategy.PRICE_FOR_EACH_BOOK_WITHOUT_DISCOUNT
                            .mul(3).mul(
                                    PotterStrategy.DISCOUNT_FOR_THREE_SERIES));
            break;
        case 4:
            calculatedPrice = calculatedPrice
                    .add(PotterStrategy.PRICE_FOR_EACH_BOOK_WITHOUT_DISCOUNT
                            .mul(4)
                            .mul(PotterStrategy.DISCOUNT_FOR_FOUR_SERIES));
            break;
        case 5:
            calculatedPrice = calculatedPrice
                    .add(PotterStrategy.PRICE_FOR_EACH_BOOK_WITHOUT_DISCOUNT
                            .mul(5)
                            .mul(PotterStrategy.DISCOUNT_FOR_FIVE_SERIES));
            break;
        default:
            throw new IllegalStateException(
                    "the number of series should be within "
                            + PotterStrategy.MAX_SERIES_NUMBER);
        }
    }

    @Override
    public void initialize() {
        calculatedPrice = new Price(0);
    }

    @Override
    public void putIntoBasket(String seriesName, int numberOfBook) {
        for (int i = 0; i < numberOfBook; i++) {
            potterBasket.push(seriesName, new Book());
        }
    }
    
    @Override
    public void putIntoBasket(int seriesNumOfBook, int numberOfBook) {
        
        String seriesName = PotterStrategy.getSeriesNumOfBookName(seriesNumOfBook);
        
        for (int i = 0; i < numberOfBook; i++) {
            potterBasket.push(seriesName, new Book());
        }
    }

    @Override
    public boolean areThereAnyBooksLeft() {
        return potterBasket.areThereAnyBooksLeft();
    }

    @Override
    public boolean hasFiveThreePattern() {
        return potterStrategy.hasFiveThreePattern(potterBasket);
    }

    @Override
    public void printBasket() {
        potterBasket.print();
    }
}