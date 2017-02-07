package edu.nyu.cs9053.homework7.inventory;

public class ElectronicCover<T extends Electronic> implements Item {
	private final Double price;
	private final T electronic; //check if its appropriate Name
	
	public ElectronicCover(Double price,T electronic){
		this.price=price;
		this.electronic=electronic;
	}
	
	@Override public Double getPrice(){
		return price;
	}
	
	public T getElectronicCover(){
		return electronic;
	}

}
