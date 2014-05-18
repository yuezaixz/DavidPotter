package com.david.codejourney.salestrategy.series;

import com.david.codejourney.salestrategy.book.Book;

public class Series implements ISeries {
    private Book[] books = new Book[16];

    private int size = 0;

    private String seriesName;

    public Series(String seriesName) {
        this.seriesName = seriesName;
    }
    
    public Series(String seriesName,Book ... books) {
        this.seriesName = seriesName;
        this.books = books;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        // 将数组中的数据置为null, 方便GC进行回收
        for (int i = 0; i < size; i++) {
            books[size] = null;
        }
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(Book data) {
        // 判断是否需要进行数组扩容
        if (size >= books.length) {
            resize();
        }
        books[size++] = data;
        return true;
    }

    /**
     * 数组扩容
     */
    private void resize() {
        Book[] temp = new Book[books.length * 3 / 2 + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = books[i];
            books[i] = null;
        }
        books = temp;
    }

    @Override
    public Book pop() {
        if (size == 0) {
            return null;
        }
        return (Book) books[--size];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayStack: [");
        for (int i = 0; i < size; i++) {
            sb.append(books[i].toString());
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
