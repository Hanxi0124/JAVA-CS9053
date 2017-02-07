package edu.nyu.cs9053.homework9.jellybean;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class ProducerImplementation implements Producer {
	
	private static final Flavor[] flavor= Flavor.values();
	private final Semaphore semaphoreObj;

	@Override
	public JellyBean produce(JellyBeanContainer into) {
		try{
			semaphoreObj.acquire();
			JellyBean jellyBean= new JellyBean(flavor[new Random().nextInt(flavor.length)]);
			if(argumentCheckerOfJBContainer(into).atCapacity()){
				return null;
			}
			into.add(jellyBean);
			return jellyBean;
		}
		catch(InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        finally {
            semaphoreObj.release();
        }
	}
	
	
	private static JellyBeanContainer argumentCheckerOfJBContainer(JellyBeanContainer jbContainer){
		if(jbContainer==null){
			throw new IllegalArgumentException("JellyBeanContainer Found Null");
		}
		return jbContainer;
	}
	
	
	public ProducerImplementation(Semaphore semaphoreObj){
		this.semaphoreObj=semaphoreObj;
	}
}
