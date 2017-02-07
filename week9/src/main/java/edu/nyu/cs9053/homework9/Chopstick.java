package edu.nyu.cs9053.homework9;
import java.util.concurrent.Semaphore;
import java.lang.InterruptedException;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 7:54 AM
 */
public class Chopstick {

    private final int numberAroundTable;
    private boolean chopstickTaken=false;
    private final Semaphore semaphore=new Semaphore(1);

    public Chopstick(int numberAroundTable) {
        this.numberAroundTable = numberAroundTable;
    }

    public int getNumberAroundTable() {
        return numberAroundTable;
    }
    
    public void use(){
    	try{
    		semaphore.acquire();
    		chopstickTaken=true;    		
    	}catch(InterruptedException ie ){
    		chopstickTaken=false;
    	}
    }
    
    public void putDown(){
    	chopstickTaken=false;
    	semaphore.release();
    }
    
    public boolean isChopstickUsed(){
    	return chopstickTaken;
    }
}
