package com.david.codejourney.salestrategy.book;

import java.util.UUID;


public class Book implements Comparable<Book> {

	private final String no;

	public Book() {
        this.no = UUID.randomUUID().toString();
    }
	
	public Book(String no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return no;
	}

	@Override
	public boolean equals(final Object obj) {
		return ((Book) obj).no == no;
	}

	@Override
	public int hashCode() {
		return no.hashCode();
	}

    @Override
    public int compareTo(Book targetBook) {
        return no.compareTo(targetBook.no);
    }

}
