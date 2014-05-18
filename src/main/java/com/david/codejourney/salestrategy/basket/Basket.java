package com.david.codejourney.salestrategy.basket;

import java.util.HashMap;
import java.util.Map;

import com.david.codejourney.salestrategy.book.Book;
import com.david.codejourney.salestrategy.price.Price;
import com.david.codejourney.salestrategy.series.Series;

public abstract class Basket {

    Map<String, Series> seriesMap = new HashMap<String, Series>();

    protected IBasketFactory factory;

    protected Basket(final Series... inputSeries) {
        for (final Series serie : inputSeries) {
            this.seriesMap.put(serie.getSeriesName(), serie);
        }
    }

    public int getNoEmptySeriesSize() {
        int num = 0;
        for (Series serie : seriesMap.values()) {
            if (!serie.isEmpty()) {
                num++;
            }
        }
        return num;
    }

    public abstract Price howMany();
    
    public abstract void print();

    public boolean areThereAnyBooksLeft() {
        for (Series serie : seriesMap.values()) {
            if (!serie.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int bookNum() {
        int bookNum = 0;
        for (Series serie : seriesMap.values()) {
            bookNum += serie.length();
        }
        return bookNum;
    }

    public boolean push(String name, Book... books) {
        Series series = seriesMap.get(name);
        if (series == null) {
            return false;
        }
        for (Book book : books) {
            series.push(book);
        }
        return true;
    }
    
    public int popForEachSeriesBox() {
        int num = 0;
        for (Series serie : seriesMap.values()) {
            if (!serie.isEmpty()) {
                serie.pop();
                num++;
            }
        }
        return num;
    }

    public Basket pop(int bookNum) {
        Basket emptyBasket = factory.getEmptyBasket();
        int noEmptySeriesSize = getNoEmptySeriesSize();
        if (noEmptySeriesSize >= bookNum) {
            for (Series serie : seriesMap.values()) {
                if (!serie.isEmpty()) {
                    emptyBasket.push(serie.getSeriesName(), serie.pop());
                }
            }
        }
        return emptyBasket;
    }

    public Book popByName(int seriesName) {
        Series series = seriesMap.get(seriesName);
        return series.isEmpty() ? null : series.pop();
    }

    public abstract int[][] convertBasketToTwoDArray();

    @Override
    public String toString() {
        return seriesMap.toString();
    }

    public boolean equals(final Object obj) {
        Basket target = (Basket) obj;

        return this.seriesMap.equals(target.seriesMap);
    }

}
