package edu.nyu.cs9053.homework7;
import edu.nyu.cs9053.homework7.inventory.*;
/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:58 PM
 */
public class WarehouseInventoryAuditor {

    // TODO - create a method to print the individual prices of a Bin of any Item type
	public void printPriceOfAnyType(Bin<Item> bin){
		printPrice(bin);
	}

    // TODO - create a method to print the individual prices of a Bin of any Electronic types
	public void printPriceOfElectronicType(Bin<Electronic> bin){
		printPrice(bin);
	}

    // TODO - create a method to print the individual prices of a Bin of any Book types
	public void printPriceOfBookType(Bin<Book> bin){
		printPrice(bin);
	}
	
	public void printPrice(Bin<? extends Item> bin){
		for(Item item: bin){ //Item from concept of polymorphism
			System.out.println(item.getPrice());
		}
	}

}
