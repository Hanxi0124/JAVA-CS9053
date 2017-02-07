package edu.nyu.cs9053.homework3.metadata;
import edu.nyu.cs9053.homework3.metadata.*;
public class FixMe {

    private String name;
    final String secondary;

    public FixMe(String name) {
	this.name = name;
    this.secondary=null;
    }

    //creating a constructor with no argument
    public FixMe() {
	this.name = null;
    this.secondary=null;
    }

    public FixMe(String name, String secondary) {
        this.name = name;
        this.secondary = new FixMeToo(true).analyzeMetadata(secondary);
    }

    public FixMe changeName(String name) {
        return new FixMe(name);
    }

    public FixMe changeName(String firstName, String lastName,String secondary) {
        return new FixMe(changeName(firstName, lastName), secondary);
    }

    public String changeName(String firstName, String lastName) {
        return String.format("%s %s", firstName, lastName);
    }
}
