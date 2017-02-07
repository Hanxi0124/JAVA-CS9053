package edu.nyu.cs9053.homework7.inventory;

public class ComputerRack<T extends Computer> implements Item {
	
	private final Double price;
	private final T computer;
	
	public ComputerRack(Double price, T computer){
		this.price=price;
		this.computer=computer;
	}
	@Override public Double getPrice(){
		return price;
	}
	
	public T getComputerRack(){
		return computer;
	}

}
