package edu.nyu.cs9053.homework7.inventory;

public class Book implements Item {
	private final Double price;
	private final String title;
	
	public Book(Double price,String title){
		this.price=price;
		this.title=title;
	}
	
	@Override
	public Double getPrice(){
		return price;
	}
	
	public String getTitle(){
		return title;
	}

}
