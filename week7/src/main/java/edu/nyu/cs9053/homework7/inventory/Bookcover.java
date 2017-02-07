package edu.nyu.cs9053.homework7.inventory;

public class Bookcover<T extends Book> implements Item{
	private final Double price;
	private final T book;
	
	public Bookcover(Double price,T book){
		this.price=price;
		this.book=book;
	}
	
	@Override public Double getPrice(){
		return price;
	}
	
	public T getBook(){
		return book;
	}
	

}
