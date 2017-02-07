package edu.nyu.cs9053.homework7.inventory;

public class Publisher<T extends Book> implements Item {
	private final Double price;
	private final T book;
	
	public Publisher(Double price, T book){
		this.price=price;
		this.book=book;
	}
	
	@Override public Double getPrice(){
		return price;
	}
	
	public T getBookPublisher(){
		return book;
	}

}
