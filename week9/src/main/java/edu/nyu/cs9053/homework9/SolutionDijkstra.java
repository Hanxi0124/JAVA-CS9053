package edu.nyu.cs9053.homework9;

public class SolutionDijkstra implements Philosopher {
	
	private final String philosopherName;
	
	public SolutionDijkstra(String philosopherName){
		this.philosopherName=philosopherName;
	}

	@Override
	public boolean attemptEat(Chopstick left, Chopstick right, Callback callback) {
		if(left.isChopstickUsed()==false){
			if(right.isChopstickUsed()==false){
				if(smallChopstick(left,right)){
					left.use();
					callback.pickedUpChopstick(left);
					right.use();
					callback.pickedUpChopstick(right);		
				}else{
					right.use();
					callback.pickedUpChopstick(right);
					left.use();
					callback.pickedUpChopstick(left);	
				}
			}
			return true;
		}
		doneEating(left,right,callback);
		return false;
	}
	
	@Override
	public void doneEating(Chopstick left, Chopstick right, Callback callback) {
		left.putDown();
		right.putDown();
		callback.putDownChopstick(left);
		callback.putDownChopstick(right);
	}
	
	@Override
	public String getName() {
		return philosopherName;
	}
	
	protected static boolean smallChopstick(Chopstick chopStick1,Chopstick chopStick2){
		if(chopStick1.getNumberAroundTable()<chopStick2.getNumberAroundTable()){
			return true;
		}else{
			return false;
		}
			
	}
}
