package com.david.codejourney.salestrategy.basket;

import org.junit.Test;


public class BasketTest {
    @Test
    public void noUniqueBooks() {
//        final Basket basket = new Basket(new Book(1), new Book(1));
//        Basket uniqueBasket = basket.atLeastUniqueBooks(2);
//        Assert.assertEquals(2, uniqueBasket.getBooks().size());
//        Assert.assertEquals(1, uniqueBasket.getBooks().get(0).hashCode());
//        Assert.assertEquals(1, uniqueBasket.getBooks().get(1).hashCode());
    }

    @Test
    public void twoUniqueBooks() {
//        final Basket basket = new Basket(new Book(1), new Book(2));
//        Basket uniqueBasket = basket.atLeastUniqueBooks(2);
//        Assert.assertEquals(0, uniqueBasket.getBooks().size());
    }

    @Test
    public void twoUniqueBooksAndSomeNoise() {
//        final Basket basket = new Basket(new Book(1), new Book(2), new Book(5), new Book(4));
//        Basket uniqueBasket = basket.atLeastUniqueBooks(2);
//        Assert.assertEquals(0, uniqueBasket.getBooks().size());
    }
    @Test
    public void fourUniqueBooks() {
//        final Basket basket = new Basket(new Book(1), new Book(2), new Book(5), new Book(4));
//        Basket uniqueBasket = basket.atLeastUniqueBooks(4);
//        Assert.assertEquals(0, uniqueBasket.getBooks().size());
    }
    @Test
    public void fourUniqueBooksAndSomeNoise1() {
//        final Basket basket = new Basket(new Book(1), new Book(2), new Book(3),new Book(5), new Book(4), new Book(3),new Book(2), new Book(4));
//        Basket uniqueBasket = basket.atLeastUniqueBooks(4);
//        Assert.assertEquals(0, uniqueBasket.getBooks().size());
    }
    @Test
    public void fourUniqueBooksAndSomeNoise2() {
//        final Basket basket = new Basket(new Book(1), new Book(2), new Book(3),new Book(5), new Book(4), new Book(3),new Book(5), new Book(4));
//        Basket uniqueBasket = basket.atLeastUniqueBooks(4);
//        Assert.assertEquals(0, uniqueBasket.getBooks().size());
    }
}
