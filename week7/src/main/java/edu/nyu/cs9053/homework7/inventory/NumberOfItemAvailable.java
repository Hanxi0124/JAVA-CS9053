package edu.nyu.cs9053.homework7.inventory;

public class NumberOfItemAvailable<T extends Item> implements Item {
	private final Double price;
	private final T item;
	
	@Override public Double getPrice(){
		return price;
	}
	
	public NumberOfItemAvailable(Double price, T item){
		this.price=price;
		this.item=item;
	}
	
	public T getNumberOfItemAvailable(){
		return item;
	}
	

}
