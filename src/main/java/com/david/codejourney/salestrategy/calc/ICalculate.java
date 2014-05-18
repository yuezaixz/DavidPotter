package com.david.codejourney.salestrategy.calc;

import com.david.codejourney.salestrategy.price.Price;

public interface ICalculate {

    public abstract Price getCalculatedPrice();

    public abstract void setCalculatedPrice(Price calculatedPrice);

    public abstract void calculate();
    
    public void printCalc();

    public abstract void fillSeriesBoxAndCalculatePrice();

    public abstract void initialize();

    public abstract void putIntoBasket(String seriesName, int numberOfBook);

    public abstract void putIntoBasket(int seriesNumberOfBook, int numberOfBook);
    
    public abstract boolean areThereAnyBooksLeft();

    public abstract boolean hasFiveThreePattern();

    public abstract void printBasket();


}