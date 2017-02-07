package edu.nyu.cs9053.homework9;

public class SolutionWaiter implements Philosopher {
	
	private final Waiter waiterObj;
	private final String name;
	
	public SolutionWaiter(Waiter waiter, String name){
		this.waiterObj=waiter;
		this.name=name;
	}

	@Override
	public boolean attemptEat(Chopstick left, Chopstick right, Callback callback) {
		if(waiterObj.permissionGranted()){
			callback.pickedUpChopstick(left);
			callback.pickedUpChopstick(right);
			return true;
		}
		return false;
	}

	@Override
	public void doneEating(Chopstick left, Chopstick right, Callback callback) {
		waiterObj.doneEating();
		callback.putDownChopstick(left);
		callback.putDownChopstick(right);		
	}

	@Override
	public String getName() {
		return name;
	}
}
