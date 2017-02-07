package edu.nyu.cs9053.homework9;
import java.util.concurrent.Semaphore;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 8:49 AM
 */
public class Waiter {
	
	private final Semaphore semaphoreObject=new Semaphore(1);
	public static boolean permission=false;
	
	public boolean permissionGranted(){
		try{
			semaphoreObject.acquire();
			return true;
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		return false;
	}
		
	public void doneEating(){
		semaphoreObject.release();
	}
}
