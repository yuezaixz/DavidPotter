package com.david.codejourney.salestrategy.price;

public class Price {

	private final double price;

	public Price(final double price) {
		this.price = price;
	}
	
	public double getPrice() {
        return price;
    }

    public String toString() {
		return "Price: " + Double.toString(price);
	}

	public boolean equals(final Object obj) {
		return ((Price) obj).price == price;
	}

	public int hashCode() {
		return new Double(price).hashCode();
	}

	public Price lowestPrice(final Price other) {
		return new Price(Math.min(price, other.price));
	}

	public Price add(final Price other) {
		return new Price(price + other.price);
	}
	
	public Price minus(final Price other) {
        return new Price(price - other.price);
    }
	
	public Price mul(final Price other) {
        return new Price(price * other.price);
    }
	
	public Price mul(final int mulNum) {
	    return new Price(price * mulNum);
	}
	
	public Price mul(final double mulNum) {
        return new Price(price * mulNum);
    }

}
