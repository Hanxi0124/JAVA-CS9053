package edu.nyu.cs9053.homework7;
import edu.nyu.cs9053.homework7.inventory.Item;
/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:57 PM
 */
public class Warehouse {

    private static void copy(Bin<? extends Item> from, Bin<? super Item> into) {
	// TODO - copy values in 'from' to 'into'
    	for(Item item:from){
    		into.add(item);
    	}
    }

    // TODO - implement such that the warehouse can hold any Bin of Item type
    private final Bin<Item> items;//to ensure objects don't come from any where other than Item

    public Warehouse(Bin<Item> items) {
        this.items = items;
    }

    public Bin<Item> getItems() {
        return items;
    }

    public Warehouse copy() {
        // TODO - make a new Bin copying the values from `items` into a new Bin using the 'copy' method below
    	Bin<Item> binObject=new Bin<>();
    	copy(items,binObject);
        // TODO - change to return a copied bin
        return new Warehouse(binObject);
    }

}
