package edu.nyu.cs9053.homework7.inventory;

public class Brand<T extends Item> implements Item {
	private final Double price;
	private final T brandName;
	
	@Override public Double getPrice(){
		return price;
	}
	
	public Brand(Double price, T brandName){
		this.price=price;
		this.brandName=brandName;
	}
	
	public T getBrand(){
		return brandName;
	}
	
	

}
